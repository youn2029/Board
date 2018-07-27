package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf boardDao;
	private BoardVO boardVo;
	
	@Before
	public void setUp(){
		boardDao = new BoardDao();
		boardVo = new BoardVO();
	}

	/**
	* Method : getListBoardTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 전체 조회
	*/
	@Test
	public void getListBoardTest() {
		/***Given***/		

		/***When***/
		List<BoardVO> boardList = boardDao.getListBoard();
		for (BoardVO boardVo : boardList) {
			System.out.println(boardVo);
		}

		/***Then***/
		assertEquals(2, boardList.size());

	}
	
	/**
	* Method : getUsableListBoardTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용가능한 게시판 조회
	*/
	@Test
	public void getUsableListBoardTest() {
		/***Given***/		

		/***When***/
		List<BoardVO> boardUsableList = boardDao.getUsableListBoard();
		for (BoardVO boardVo : boardUsableList) {
			System.out.println(boardVo);
		}

		/***Then***/
		assertEquals(1, boardUsableList.size());

	}
	
	/**
	* Method : insertBoardTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 등록
	*/
	@Test
	public void insertBoardTest(){
		/***Given***/
		boardVo.setBoard_name("유머게시판");
		boardVo.setBoard_use("y");
		boardVo.setId(24);
		boardVo.setStd_id("brown");

		/***When***/
		int resultCnt = boardDao.insertBoard(boardVo);

		/***Then***/
		assertEquals(1, resultCnt);

	}
	
	/**
	* Method : updateBoardTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 수정
	*/
	@Test
	public void updateBoardTest(){
		/***Given***/
		boardVo.setBoard_name("공지사항게시판");
		boardVo.setBoard_use("n");
		boardVo.setBoard_no(2);
		
		/***When***/
		int resultCnt = boardDao.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, resultCnt);

	}
	
	/**
	* Method : getBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판 정보 조회
	*/
	@Test
	public void getBoard(){
		/***Given***/
		int boart_no = 7;

		/***When***/
		BoardVO boardVo = boardDao.getBoard(boart_no);

		/***Then***/
		assertEquals("유머게시판", boardVo.getBoard_name());

	}


}
