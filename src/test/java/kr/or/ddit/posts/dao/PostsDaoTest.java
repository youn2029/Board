package kr.or.ddit.posts.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.posts.model.PostsVO;

import org.junit.Before;
import org.junit.Test;

public class PostsDaoTest {
	
	private PostsDaoInf postsDao;
	
	@Before
	public void setUp(){
		postsDao = new PostsDao();
	}
	
	/**
	* Method : getListPostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판의 게시글 page별 조회
	*/
	@Test
	public void getListPostTest(){
		/***Given***/
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", 1);
		paramMap.put("pageSize", 10);
		paramMap.put("board_no", 1);

		/***When***/
		List<PostsVO> postList = postsDao.getListPost(paramMap);
		for (PostsVO postsVo : postList) {
			System.out.println(postsVo);
		}

		/***Then***/
		assertEquals(1, postList.size());

	}	
	
	/**
	* Method : getCountPostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시판의 게시글 전체 갯수 조회
	*/
	@Test
	public void getCountPostTest(){
		/***Given***/
		int board_no = 1;

		/***When***/
		int totalCnt = postsDao.getCountPost(board_no);

		/***Then***/
		assertEquals(2, totalCnt);

	}
	
	/**
	* Method : getPostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 정보 조회
	*/
	@Test
	public void getPostTest(){
		/***Given***/
		int post_no = 5;

		/***When***/
		PostsVO postsVo = postsDao.getPost(post_no);

		/***Then***/
		assertEquals("자유게시글 Dao 단위테스트", postsVo.getPost_title());

	}

	/**
	* Method : insertPostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 추가
	*/
	@Test
	public void insertPostTest() {
		/***Given***/
		PostsVO postsVo = new PostsVO();
		postsVo.setId(24);
		postsVo.setStd_id("brown");
		postsVo.setBoard_no(1);
		postsVo.setPost_title("자유게시글 Dao 단위테스트");
		postsVo.setPost_content("자유게시판 게시글 단위테스트를 위한 글입니다.");

		/***When***/
		int resultCnt = postsDao.insertPost(postsVo);

		/***Then***/
		assertEquals(1, resultCnt);

	}

	/**
	* Method : updatePostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 수정
	*/
	@Test
	public void updatePostTest(){
		/***Given***/
		PostsVO postsVo = new PostsVO();
		postsVo.setPost_title("자유게시판 Dao 수정 단위테스트");
		postsVo.setPost_content("Dao 수정 단위테스트");
		postsVo.setPost_no(5);

		/***When***/
		int resultCnt = postsDao.updatePost(postsVo);

		/***Then***/
		assertEquals(1, resultCnt);

	}
	
	/**
	* Method : deletePostTest
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 삭제 - update
	*/
	@Test
	public void deletePostTest(){
		/***Given***/
		int post_no = 5;

		/***When***/
		int resultCnt = postsDao.deletePost(post_no);

		/***Then***/
		assertEquals(1, resultCnt);

	}
	
	/**
	* Method : insertReplyPostTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 답글 등록
	*/
	@Test
	public void insertReplyPostTest(){
		/***Given***/
		PostsVO postsVo = new PostsVO();
		postsVo.setId(24);
		postsVo.setStd_id("brown");
		postsVo.setBoard_no(1);
		postsVo.setPost_title("자유게시글의 답글 Dao 단위테스트");
		postsVo.setPost_content("자유게시판 게시글의 답글 단위테스트를 위한 글입니다.");
		postsVo.setPost_group(5);
		postsVo.setPost_pno(5);

		/***When***/
		int resultCnt = postsDao.insertReplyPost(postsVo);

		/***Then***/
		assertEquals(1, resultCnt);

	}	
	
	/**
	* Method : getPostVoTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 게시글 정보 조회
	*/
	@Test
	public void getPostVoTest(){
		/***Given***/
		PostsVO postsVo = new PostsVO();
		postsVo.setId(24);
		postsVo.setBoard_no(1);
		postsVo.setPost_title("자유게시판 Dao 수정 단위테스트");

		/***When***/
		PostsVO postVo = postsDao.getPostVo(postsVo);

		/***Then***/
		assertEquals(5, postVo.getPost_no());
	}
}
