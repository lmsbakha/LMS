package com.gd.lms.vo;

import lombok.Data;

@Data
public class Education {
	private int educationNo;		// 인덱스 번호
	private String lectureName;		// 강좌명
	private String accountId;		// 계정 아이디
	private String educationState;	// 수강현황
	private String educationDate;	// 당일 날짜
}
