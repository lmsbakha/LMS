package com.gd.lms.vo;

import lombok.Data;

@Data
public class Admin {
	private String accountId; 			// 계정 아이디
	private String adminName; 			// 총관리자 이름
	private String adminEmail; 			// 총관리자 이메일
	private String adminPhone; 			// 총관리자 전화번호
	private String createDate;			// 총관리자 등록일
	private String updateData; 			// 총관리자 수정일
}
