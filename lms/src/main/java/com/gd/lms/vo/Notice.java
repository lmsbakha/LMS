package com.gd.lms.vo;

import lombok.Data;

@Data
public class Notice {
	private int noticeNo;
	private String accountId;
	private String noticeTitle;
	private String noticeContent;
	private int noticeCount;
	private String createDate;
	private String updateDate;
}
