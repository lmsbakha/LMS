package com.gd.lms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ExamAnswerMapper;
import com.gd.lms.mapper.ExamSubmitMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ExamAnswerService {

	// ExamAnswerMapper 객체 주입
	@Autowired
	private ExamAnswerMapper examAnswerMapper;

	// ExamSubmitMapper 객체 주입
	@Autowired
	private ExamSubmitMapper examSubmitMapper;

	// 학생이 제출한 answer sheet
	// 파라미터 : List<Map<String, Obejct>> educationNo, questionType, examQuestionIndex, examAnswerContent
	// 리턴값 : Map<String, Object> 
	// 로직 : 시험응시여부 추가 ▶ answersheet 제출 ▶ 자동 채점 ▶ 시험 점수 리턴하기
	public Map<String, Object> addAnswerSheet(List<Map<String, Object>> answerSheet, int educationNo, int examNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + answerSheet + "<-- answerSheet" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + examNo + "<-- examNo" + TeamColor.TEXT_RESET);

		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();

		// exam_submit table에 추가
		// 파라미터 :examNo, educationNo
		int examSubmitCK = examSubmitMapper.insertExamSubmitCK(educationNo, examNo);
		if (examSubmitCK != 0) {
			log.debug(TeamColor.PSJ + examSubmitCK + "<-- examSubmitCK" + TeamColor.TEXT_RESET);
		}
		// answer sheet 제출
		for (Map<String, Object> as : answerSheet) {
			examAnswerMapper.insertExamAnswer(as);
			log.debug(TeamColor.PSJ + "답안제출 완료" + TeamColor.TEXT_RESET);
		}

		// 답안지 받아오기
		List<Map<String, Object>> answerList = new ArrayList<>();
		answerList = examAnswerMapper.selectAnswerList(examNo);
		returnMap.put("answerList", answerList);

		log.debug(TeamColor.PSJ + answerList + "<--answerList" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + "정답지 셋팅 완료" + TeamColor.TEXT_RESET);

		// 제출한 답안지 채점하기
		int score = 0;
		int cnt = 0;
		// 정답과 제출된 답안지 비교
		for (Map<String, Object> as : answerSheet) { // 1~10번 반복
			if (as.get("examAnswerContent").equals(answerList.get(cnt).get("questionAnswer"))) { // 답안지와 정답이 같을 경우
				log.debug(TeamColor.PSJ + (cnt + 1) + "번 문제는 정답입니다" + TeamColor.TEXT_RESET);
				// Mapper call
				int row = examAnswerMapper.updateExamAnswerState(as);
				// 결과 디버깅
				if (row != 0) {
					log.debug(TeamColor.PSJ + "examAnswerState O로 변경 완료" + TeamColor.TEXT_RESET);
				} else {
					log.debug(TeamColor.PSJ + "examAnswerState O로 변경 실패" + TeamColor.TEXT_RESET);
				}
				score++;
			} else { // 오답일 경우
				log.debug(TeamColor.PSJ + (cnt + 1) + "번 문제는 오답입니다" + TeamColor.TEXT_RESET);
			}
			cnt++;
		}
		returnMap.put("score", score);

		return returnMap;
	}

	// 시험 결과
	// 파라미터 :examNo, educationNo
	// 리턴값 : List<Map<String, Object>>
	public List<Map<String, Object>> getResultExam(int examNo, int educationNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + examNo + "<--examNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + educationNo + "<--educationNo" + TeamColor.TEXT_RESET);

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("examNo", examNo);
		paramMap.put("educationNo", educationNo);

		List<Map<String, Object>> resultExam = examAnswerMapper.selectResultExam(paramMap);
		log.debug(TeamColor.PSJ + "시험결과 가져오기 성공" + TeamColor.TEXT_RESET);

		return resultExam;
	}
}
