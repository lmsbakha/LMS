package com.gd.lms.vo;

import lombok.Data;

@Data
public class Manager {
	private String accountId; 				// 계정 아이디
	private String managerName; 			// 행정 이름
	private String managerGender; 			// 행정 성별
	private String managerBirth; 			// 행정 생년월일
	private String managerEmail; 			// 행정 이메일
	private String managerAddress; 			// 행정 주소
	private String managerDetailAddress; 	// 행정 상세주소
	private String managerPhone; 			// 행정 전화번호
	private String managerDept;				// 행정 부서
	private String createDate;				// 행정 등록일
	private String updateData; 				// 행정 수정일
}
