package com.gd.lms.vo;

import lombok.Data;

@Data
public class NoticeFile {
	private int noticeFileNo;				// NoticeFile 인덱스 번호
	private int noticeNo;					// 공지사항 번호
	private String accountId;				// 계정 아이디
	private String noticeFileName;			// 공지사항 파일 새 이름
	private String noticeFileOriginName;	// 공지사항 파일 원본 이름
	private String noticeFileType;			// 공지사항 파일 타입
	private int noticeFileSize;				// 공지사항 파일 크기
	private String createDate;				// 공지사항 파일 등록일
}
