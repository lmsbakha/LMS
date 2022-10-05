package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.QnaMapper;
import com.gd.lms.vo.Notice;
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
	public int addQnaQuestion(QnaQuestion qnaQuestion) {
		// 디버깅
		log.debug(TeamColor.LHN + " addQnaQuestion 실행" + TeamColor.TEXT_RESET);
		int addQnaQuestion = 0;	// 리턴값
		log.debug(TeamColor.LHN + "addQnaQuestion: " + addQnaQuestion + TeamColor.TEXT_RESET);
		// 매퍼 실행
		addQnaQuestion = qnaMapper.insertQnaQuestion(qnaQuestion);
		return addQnaQuestion;
	}
	
	// 질문 수정 폼(기존 내용 수정 화면으로 불러오기)
	public QnaQuestion modifyQnaQuestionForm(int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "updateqnaQuestionForm 호출" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestionNo: " + qnaQuestionNo +  TeamColor.TEXT_RESET);
		
		// 수정할 객체
		QnaQuestion qnaQuestion = qnaMapper.updateQnaQuestionForm(qnaQuestionNo);
		String qnaQuestionContent = qnaQuestion.getQnaQuestionContent();
		qnaQuestionContent = qnaQuestionContent.replace("<br>", "\r\n");
		qnaQuestion.setQnaQuestionContent(qnaQuestionContent);
		log.debug(TeamColor.LHN + "자동 개행 적용" + qnaQuestionContent +  TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN+ "(Service)qnaQuestion : " +qnaQuestion + TeamColor.TEXT_RESET);
		
		return qnaQuestion;
	}
	
	
	// 질문 수정 액션
	public int modifyQnaQuestion(QnaQuestion qnaQuestion) {
		log.debug(TeamColor.LHN + "modifyQnaQuestion 실행" + TeamColor.TEXT_RESET);
		return qnaMapper.updateQnaQuestion(qnaQuestion);
	}
	
	// 질문 삭제 액션	
	public int removeQnaQuestion(int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "답변 삭제" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN  + "답변 번호: " + qnaQuestionNo + TeamColor.TEXT_RESET);
		// 매퍼 적용
		int removeQuestion = 0;
		removeQuestion = qnaMapper.deleteQnaQuestion(qnaQuestionNo);
		log.debug(TeamColor.LHN + "삭제여부: "+ removeQuestion  + TeamColor.TEXT_RESET);
		
		return removeQuestion;
		
	}
	
	// 답변여부 조회
	public String showQnaQuestionState(int qnaQuestionNo) {
		return qnaMapper.selectQnaQuestionState(qnaQuestionNo);
	}
	
	/////////////////////////////////////////////////////
		
	
	// 답변 작성 액션
	public int addQnaAnswer(QnaAnswer qnaAnswer) {
		// 디버깅
		log.debug(TeamColor.LHN + " addQnaAnswer 실행" + TeamColor.TEXT_RESET);
		int addQnaAnswer = 0;	// 리턴값
		log.debug(TeamColor.LHN + "addQnaAnswer: " + addQnaAnswer + TeamColor.TEXT_RESET);
		
		// 매퍼 실행
		qnaMapper.insertQnaAnswer(qnaAnswer);
		
		// 상태값 답변완료 처리
		int qnaAnswerNo = qnaAnswer.getQnaAnswerNo();
		addQnaAnswer = qnaMapper.updateQnaState(qnaAnswerNo);
		log.debug(TeamColor.LHN + "addQnaAnswer 답변완료 처리: " + addQnaAnswer + TeamColor.TEXT_RESET);
		return addQnaAnswer;
	}
	
	// 답변 수정 폼(기존 내용 수정 화면으로 불러오기)
		public QnaAnswer modifyQnaAnswerForm(int qnaAnswerNo) {
			log.debug(TeamColor.LHN + "modifyQnaAnswerForm 호출" + TeamColor.TEXT_RESET);
			log.debug(TeamColor.LHN + "qnaAnswerNo: " + qnaAnswerNo +  TeamColor.TEXT_RESET);
			
			// 수정할 객체
			QnaAnswer qnaAnswer = qnaMapper.updateQnaAnswerForm(qnaAnswerNo);
			String qnaAnswerContent = qnaAnswer.getQnaAnswerContent();
			qnaAnswerContent = qnaAnswerContent.replace("<br>", "\r\n");
			qnaAnswer.setQnaAnswerContent(qnaAnswerContent);
			log.debug(TeamColor.LHN + "자동 개행 적용" + qnaAnswerContent +  TeamColor.TEXT_RESET);
			log.debug(TeamColor.LHN+ "(Service)qnaAnswer : " +qnaAnswer + TeamColor.TEXT_RESET);
			return qnaAnswer;
		}
		
	// 답변 수정 액션
	public int modifyQnaAnswer(QnaAnswer qnaAnswer) {
		log.debug(TeamColor.LHN + "modifyQnaAnswer 실행" + TeamColor.TEXT_RESET);
		return qnaMapper.updateQnaAnswer(qnaAnswer);
	}
	
	// 답변 삭제 액션
	public int removeQnaAnswer(int qnaAnswerNo) {
		log.debug(TeamColor.LHN + "답변 삭제" + TeamColor.TEXT_RESET);
		
		int removeAnswer = 0;
		log.debug(TeamColor.LHN  + "답변 번호: " + qnaAnswerNo + TeamColor.TEXT_RESET);
		
		// 매퍼 적용
		removeAnswer = qnaMapper.deleteQnaAnswer(qnaAnswerNo);
		log.debug(TeamColor.LHN + "삭제 여부: "+ removeAnswer  + TeamColor.TEXT_RESET);
		
		// 상태값 대기중 상태로 변경
		removeAnswer = qnaMapper.updateQnaStateBack(qnaAnswerNo);
		log.debug(TeamColor.LHN + "상태값 변경 여부: "+ removeAnswer  + TeamColor.TEXT_RESET);
		 
		return removeAnswer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
