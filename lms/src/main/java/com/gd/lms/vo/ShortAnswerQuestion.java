package com.gd.lms.vo;

import lombok.Data;

@Data
public class ShortAnswerQuestion {
	private int shortAnswerQuestionNo;			// shortAnswerQuestion 인덱스 번호
	private String lectureName;					// 강좌명
	private String shortAnswerQuestion;			// 단답형 문제 타이틀
	private String shortAnswerQuestionAnswer;	// 단답형 문제 정답
	private String updateDate;					// 문제 수정일
	private String createDate;					// 문제 작성일
}
