package com.gd.lms.vo;

import lombok.Data;

@Data
public class ReportSubmitFile {
	private int reportSubmitFileNo;
	private int reportSubmitNo;
	private String reportSubmitFilename;
	private String reportSubmitOriginName;
	private int reportSubmitFileSize;
	private String reportSubmitFileType;
	private String createDate;
}
