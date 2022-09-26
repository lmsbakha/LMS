package com.gd.lms.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
	// 로그인한 학생 정보 가져오기
	// 파라미터 : loginId
	// 리턴값 : Map<String, Object> educatioNo, studentName
	Map<String, Object> selectStudentInfo(String loginId);
}
