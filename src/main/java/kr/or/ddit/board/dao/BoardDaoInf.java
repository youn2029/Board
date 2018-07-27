package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoInf {
	
	/**
	* Method : getListBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	List<BoardVO> getListBoard();
	
	/**
	* Method : getUsableListBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 사용가능한 게시판 조회
	*/
	List<BoardVO> getUsableListBoard();
	
	/**
	* Method : getBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 정보 조회
	*/
	BoardVO getBoard(int board_no);
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	int insertBoard(BoardVO boardVo);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(BoardVO boardVo);
}
