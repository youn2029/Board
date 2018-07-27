package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// parameter을 board객체에 저장
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_name(request.getParameter("board_name"));
		boardVo.setBoard_use(request.getParameter("board_use"));
		boardVo.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		
		System.out.println(boardVo.getBoard_name()+", "+boardVo.getBoard_use()+", "+boardVo.getBoard_no());
		
		// update
		BoardServiceInf boardService = new BoardService();
		int resultCnt = boardService.updateBoard(boardVo);
		
		if (resultCnt==1) {
			List<BoardVO> usableBoardList = boardService.getUsableListBoard();
			List<BoardVO> boardList = boardService.getListBoard();
			
			// session에 저장
			HttpSession session = request.getSession();
			session.setAttribute("usableBoardList", usableBoardList);
			
			// request에 저장
			request.setAttribute("boartList", boardList);
		}
		
		response.sendRedirect(request.getContextPath()+"/boardList");
	}

}
