package com.gd.lms.vo;

import lombok.Data;

@Data
public class Student {
	private String accountId; 			// 계정 아이디
	private String studentName; 		// 학생이름
	private String studentGender; 		// 학생 성별
	private String studentBirth; 		// 학생 생년월일
	private String studentEmail; 		// 학생 이메일
	private String studentAddress; 		// 학생 주소
	private String studentPhone; 		// 학생 전화번호
	private String studentGraduate;		// 학생 최종학력
	private String studentMajor;		// 학생 전공
	private String studentMilitary;		// 학생 병역여부
	private String createDate;			// 학생 등록일
	private String updateData; 			// 학생 수정일
}
