package com.gd.lms.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReportSubmitForm {
	// ReportSubmit reportSubmit, List<MultipartFile> multiList를 입력 받아야 함.
	private ReportSubmit reportSubmit;
	private List<MultipartFile> multiList;
	private String reportSubmitTitle;
	private String reportSubmitContent;
}
