package com.gd.lms.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceMapper {

	// 오늘 날짜 구해주기
	String selectNotDate();

	// 각 강사별 강의명
	String selectLectureNameByTeacherName(Map<String, Object> map);

	// 각 학생의 educationNo 뽑아오기
	int selectEducationNo(String accountId);

	// 각 학생의 출결사항 수정
	int updateAttendance(Map<String, Object> map);
}
