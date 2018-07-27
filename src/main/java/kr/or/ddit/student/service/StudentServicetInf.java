package kr.or.ddit.student.service;

import kr.or.ddit.student.model.StudentVO;

public interface StudentServicetInf {
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC04
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 : 학생 정보 조회
	*/
	StudentVO getStudent(String std_id); 
}
