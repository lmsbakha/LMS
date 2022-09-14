package com.gd.lms.vo;

import lombok.Data;

@Data
public class Report {
	private int reportNo;
	private String subjectName;
	private String reportTitle;
	private String reportContent;
	private String reportStartDate;
	private String reportEndDate;
	private String updateDate;
	private String createDate;
}
