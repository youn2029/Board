package kr.or.ddit.student.service;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVO;

public class StudentService implements StudentServicetInf {
	
	private StudentDaoInf stdDao = new StudentDao();

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
		return stdDao.getStudent(std_id);
	}

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 8. 1.
	* 작성자 : PC04
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : id로 학생 정보 조회
	*/
	@Override
	public StudentVO getStudent(int id) {
		return stdDao.getStudent(id);
	}

}
