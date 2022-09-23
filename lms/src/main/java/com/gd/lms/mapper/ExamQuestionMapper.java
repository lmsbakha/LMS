package com.gd.lms.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamQuestionMapper {
	/*
	 * 시험지 속 문제 정보 할당하는 메소드
	 * 파라미터 : examNo examQuestionNo questionNo questionType
	 * 리턴값 : int
	 * */
	int insertExamQuestion(Map<String, Object> paramMap);
	
	// exam_question 테이블에 multiplechoice의 문제가 들어가 있는지 확인하는 메소드
	// 파라미터 : questionNo
	// 리턴값 : COUNT(*) 수
	int selectCountExamQuestion(int questionNo);
	
}
