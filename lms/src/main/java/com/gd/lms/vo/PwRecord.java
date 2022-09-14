package com.gd.lms.vo;

import lombok.Data;

@Data
public class PwRecord {
	private String accountId;	// 계정 아이디
	private String accountPw;	// 계정 비밀번호
	private String updateDate;	// 비밀번호 수정일		
}
