package kr.or.ddit.posts.dao;

import java.util.List;

import kr.or.ddit.posts.model.AttachedFileVO;

public interface AttachedFileDaoInf {	
	
	/**
	* Method : getFileList
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : YSH
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 첨부파일 조회
	*/
	List<AttachedFileVO> getFileList(int post_no);
	
	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : YSH
	* 변경이력 :
	* @param fileVO
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	int insertFile(AttachedFileVO fileVO);
	
	/**
	* Method : getFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : YSH
	* 변경이력 :
	* @param file_no
	* @return
	* Method 설명 : 첨부파일 정보 조회
	*/
	AttachedFileVO getFile(int file_no);
}
