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
}