package com.gd.lms.vo;

import lombok.Data;

@Data
public class ReportSubmitFile {
	private int reportSubmitFile;			// reportSubmitFile 인덱스 번호
	private int reportSubmitNo;				// reportSubmit 번호
	private String reportSubmitFilename;	// 제줄한 과제 첨부파일 새 이름
	private String reportSubmitOriginName;	// 제줄한 과제 첨부파일 기존 이름
	private int reportSubmitFileSize;		// 제줄한 과제 첨부파일 크기
	private String reportSubmitFileType; 	// 제줄한 과제 첨부파일 타입
	private String createDate;				// 제줄한 과제 첨부파일 등록일
}
