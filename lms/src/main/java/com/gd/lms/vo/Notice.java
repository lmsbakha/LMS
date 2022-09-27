package com.gd.lms.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Notice {
	private int noticeNo;			// 공지사항 번호
	private String accountId;		// 계정 아이디
	private String noticeTitle;		// 공지사항 제목
	private String noticeContent;	// 공지사항 내용
	private int noticeCount;		// 조회수
	private String createDate;		// 작성일
	private String updateDate;		// 수정일
	private MultipartFile noticeFile;	
}
