package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.QnaAnswer;
import com.gd.lms.vo.QnaQuestion;

@Mapper
public interface QnaMapper {
	// 질문 리스트 조회
	List selectQnaList();
	
	/////////////////////////////////////////////////////
	
	// 질문 상세보기
	QnaQuestion selectQnaQuestionOne(int qnaNo);
	// 질문 작성 액션
	int insertQnaQuestion(QnaQuestion question);
	//질문 수정 폼
	QnaQuestion updateQnaQuestionForm(int qnaNo);
	// 질문 수정 액션
	int updateQnaQuestion(QnaQuestion qna);
	// 질문 삭제 액션	
	int deleteQnaQuestion(int qnaNo);
	
	
	
	// 답변여부 상태값
	String selectQnaQuestionState(int qnaQuestionNo);
	
	
	/////////////////////////////////////////////////////
		
	// 답변 상세보기
	QnaAnswer selectQnaAnswerOne(int qnaNo);
	// 답변 작성 액션
	int insertQnaAnswer(QnaAnswer qnaAnswer);
	// 답변 수정 폼
	QnaAnswer updateQnaAnswerForm(int qnaNo);
	// 답변 수정 액션
	int updateQnaAnswer(QnaAnswer qna);
	// 답변 삭제 액션	
	int deleteQnaAnswer(int qnaNo);

	// 상태값 답변완료 처리
	int updateQnaState(int qnaNo);
	
	// 상태값 대기중 처리
	int updateQnaStateBack(int qnaNo);
}
