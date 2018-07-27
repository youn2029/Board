package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : getListBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	@Override
	public List<BoardVO> getListBoard() {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> boardList = session.selectList("board.getListBoard");
		session.close();
		
		return boardList;
	}

	/**
	* Method : getUsableListBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 사용가능한 게시판 조회
	*/
	@Override
	public List<BoardVO> getUsableListBoard() {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> boardUsableList = session.selectList("board.getUsableListBoard");
		session.close();
		
		return boardUsableList;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	@Override
	public int insertBoard(BoardVO boardVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	@Override
	public int updateBoard(BoardVO boardVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}

	/**
	* Method : getBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 정보 조회
	*/
	@Override
	public BoardVO getBoard(int board_no) {
		
		SqlSession session = sqlSessionFactory.openSession();
		BoardVO boardVo = session.selectOne("board.getBoard", board_no);
		session.close();
		
		return boardVo;
	}

}
