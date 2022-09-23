package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Multiplechoice;
import com.gd.lms.vo.ShortAnswerQuestion;

@Mapper
public interface ShortAnswerQuestionMapper {
	// 단답형 문제를 선택한 수 만큼 뽑아오기
	// 파라미터 : Map<String, Object> subjectName, shortAnswerCnt
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> getShortAnswerQuestionListByRandom(Map<String, Object> paramMap);

	// 검색어(특정 과목)와 연관된 객관식 문제 리스트
	// 파라미터 : subjectName
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> selectShortAnswerQuestionList(String subjectName);

	// 단답형 문제 추가하기
	// 파라미터 : ShortAnswerQuestion
	// 리턴값 : int
	int insertShortAnswerQuestionOne(ShortAnswerQuestion paramShortAnswerQuestion);

	// 단답형 문제를 삭제하는 메소드
	// 파라미터 : questionNo
	// 리턴값 : 정상적으로 삭제되었음을 확인시켜줄 int
	int deleteShortAnswerQuestionOneByQuestionNo(int questionNo);

	// 단답형 문제 정보 가져오는 메소드
	// 파라미터 : questionNo
	// 리턴값 : shortAnswerQuestion
	ShortAnswerQuestion selectShortAnswerQuestionOne(int questionNo);

	// 단답형 문제를 수정하는 메소드
	// 파라미터 : shortAnswerQuestion 
	// 리턴값 : int
	int updateShortAnswerQuestion(ShortAnswerQuestion paramShortAnswerQuestion);
}
