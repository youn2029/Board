package kr.or.ddit.posts.service;

import java.util.Map;

import kr.or.ddit.posts.model.PostsVO;

public interface PostsServiceInf {

	
	/**
	* Method : getListPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 게시판의 게시글 페이지별 조회
	*/
	Map<String, Object> getListPost(Map<String, Integer> paramMap);
	
	
	/**
	* Method : getPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 정보 조회
	*/
	PostsVO getPost(int post_no);
	
	/**
	* Method : insertPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	int insertPost(PostsVO postsVo);
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updatePost(PostsVO postsVo);
	
	/**
	* Method : deletePost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 삭제 - update
	*/
	int deletePost(int post_no);
	
	/**
	* Method : insertReplyPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 답글 등록
	*/
	int insertReplyPost(PostsVO postsVo);
	
	/**
	* Method : getPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 정보 조회
	*/
	PostsVO getPostVo(PostsVO postsVo);
}
