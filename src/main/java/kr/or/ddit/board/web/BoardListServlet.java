package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용가능한 게시판 정보 가져오기
		BoardServiceInf boardService = new BoardService();
		List<BoardVO> boardList = boardService.getListBoard();
		
		// request에 저장
		request.setAttribute("boardList", boardList);
		
		// board.jsp로 위임
		request.getRequestDispatcher(request.getContextPath()+"/board.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
