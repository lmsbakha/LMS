package com.gd.lms.vo;

import lombok.Data;

@Data
public class ExamAnswer {
	private int examNo;					// exam 인덱스번호
	private int educationNo;			// education 번호
	private String examAnswerContent;	// 정답
	private String examAnswerState;		// 제출한 답안이 정답인지 오답이지
	private String createDate;			// 답안 제출일
}
