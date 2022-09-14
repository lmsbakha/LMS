package com.gd.lms.vo;

import lombok.Data;

@Data
public class Member {
	private String accountId;			// 계정 아이디
	private String memberName;			// 회원 이름
	private String memberGender;		// 회원 성별
	private String memberBirth;			// 회원 생년월일
	private String memberEmail;			// 회원 메일
	private String memberPhone;			// 회원 연락처
	private String memberAddress;		// 회원 주소
	private String memberDetailAddress;	// 계정 회원 상세주소
	private String memberMilitary;		// 회원 군필여부
	private String memberMarry;			// 회원 결혼여부
	private String memberGraduate;		// 최종학력 선택
	private String managerIdAccess;		// 담당 매니저
	private String createDate;			// 정보 수정일
	private String updateDate;			// 계정 가입일
}
