package com.gd.lms.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
//회원가입을 위한 행정, 선생, 학생 항목들을 모아놓은 MemberVO
public class Member {				
	private String accountId;
	private String accountPw;
	private String memberName;
	private String memberGender;
	private String memberBirth;
	private String memberEmail;
	private String memberAddress;
	private String memberDetailAddress;
	private String memberPhone;
	private String memberGraduate;
	private String memberMajor;
	private String memberMilitary;
	private String memberDept;
	private String memberCheck;
	private String accountLevel;
	private MultipartFile memberFile;
}
