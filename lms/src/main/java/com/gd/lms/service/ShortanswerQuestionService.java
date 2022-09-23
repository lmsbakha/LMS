package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ExamQuestionMapper;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;
import com.gd.lms.vo.Multiplechoice;
import com.gd.lms.vo.ShortAnswerQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ShortanswerQuestionService {
	//ShortAnswerQuestionMapper 객체 주입
	@Autowired
	private ShortAnswerQuestionMapper shortAnswerQuestionMapper;

	// ExamQuestionMapper 객체 주입
	@Autowired
	private ExamQuestionMapper examQuestionMapper;

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

	// 단답형 문제 삭제하기
	// 파라미터 :questionNo
	// 리턴값 : int
	public int removeShortAnswerQuestionOne(int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// exam_question에 ShortAnswerQuestion 데이터가 포함되어 있으면 FK로 연결되어 있기 때문에 삭제가 안됨 --> exam_question테이블에 데이터가 들어가져있는 확인해야 한다
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		paramMap.put("questionType", "단답형");
		int CountCk = examQuestionMapper.selectCountExamQuestion(paramMap);
		// 결과값 디버깅
		if (CountCk != 0) {
			// 디버깅
			log.debug(TeamColor.PSJ + "[Error] exam_question 테이블에 단답형 문제 데이터가 있어서 삭제가 불가능합니다. " + TeamColor.TEXT_RESET);
			// 500으로 리턴해서 삭제 실패로 보내기
			return 500;
		}

		// 해당 단답형 문제 삭제
		int removeShortAnswerQuestionCk = shortAnswerQuestionMapper.deleteShortAnswerQuestionOneByQuestionNo(questionNo);
		// 결과 디버깅
		if (removeShortAnswerQuestionCk != 0) {
			log.debug(TeamColor.PSJ + "[Success] 단답형 문제 삭제 성공" + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PSJ + "[Fail] 단답형 문제 삭제 실패" + TeamColor.TEXT_RESET);
			return 0;
		}

		return removeShortAnswerQuestionCk;
	}

	// 단답형 문제 가져오기
	// 파라미터 : questionNo
	// 리턴값 : ShortAnswerQuestion 
	public ShortAnswerQuestion getShortAnswerQuestion(int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		//shortAnswerQuestionMapper에서 특정 questionNo의 문제 정보 가져오기
		ShortAnswerQuestion shortAnswerQuestion = shortAnswerQuestionMapper.selectShortAnswerQuestionOne(questionNo);
		// 디버깅
		log.debug(TeamColor.PSJ + shortAnswerQuestion + "<-- shortAnswerQuestion" + TeamColor.TEXT_RESET);

		return shortAnswerQuestion;
	}
	
	// 단답형 문제 지문 수정하기
	// 파라미터 : ShortAnswerQuestion
	// 리턴값 : int
	public int modifyShortAnswerQuestionOne(ShortAnswerQuestion parmShortAnswerQuestion) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + parmShortAnswerQuestion + "<-- parmShortAnswerQuestion" + TeamColor.TEXT_RESET);

		// Mapper call
		int row = shortAnswerQuestionMapper.updateShortAnswerQuestion(parmShortAnswerQuestion);
		// 결과 디버깅
		if (row != 0) { // 수정에 성공하였을 때
			log.debug(TeamColor.PSJ + "[Success] modifyShortAnswerQuestionOne 성공 " + TeamColor.TEXT_RESET);
		} else { // 수정 실패했을 때
			log.debug(TeamColor.PSJ + "[Fail] modifyShortAnswerQuestionOne 실패 " + TeamColor.TEXT_RESET);
		}
		return row;
	}

}
