package kr.or.ddit.student.web;

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
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServicetInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// post방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");		
		
		// 파라미터(id, pass)값 가져오기
		String std_id = request.getParameter("std_id");
		String pass = request.getParameter("pass");
		
		// id,pass에 해당하는 student객체 가져오기
		StudentServicetInf stdService = new StudentService();
		StudentVO stdVo = stdService.getStudent(std_id);
		
		// 게시판 메뉴정보 가져오기
		BoardServiceInf boardService = new BoardService();
		List<BoardVO> usableBoardList = boardService.getUsableListBoard();
		
		// pass 암호화
		String encPass = KISA_SHA256.encrypt(pass);
		
		// 맞았을 때, 틀렸을 때
		if(stdVo != null && stdVo.getPass().equals(encPass)){
			// session
			HttpSession session = request.getSession();
						
			// 학생 정보와 게시판 정보를 session에 저장
			session.setAttribute("stdVo", stdVo);
			session.setAttribute("usableBoardList", usableBoardList);
			
			// main.jsp로 위임
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}else {
			
			// login.jsp로 위임
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
		
	}

}
