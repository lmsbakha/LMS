package com.gd.lms.vo;

import lombok.Data;

@Data
public class ExamAnswer {
	private int examNo;					// exam 인덱스번호
	private int educationNo;			// education 번호
	private String examAnswerContent;	// 정답
	private String createDate;			// 답안 제출일
}
