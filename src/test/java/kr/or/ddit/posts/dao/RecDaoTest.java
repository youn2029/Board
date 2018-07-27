package kr.or.ddit.posts.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.posts.model.RecommentVO;

import org.junit.Before;
import org.junit.Test;

public class RecDaoTest {
	
	private RecDaoInf recDao;
	
	@Before
	public void setUp(){
		recDao = new RecDao();
	}

	/**
	* Method : getRecTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 댓글 조회
	*/
	@Test
	public void getRecTest() {
		/***Given***/
		int post_no = 21;

		/***When***/
		List<RecommentVO> recList = recDao.getRec(post_no);

		/***Then***/
		assertEquals(1, recList.size());

	}
	
	/**
	* Method : insertRecTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 댓글 등록
	*/
	@Test
	public void insertRecTest(){
		/***Given***/
		RecommentVO recVo = new RecommentVO();
		recVo.setId(25);
		recVo.setStd_id("song");
		recVo.setPost_no(21);
		recVo.setRec_content("댓글 등록 Dao 단위테스트입니다.");

		/***When***/
		int resultCnt = recDao.insertRec(recVo);

		/***Then***/
		assertEquals(1, resultCnt);

		
	}
	
	/**
	* Method : deleteRecTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 댓글 삭제 - update
	*/
	@Test
	public void deleteRecTest(){
		/***Given***/
		int rec_no = 1;

		/***When***/
		int resultCnt = recDao.deleteRec(rec_no);

		/***Then***/
		assertEquals(1, resultCnt);

		
	}

}
