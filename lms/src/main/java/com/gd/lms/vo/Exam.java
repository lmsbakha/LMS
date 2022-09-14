package com.gd.lms.vo;

import lombok.Data;

@Data
public class Exam {
	private int examNo;
	private String subjectName;
	private String examName;
	private String examTitle;
	private String examContent;
	private int totalCnt;
	private String examStartDate;
	private String examEndDate;
	private String createDate;
	private String updateDate;
	
	
}
