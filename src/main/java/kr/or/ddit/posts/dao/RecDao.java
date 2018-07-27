package kr.or.ddit.posts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.posts.model.RecommentVO;

public class RecDao implements RecDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<RecommentVO> getRec(int post_no) {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<RecommentVO> recList = session.selectList("recomment.getRec", post_no);
		session.close();
		
		return recList;
	}

	@Override
	public int insertRec(RecommentVO recVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.insert("recomment.insertRec", recVo);
		session.commit();
		session.close();
		
		return resultCnt;
	}

	@Override
	public int deleteRec(int rec_no) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("recomment.deleteRec", rec_no);
		session.commit();
		session.close();
		
		return resultCnt;
	}

}
