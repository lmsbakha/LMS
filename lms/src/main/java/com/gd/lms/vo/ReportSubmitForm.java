package com.gd.lms.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReportSubmitForm {
	private String accountId;				// 계정 아이디
	private String reportSubmitTitle;		// 제줄한 과제 제목
	private String reportSubmitContent;		// 제줄한 과제 내용
	private int educationNo;				// education 번호
	private int reportNo;					// report 번호
	private int reportSubmitNo;				// reportSubmit 번호
	private MultipartFile reportSubmitFile; 	
}
