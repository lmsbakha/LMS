package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;

@Mapper
public interface LectureMapper {
	// lectureList 받아오기
	// 파라미터 : X
	// 리턴값 : List<Lecture>
	List<Lecture> selectlectureListByManager();

	// lectureList 받아오기
	// 파라미터 : String accountId
	// 리턴값 : List<Lecture>
	List<Lecture> selectlectureListByTeacher(String accountId);
	
	// lectureList 받아오기
	// 파라미터 : X
	// 리턴값 : List<Map<String,Object>>
	List<Map<String,Object>> selectLectureDetailList();

	// lectureOne 받아오기
	// 파라미터 : lectureName
	// 리턴값 : Map<String,Object>
	Map<String,Object> selectLectureOne(String lectureName);
	
	// 강사가 담당하는 해당 강의 수강생 리스트 받아오기
	// 파라미터 : Map<String, Object> map (accountId, lectureName)
	// 리턴값 : List<Map<String,Object>>
	List<Map<String, Object>> selectStudentBookListByTeacher(Map<String, Object> map);

	// 각 클래스 학생들 수강생 리스트 받아오기
	// 파라미터 : lectureName
	// 리턴값 : List<Map<String,Object>>
	List<Map<String, Object>> selectStudentBookListByManager(String lectureName);
	
}