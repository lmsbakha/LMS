package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ExamAnswerMapper;
import com.gd.lms.mapper.MultiplechoiceMapper;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ExamAnswerService {
	// MultiplechoiceMapper 객체 주입
	@Autowired
	private MultiplechoiceMapper multiplechoiceMapper;

	// ShortAnswerQuestionMapper 객체 주입
	@Autowired
	private ShortAnswerQuestionMapper answerQuestionMapper;
	
	// ExamAnswerMapper 객체 주입
	@Autowired
	private ExamAnswerMapper examAnswerMapper;
	
	
	// 학생이 제출합 answer sheet
	// 파라미터 : List<Map<String, Obejct>> educationNo, questionType, examQuestionIndex, examAnswerContent
	// 리턴값 : 점수 
	// 로직 : answersheet 제출 ▶ 자동 채점 ▶ 시험 점수 리턴하기
	public int addAnswerSheet(List<Map<String, Object>> answerSheet) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + answerSheet + "<-- answerSheet" + TeamColor.TEXT_RESET);
	
		// answer sheet 제출
		for (Map<String, Object> as : answerSheet) {
			
		}
		
		// 제출한 답안지 채점하기
		int score = 0;
		for (Map<String, Object> as : answerSheet) { // 1~10번 반복
			// 객관식 문제일 경우
			if (as.get("questionType").equals("객관식")) {
				score+=multiplechoiceMapper.selectGradingAnswerSheet(as);
			}
			// 단답형 문제일 경우
			if (as.get("questionType").equals("단답형")) {
			}
		}
		return score;
	}
}
