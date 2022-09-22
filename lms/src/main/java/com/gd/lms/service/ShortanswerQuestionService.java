package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;
import com.gd.lms.vo.ShortAnswerQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ShortanswerQuestionService {
	//ShortAnswerQuestionMapper 객체 주입
	@Autowired
	private ShortAnswerQuestionMapper shortAnswerQuestionMapper;

	// 검색어와 관련된 단답형 문제 리스트 가져오기
	// 파라미터 : subjectName 
	// 리턴값 : List<Map<String, Object>>
	public List<Map<String, Object>> getShortAnswerQuestionList(String subjectName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);

		// ShortAnswerQuestionMapper call으로 전체 단답형 문제 리스트 가져오기
		List<Map<String, Object>> shortAnswerQuestionList = shortAnswerQuestionMapper.selectShortAnswerQuestionList(subjectName);
		// 디버깅
		log.debug(TeamColor.PSJ + shortAnswerQuestionList + "<-- shortAnswerQuestionList" + TeamColor.TEXT_RESET);

		return shortAnswerQuestionList;
	}

	// 단답형 문제 추가하는 메소드
	// 파라미터 : ShortAnswerQuestion
	// 리턴값 : int
	public int addShortAnswerQuestionOne(ShortAnswerQuestion paramShortAnswerQuestion) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramShortAnswerQuestion + "<-- paramShortAnswerQuestion" + TeamColor.TEXT_RESET);

		//Mapper call
		int row = shortAnswerQuestionMapper.insertShortAnswerQuestionOne(paramShortAnswerQuestion);
		// mapper 수행 결과 디버깅
		if (row != 0) {
			log.debug(TeamColor.PSJ + "[Success] addShortAnswerQuestionOne 성공" + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PSJ + "[Fail] addShortAnswerQuestionOne 실패" + TeamColor.TEXT_RESET);
		}
		return row;
	}
}
