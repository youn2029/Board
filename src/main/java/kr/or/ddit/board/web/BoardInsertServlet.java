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
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// session에 있는 학생 정보
		HttpSession session = request.getSession();
		StudentVO stdVo = (StudentVO) session.getAttribute("stdVo");
		
		String board_name = request.getParameter("board_name");
		
		// parameter을 board객체에 저장
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(request.getParameter("board_use"));
		boardVo.setId(stdVo.getId());
		boardVo.setStd_id(stdVo.getStd_id());
		
		// insert
		BoardServiceInf boardService = new BoardService();
		int resultCnt = boardService.insertBoard(boardVo);
		
		if (resultCnt==1) {
			List<BoardVO> usableBoardList = boardService.getUsableListBoard();
			List<BoardVO> boardList = boardService.getListBoard();
			
			// session에 저장
			session.setAttribute("usableBoardList", usableBoardList);
			
			// request에 저장
			request.setAttribute("boartList", boardList);
		}
		
		response.sendRedirect(request.getContextPath()+"/boardList");
		
	}

}
