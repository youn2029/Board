package kr.or.ddit.posts.service;

import java.util.List;

import kr.or.ddit.posts.dao.AttachedFileDao;
import kr.or.ddit.posts.dao.AttachedFileDaoInf;
import kr.or.ddit.posts.model.AttachedFileVO;

public class AttachedFileService implements AttachedFileServiceInf {
	
	private AttachedFileDaoInf atFileDao = new AttachedFileDao();

	/**
	* Method : getFileList
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : YSH
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 첨부파일 조회
	*/
	@Override
	public List<AttachedFileVO> getFileList(int post_no) {
		return atFileDao.getFileList(post_no);
	}

	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : YSH
	* 변경이력 :
	* @param fileVO
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	@Override
	public int insertFile(AttachedFileVO fileVO) {
		return atFileDao.insertFile(fileVO);
	}

	/**
	* Method : getFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : YSH
	* 변경이력 :
	* @param file_no
	* @return
	* Method 설명 : 첨부파일 정보 조회
	*/
	@Override
	public AttachedFileVO getFile(int file_no) {
		return atFileDao.getFile(file_no);
	}

}
