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
	int insertQuestion(QnaQuestion question);
	// 질문 수정 액션
	int updateQuestion(QnaQuestion qna);
	// 질문 삭제 액션	
	int deleteQuestion(int questionNo);
	
	/////////////////////////////////////////////////////
		
	// 답변 상세보기
	QnaAnswer selectQnaAnswerOne(int qnaNo);
	
	// 답변 작성 액션
	int insertAnswer(QnaAnswer answer);
	// 답변 수정 액션
	int updateAnswer(QnaAnswer qna);
	// 답변 삭제 액션	
	int deleteAnswer(int questionNo);

}
