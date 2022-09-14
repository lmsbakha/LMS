package com.gd.lms.vo;

import lombok.Data;

@Data
public class ExamAnswer {
	private int examNo;
	private int educationNo;
	private String examAnswerContent;
	private String createDate;
}
