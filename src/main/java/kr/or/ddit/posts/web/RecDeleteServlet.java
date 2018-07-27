package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.service.RecService;
import kr.or.ddit.posts.service.RecServiceInf;

/**
 * Servlet implementation class RecDeleteServlet
 */
@WebServlet("/recDelete")
public class RecDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	// 댓글 삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터
		int rec_no = Integer.parseInt(request.getParameter("rec_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// update
		RecServiceInf recService = new RecService();
		int resultCnt = recService.deleteRec(rec_no);
		
		//postDetail로 위임
		response.sendRedirect(request.getContextPath()+"/postDetail?post_no="+post_no);
	}

}
