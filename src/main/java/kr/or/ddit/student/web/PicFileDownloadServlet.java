package kr.or.ddit.student.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.student.model.StudentVO;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/pic")
public class PicFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// session
		HttpSession session = request.getSession();
		StudentVO stdVo = (StudentVO) session.getAttribute("stdVo");
		
		// response
		response.setHeader("Content-Disposition", "attachment; filename=\""+ stdVo.getPic() +"\"");
		response.setContentType("application/octet-stream");
				
		// 물리파일명을 이용하여 사진 다운로드부터 진행
		String file = stdVo.getPicpath()+ File.separator + stdVo.getPicname();
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len;
		
		while ((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
