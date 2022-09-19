package com.gd.lms.vo;

import lombok.Data;

@Data
public class Teacher {
	private String accountId; 			// 계정 아이디
	private String teacherName; 		// 강사 이름
	private String teacherGender; 		// 강사 성별
	private String teacherBirth; 		// 강사 생년월일
	private String teacherEmail; 		// 강사 이메일
	private String teacherAddress; 		// 강사 주소
	private String teacherPhone; 		// 강사 전화번호
	private String teacherGraduate;		// 강사 최종학력
	private String teacherMajor;		// 강사 전공
	private String createDate;			// 강사 등록일
	private String updateData; 			// 강사 수정일
}
