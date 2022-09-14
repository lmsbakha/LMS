package com.gd.lms.vo;

import lombok.Data;

@Data
public class Report {
	private int reportNo;			// report 인덱스 번호
	private String subjectName;		// 과목명
	private String reportTitle;		// 과제 제목
	private String reportContent;	// 과제 내용
	private String reportStartDate;	// 과제 제출 시작일
	private String reportEndDate;	// 과제 제출 마감일
	private String updateDate;		// 과제 수정일
	private String createDate;		// 과제 등록일
}
