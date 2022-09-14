package com.gd.lms.vo;

import lombok.Data;

@Data
public class TextbookSignFile {
	private int educationNo;					// education 인덱스 번호
	private int subjectTextbookNo;				// subjectTextbook 번호
	private String textbookSignFilename;		// 교재 배부 서명 새 파일명
	private String textbookSignFileOriginName;	// 교재 배부 서명 원본 파일명
	private String textbookSignFileType;		// 교재 배부 서명 파일 타입
	private int textbookSignFileSize;			// 교재 배부 서명 파일 크기
	private String createDate;					// 교재 서명 등록일
}
