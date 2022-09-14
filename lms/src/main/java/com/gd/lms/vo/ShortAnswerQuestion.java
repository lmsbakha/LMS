package com.gd.lms.vo;

import lombok.Data;

@Data
public class ShortAnswerQuestion {
	private int shortAnswerQuestionNo;
	private String lectureName;
	private String shortAnswerQuestion;
	private String shortAnswerQuestionAnswer;
	private String updateDate;
	private String createDate;
}
