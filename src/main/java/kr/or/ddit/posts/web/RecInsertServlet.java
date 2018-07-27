package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.posts.model.RecommentVO;
import kr.or.ddit.posts.service.RecService;
import kr.or.ddit.posts.service.RecServiceInf;
import kr.or.ddit.student.model.StudentVO;

/**
 * Servlet implementation class RecInsertServlet
 */
@WebServlet("/recInsert")
public class RecInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 댓글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터
		String rec_content = request.getParameter("rec_content");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// session
		HttpSession session = request.getSession();
		StudentVO stdVo = (StudentVO) session.getAttribute("stdVo");
		
		// recVo
		RecommentVO recVo = new RecommentVO();
		recVo.setId(stdVo.getId());
		recVo.setStd_id(stdVo.getStd_id());
		recVo.setPost_no(post_no);
		recVo.setRec_content(rec_content);
		
		// insert
		RecServiceInf recService = new RecService();
		int resultCnt = recService.insertRec(recVo);
		
		//postDetail로 위임
		response.sendRedirect(request.getContextPath()+"/postDetail?post_no="+post_no);
	}

}
