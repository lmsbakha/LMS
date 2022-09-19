package com.gd.lms.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
	// 계정 아이디로 강사이름 받아오기
	// 파라미터 : 계정아이디
	// 리턴값: Map<String, Object> teacherName, lectureName, lectureActive, lectureStartDate, lectureEndDate
	Map<String, Object> selectInfoAboutTeacher(String accountId);
}