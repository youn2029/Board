package kr.or.ddit.student.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVO;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC04
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 : 학생 정보 조회
	*/
	@Override
	public StudentVO getStudent(String std_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		StudentVO stdVo = session.selectOne("student.getStudent", std_id);
		session.close();
		
		return stdVo;
	}

}
