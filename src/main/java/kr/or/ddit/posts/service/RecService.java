package kr.or.ddit.posts.service;

import java.util.List;

import kr.or.ddit.posts.dao.RecDao;
import kr.or.ddit.posts.dao.RecDaoInf;
import kr.or.ddit.posts.model.RecommentVO;

public class RecService implements RecServiceInf {
	
	private RecDaoInf recDao = new RecDao();

	/**
	* Method : getRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 조회
	*/
	@Override
	public List<RecommentVO> getRec(int post_no) {		
		return recDao.getRec(post_no);
	}

	/**
	* Method : insertRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param recVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	@Override
	public int insertRec(RecommentVO recVo) {
		return recDao.insertRec(recVo);
	}

	/**
	* Method : deleteRec
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param rec_no
	* @return
	* Method 설명 : 댓글 삭제 - update
	*/
	@Override
	public int deleteRec(int rec_no) {
		return recDao.deleteRec(rec_no);
	}

}
