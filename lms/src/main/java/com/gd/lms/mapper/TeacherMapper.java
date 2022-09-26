package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;
import com.gd.lms.vo.Teacher;

@Mapper
public interface TeacherMapper {
	// 계정 아이디로 강사이름 받아오기
	// 파라미터 : 계정아이디
	// 리턴값: Map<String, Object> teacherName, lectureName, lectureActive, lectureStartDate, lectureEndDate
	Map<String, Object> selectInfoAboutTeacher(String accountId);
	
	// 강사목록 리스트
	List<Teacher> selectTeacherList();
	
	// 강사 개인정보 상세보기
	Teacher selectTeacherOne(String accountId);
	
	// 강사 개인정보 수정하기
	int updateTeacher(Teacher teacher);
	
	// 강사 개인정보 강사테이블에서 삭제하기 (탈퇴)
	int deleteTeacher(String accountId);
	
	// 강사 개인정보 accountState 탈퇴로 수정하기 (탈퇴)
	int updateAccountStateTeacher(Account account);
	
	// 강사 개인정보 수정&삭제를 위한 비밀번호확인
	int checkAccountPw(Account account);
}
