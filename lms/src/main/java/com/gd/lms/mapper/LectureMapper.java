package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;

@Mapper
public interface LectureMapper {
	/*
	 * lectureList 받아오기
	 * 파라미터 : String accountId
	 * 리턴값 : List<Lecture>
	 * */
	List<Lecture> selectlectureListByTeacher(String accountId);
	
	// reportSubmitList 강좌리스트 조회
	List<Lecture> selectLectureNameByTeacher(String teacherName);
}