package com.gd.lms.vo;

import lombok.Data;

@Data
public class ReportSubmit {
	private int reportSubmitNo;			// reportSubmit 인덱스 번호
	private int educationNo;			// education 번호
	private int reportNo;				// report 번호
	private String accountId;			// 계정 아이디
	private String reportSubmitTitle;	// 제줄한 과제 제목
	private String reportSubmitContent;	// 제줄한 과제 내용
	private String reportSubmitScore;	// 제줄한 과제 점수
	private String updateDate;			// 제줄한 과제 수정일
	private String createDate;			// 제줄한 과제 등록일
}
