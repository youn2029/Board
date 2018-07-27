package kr.or.ddit.posts.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import kr.or.ddit.posts.model.AttachedFileVO;

import org.junit.Before;
import org.junit.Test;

public class AttachedFileDaoTest {
	
	private AttachedFileDaoInf atFileDao;
	
	@Before
	public void setUp(){
		atFileDao = new AttachedFileDao();
	}

	/**
	* Method : getFileListTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : YSH
	* 변경이력 :
	* Method 설명 : 첨부파일 전체조회
	*/
	@Test
	public void getFileListTest() {
		/***Given***/
		int post_no = 41;

		/***When***/
		List<AttachedFileVO> fileList = atFileDao.getFileList(post_no);

		/***Then***/
		assertEquals(2, fileList.size());
		
	}
	
	/**
	* Method : insertFileTest
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 첨부파일 등록
	*/
	@Test
	public void insertFileTest(){
		/***Given***/
		AttachedFileVO fileVo = new AttachedFileVO();
		fileVo.setFile_name("Chrysanthemum.jpg");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		fileVo.setFile_upload(UUID.randomUUID().toString());
		fileVo.setPost_no(7);

		/***When***/
		int resultCnt = atFileDao.insertFile(fileVo);

		/***Then***/
		assertEquals(1, resultCnt);

		
	}
	
	/**
	* Method : getFileTest
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 첨부파일 정보 조회
	*/
	@Test
	public void getFileTest(){
		/***Given***/
		int file_no = 1;

		/***When***/
		AttachedFileVO fileVo = atFileDao.getFile(file_no);
		
		/***Then***/
		assertEquals("icebear.jpg", fileVo.getFile_name());
		
	}

}
