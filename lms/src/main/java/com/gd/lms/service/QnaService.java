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
	
	// 질문 상세보기
	// 대기중일 경우 질문만 노출, 답변완료 상태일 경우 답변까지 노출
	public Map showQnaOne(int qnaNo){
		Map<String, Object> qnaMap = new HashMap();
		
		// 객체에 mapper 질문글 담기
		QnaQuestion qnaQuestion = null;
		qnaQuestion = qnaMapper.selectQnaQuestionOne(qnaNo);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion + TeamColor.TEXT_RESET);
		
		String state = qnaQuestion.getQnaQuestionState();
		log.debug(TeamColor.LHN + "state: " + state + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "답변여부: " + (state.equals("답변완료")) + TeamColor.TEXT_RESET);
		
		// 답변여부가 "답변완료" 인 경우
		if(state.equals("답변완료")) {	
			log.debug(TeamColor.LHN + "답변 완료된 게시글입니다. " + TeamColor.TEXT_RESET);
			
			// 답변 담기
			QnaAnswer qnaAnswer = null;
			qnaAnswer = qnaMapper.selectQnaAnswerOne(qnaNo);
			log.debug(TeamColor.LHN + "qnaAnswer: " + qnaAnswer + TeamColor.TEXT_RESET);
			
			qnaMap.put("qnaQuestion", qnaQuestion);
			qnaMap.put("qnaAnswer", qnaAnswer);
			log.debug(TeamColor.LHN + "qnaMap: " + qnaMap + TeamColor.TEXT_RESET);
			
		}else {	// 미답변일 경우
			log.debug(TeamColor.LHN + "미답변 게시글입니다. " + TeamColor.TEXT_RESET);
			
			qnaMap.put("qnaQuestion", qnaQuestion);
			log.debug(TeamColor.LHN + "qnaMap: " + qnaMap + TeamColor.TEXT_RESET);
		}
		return qnaMap;
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
