package com.gd.lms.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamQuestionMapper {
	/*
	 * 시험지 속 문제 정보 할당하는 메소드
	 * 파라미터 : examNo examQuestionNo questionNo questionType
	 * 리턴값 : 
	 * */
	int insertExamQuestion(Map<String, Object> paramMap);
}
