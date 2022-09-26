package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamAnswerMapper {
	// 답안지 제출하기
	// 파라미터 :Map<String, Obejct>
	// 리턴값 :int
	int insertExamAnswer(Map<String, Object> as);
	
	// 답지 
	// 파라미터 : examNo
	// 리턴값 : List<Map<String,Object>>
	List<Map<String,Object>> selectAnswerList(int examNo);
	
	// 채점시 맞았을 경우 상태 O로 변경해주기
	// 파라미터 : educationNo, examQuestionIndex
	// 리턴값 : int
	int updateExamAnswerState(Map<String,Object> as);
	
	// 시험결과
	List<Map<String, Object>> selectResultExam(Map<String, Object> paramMap);
}
