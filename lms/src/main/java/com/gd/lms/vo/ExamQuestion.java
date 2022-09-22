package com.gd.lms.vo;

import lombok.Data;

@Data
public class ExamQuestion {
	private int examNo;	// 시험 번호
	private int examQuestionNo;	// 시험 문제 번호
	private int questionNo;	//문제은행 속 문제 번호
	private String questionType;	//문제 타입(객관식,단답형) 
}
