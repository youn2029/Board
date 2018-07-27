package kr.or.ddit.posts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.posts.model.AttachedFileVO;
import kr.or.ddit.posts.model.PostsVO;

public class AttachedFileDao implements AttachedFileDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
		
		SqlSession session = sqlSessionFactory.openSession();
		List<AttachedFileVO> fileList = session.selectList("attachedFile.getFileList", post_no);
		session.close();
		
		return fileList;
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
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.insert("attachedFile.insertFile", fileVO);
		session.commit();
		session.close();
		
		return resultCnt;
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
		
		SqlSession session = sqlSessionFactory.openSession();
		AttachedFileVO fileVo = session.selectOne("attachedFile.getFile", file_no);
		session.close();
		
		return fileVo;
	}

}
