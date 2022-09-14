package com.gd.lms.vo;

import lombok.Data;

@Data
public class QnaFile {
	private int qnaFileNo;
	private int qnaNo;
	private String accountId;
	private String qnaFileName;
	private String qnaFileOriginName;
	private String qnaFileType;
	private int qnaFileSize;
	private String createDate;
}
