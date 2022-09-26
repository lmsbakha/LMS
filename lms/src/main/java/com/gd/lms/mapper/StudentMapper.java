package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;
import com.gd.lms.vo.Student;

@Mapper
public interface StudentMapper {
	// 로그인한 학생 정보 가져오기
	// 파라미터 : loginId
	// 리턴값 : Map<String, Object> educatioNo, studentName
	Map<String, Object> selectStudentInfo(String loginId);
	
	// 학생목록 리스트
	List<Student> selectStudentList();
	
	// 학생 개인정보 상세보기
	Student selectStudentOne(String accountId);
	
	// 학생 개인정보 수정하기
	int updateStudent(Student student);
	
	// 학생 개인정보 학생테이블에서 삭제하기 (탈퇴)
	int deleteStudent(String accountId);
	
	// 학생 개인정보 accountState 탈퇴로 수정하기 (탈퇴)
	int updateAccountStateStudent(Account account);
	
	// 학생 개인정보 수정&삭제를 위한 비밀번호확인
	int checkAccountPw(Account account);
}
