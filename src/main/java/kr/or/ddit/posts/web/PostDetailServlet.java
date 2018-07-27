package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.dao.AttachedFileDao;
import kr.or.ddit.posts.model.AttachedFileVO;
import kr.or.ddit.posts.model.PostsVO;
import kr.or.ddit.posts.model.RecommentVO;
import kr.or.ddit.posts.service.AttachedFileService;
import kr.or.ddit.posts.service.AttachedFileServiceInf;
import kr.or.ddit.posts.service.PostsService;
import kr.or.ddit.posts.service.PostsServiceInf;
import kr.or.ddit.posts.service.RecService;
import kr.or.ddit.posts.service.RecServiceInf;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 상세보기 화면으로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// 게시글 조회
		PostsServiceInf postsService = new PostsService();
		PostsVO postsVo = postsService.getPost(post_no);
		
		// 댓글 조회
		RecServiceInf recService = new RecService();
		List<RecommentVO> recList = recService.getRec(post_no);
		
		// 첨부파일 조회
		AttachedFileServiceInf fileService = new AttachedFileService();
		List<AttachedFileVO> fileList = fileService.getFileList(post_no);
		
		// request에 저장
		request.setAttribute("postVo", postsVo);
		request.setAttribute("recList", recList);
		request.setAttribute("fileList", fileList);
		
		// postDetail.jsp에 위임
		request.getRequestDispatcher("/posts/postDetail.jsp").forward(request, response);
	}
	
	// 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
	}

}
