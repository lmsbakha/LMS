package com.gd.lms.vo;

import lombok.Data;

@Data
public class TextbookSignFile {
	private int educationNo;
	private int subjectTextbookNo;
	private String textbookSignFilename;
	private String textbookSignFileOriginName;
	private String textbookSignFileType;
	private int textbookSignFileSize;
	private String createDate;
}
