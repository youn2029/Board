package kr.or.ddit.student.dao;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.student.model.StudentVO;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
	private StudentDaoInf stdDao;
	
	@Before
	public void setUp(){
		stdDao = new StudentDao();
	}

	/**
	* Method : getStudentTest
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 학생 정보 조회
	*/
	@Test
	public void getStudentTest() {
		/***Given***/
		String std_id = "brown";

		/***When***/
		StudentVO stdVo = stdDao.getStudent(std_id);

		/***Then***/
		assertEquals("윤성호", stdVo.getName());

	}
	
	@Test
	public void getStudentIdTest(){
		/***Given***/
		int id = 24;

		/***When***/
		StudentVO stdVo = stdDao.getStudent(id);

		/***Then***/
		assertEquals("윤성호", stdVo.getName());

	}

}
