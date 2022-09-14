package com.gd.lms.vo;

import lombok.Data;

@Data
public class ReportSubmit {
	private int reportSubmitNo;
	private int educationNo;
	private int reportNo;
	private String accountId;
	private String reportSubmitTitle;
	private String reportSubmitContent;
	private int reportSubmitScore;
	private String updateDate;
	private String createDate;
	
}
