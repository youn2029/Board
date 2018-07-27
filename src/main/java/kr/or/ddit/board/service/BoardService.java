package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;

public class BoardService implements BoardServiceInf {
	
	private BoardDaoInf boardDao = new BoardDao();

	@Override
	public List<BoardVO> getListBoard() {
		return boardDao.getListBoard();
	}

	@Override
	public List<BoardVO> getUsableListBoard() {
		return boardDao.getUsableListBoard();
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public BoardVO getBoard(int board_no) {
		return boardDao.getBoard(board_no);
	}

}
