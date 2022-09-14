package com.gd.lms.vo;

import lombok.Data;

@Data
public class Account {
	private String accountId;
	private String accountPw;
	private String accountEmail;
	private String accountState;
	private int accountLevel;
	private String createDate;
	private String updateDate;
}
