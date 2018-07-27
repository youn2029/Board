package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.posts.service.PostsService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostListServlet
 */
@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		// board 정보
		BoardServiceInf boardService = new BoardService();
		BoardVO boardVo = boardService.getBoard(board_no);
		
		// paramMap 선언
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("board_no", board_no);
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);		
		
		// 게시글 조회		
		PostsServiceInf postsService = new PostsService();
		Map<String, Object> resultMap = postsService.getListPost(paramMap);		
		
		// request 저장
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("postPageList", resultMap.get("postPageList"));
		request.setAttribute("nav", resultMap.get("nav"));
		
		// postList.jsp로 위임
		request.getRequestDispatcher("/posts/postList.jsp").forward(request, response);
		
	}

}
