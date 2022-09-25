package com.gd.lms.vo;

import lombok.Data;

@Data
public class ReportSubmitForm {
	private String accountId;			// 계정 아이디
	private String reportSubmitTitle;	// 제줄한 과제 제목
	private String reportSubmitContent;	// 제줄한 과제 내용
	private int educationNo;			// education 번호
	private int reportNo;				// report 번호
	private int reportSubmitNo;				// reportSubmit 번호
	private String reportSubmitFilename;	// 제줄한 과제 첨부파일 새 이름
	private String reportSubmitOriginName;	// 제줄한 과제 첨부파일 기존 이름
	private long reportSubmitFileSize;		// 제줄한 과제 첨부파일 크기
	private String reportSubmitFileType; 	// 제줄한 과제 첨부파일 타입
}
