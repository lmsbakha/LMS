package com.gd.lms.vo;

import lombok.Data;

@Data
public class OutRecord {
	private String accountId;	// 계정 아이디
	private String outReason;	// 탈퇴사유
	private String createDate;	// 탈퇴 아이디 등록일
}
