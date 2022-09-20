package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;

@Mapper
public interface LectureMapper {
	// 강의 정보 조회하기
	// 파라미터 : X
	// 리턴값 : List<Lecture>
	List<Lecture> selectLectureList();
}
