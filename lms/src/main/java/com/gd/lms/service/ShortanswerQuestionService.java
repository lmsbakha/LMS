package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;

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

}
