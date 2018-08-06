package kr.or.ddit.student.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.posts.web.FileUtil;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServicetInf;

/**
 * Servlet implementation class studentUpdateViewServlet
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class studentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 학생 정보 수정 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /student/studentUpdate.jsp 요청 위임
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);
		
	}
	
	// 학생 정보 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// session
		HttpSession session = request.getSession();
		StudentVO stdVo = (StudentVO) session.getAttribute("stdVo");
				
		// 파라미터 확인
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String name = request.getParameter("name");
		
		Part picPart = request.getPart("pic");		
		
		// 파라미터로 받은 값을 vo에 설정
		stdVo.setName(name);
		stdVo.setAddr1(addr1);
		stdVo.setAddr2(addr2);
		stdVo.setZipcd(zipcd);
		
		
		// if(프로필 이미지를 안올렸을 경우) : 기존 이미지 사용
		// db에 있는 값을 조회해서 사용
		if(picPart.getSize() > 0){
			// 업로드 당시 파일명 (pic)
			// uuid를 통해 임의의 파일명을 하나 작성 (picname)
			// 업로드 할 경로 (FileUtil.uploadPath)
			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			stdVo.setPic(pic);
			stdVo.setPicpath(picpath);
			stdVo.setPicname(picname);
			
			// 화면에 출력
			picPart.write(picpath+File.separator+picname);
			picPart.delete();
		}
		
//		// 학생 정보 업데이트
//		StudentServicetInf stdService = new StudentService();
//		int updateCnt = stdService.studentUpdate(stdVo);
//		
//		// 학생 정보 상세조회 화면으로 이동
//		response.sendRedirect("/studentDetail?id="+id);
			
	}

}
