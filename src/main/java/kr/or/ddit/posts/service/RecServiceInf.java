package kr.or.ddit.posts.service;

import java.util.List;

import kr.or.ddit.posts.model.RecommentVO;

public interface RecServiceInf {
	
	/**
	* Method : getRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 조회
	*/
	List<RecommentVO> getRec(int post_no);
	
	/**
	* Method : insertRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param recVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	int insertRec(RecommentVO recVo);
	
	/**
	* Method : deleteRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param rec_no
	* @return
	* Method 설명 : 댓글 삭제 - update
	*/
	int deleteRec(int rec_no);
}
