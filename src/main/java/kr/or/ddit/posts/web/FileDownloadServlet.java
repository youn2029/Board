package kr.or.ddit.posts.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.model.AttachedFileVO;
import kr.or.ddit.posts.service.AttachedFileService;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터
		int file_no = Integer.parseInt(request.getParameter("file_no"));
		
		// 첨부파일 정보
		AttachedFileService fileService = new AttachedFileService();
		AttachedFileVO fileVo = fileService.getFile(file_no);
		
		// response
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileVo.getFile_name() +"\"");
		response.setContentType("application/octet-stream");
		
		// 물리파일명을 이용하여 사진 다운로드부터 진행
		String file = fileVo.getFile_path() + File.separator + fileVo.getFile_upload();
		
		// file 입출력을 위한 준비
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
		// TODO Auto-generated method stub
	}

}
