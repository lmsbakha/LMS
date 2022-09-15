package com.gd.lms.vo;

import lombok.Data;

@Data
public class Account {
	private String accountId;		// 계정 아이디
	private String accountPw;		// 계정 비밀번호
	private String accountState;	// 계정 활성화 여부
	private int accountLevel;		// 계정 권한
	private String createDate;		// 계정 생성일
	private String updateDate;		// 계정 수정일
}
