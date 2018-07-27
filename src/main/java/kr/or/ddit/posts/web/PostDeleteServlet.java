package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.model.PostsVO;
import kr.or.ddit.posts.service.PostsService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostDeleteServlet
 */
@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		// 게시글 정보
		PostsServiceInf postsService = new PostsService();
		int resultCnt = postsService.deletePost(post_no);
		
		// postList.jsp로 위임
		response.sendRedirect(request.getContextPath()+"/postList?board_no="+board_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
