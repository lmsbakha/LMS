package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Exam;

@Mapper
public interface ExamMapper {
	/*
	 * 시험을 추가하는 메소드
	 * 파라미터 : Exam
	 * 리턴값: 추가 여부 int 
	 */
	int insertExam(Exam paramExam);
}
