package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.QnaMapper;
import com.gd.lms.vo.QnaAnswer;
import com.gd.lms.vo.QnaQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	// 질문 리스트 조회
	public List<QnaQuestion> getQnaList() {
		return qnaMapper.selectQnaList();
	}
	
	// 답변여부
	public boolean qnaState(int qnaNo) {
		// 객체에 mapper 질문글 담기
		QnaQuestion qnaQuestion = null;
		qnaQuestion = qnaMapper.selectQnaQuestionOne(qnaNo);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion + TeamColor.TEXT_RESET);
		
		String state = qnaQuestion.getQnaQuestionState();
		log.debug(TeamColor.LHN + "답변여부: " + state + TeamColor.TEXT_RESET);
		// 답변 시 true, 미답변 시 false
		return state.equals("답변완료");
	}
	
	// 질문 상세보기
	public QnaQuestion showQnaQuestionOne(int qnaNo){
		// 객체에 mapper 질문글 담기
		QnaQuestion qnaQuestion = null;
		qnaQuestion = qnaMapper.selectQnaQuestionOne(qnaNo);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion + TeamColor.TEXT_RESET);

		return qnaQuestion;
	}
	
	// 답변 상세보기
	public QnaAnswer showQnaAnswerOne(int qnaNo) {
		// 답변 담기
		QnaAnswer qnaAnswer = null;
		qnaAnswer = qnaMapper.selectQnaAnswerOne(qnaNo);
		log.debug(TeamColor.LHN + "qnaAnswer: " + qnaAnswer + TeamColor.TEXT_RESET);
		
		return qnaAnswer;		
	}
	
	
	/////////////////////////////////////////////////////
	
	
	// 질문 작성 액션
	
	
	// 질문 수정 액션
	
	
	// 질문 삭제 액션	
	
	
	/////////////////////////////////////////////////////
		
	
	// 답변 작성 액션
	
	
	// 답변 수정 액션
	
	
	// 답변 삭제 액션
}
