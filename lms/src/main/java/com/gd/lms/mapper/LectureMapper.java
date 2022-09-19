package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureMapper {
	// 특정 강사가 강의하는 lecture의 리스트
	// 파라미터 : 강사 이름(teacher_name)
	// 리턴값 : 강의 리스트(Map<String, Object>)
	List<Map<String, Object>> selectLectureListByTeacher(String teacherName);
}
