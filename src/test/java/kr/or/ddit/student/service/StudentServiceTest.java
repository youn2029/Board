package kr.or.ddit.student.service;

import static org.junit.Assert.*;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVO;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	
	private StudentServicetInf stdService;
	
	@Before
	public void setUp(){
		stdService = new StudentService();
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
		StudentVO stdVo = stdService.getStudent(std_id);

		/***Then***/
		assertEquals("윤성호", stdVo.getName());

	}
}
