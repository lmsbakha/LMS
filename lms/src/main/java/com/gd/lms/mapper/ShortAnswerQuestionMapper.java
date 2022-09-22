package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShortAnswerQuestionMapper {
	// 단답형 문제를 선택한 수 만큼 뽑아오기
	// 파라미터 : Map<String, Object> subjectName, shortAnswerCnt
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> getShortAnswerQuestionListByRandom(Map<String, Object> paramMap);
}
