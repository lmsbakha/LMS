package com.gd.lms.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceMapper {

	// 각 강사별 강의명
	String selectLectureNameByTeacher(Map<String, Object> map);
	
	// 각 학생의 educationNo 뽑아오기
	int selectEducationNo(String accountId);
	
	// 강사별 현재 강의의 학생명, 출결, 출결사유 , 출결날짜 뽑아오기
	List<Map<String, Object>> selectAttendanceByTeacher(Map<String, Object> map);
	
	// 전체 출석 버튼
	int updateAttendanceListAll(int scheduleNo);
	
	// 각 학생의 출결사항 수정
	int updateAttendance(Map<String, Object> map);
}
