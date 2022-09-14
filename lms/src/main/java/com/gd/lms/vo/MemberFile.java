package com.gd.lms.vo;

import lombok.Data;

@Data
public class MemberFile {
	private int memberFileNo;
	private String accountId;
	private String memberFileName;
	private String memberFileOriginName;
	private String memberFileType;
	private int memberFileSize;
	private String createDate;
}
