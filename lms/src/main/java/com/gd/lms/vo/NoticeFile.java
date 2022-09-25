package com.gd.lms.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeFile {
	private int noticeFileNo;				// NoticeFile 인덱스 번호
	private int noticeNo;					// 공지사항 번호
	private String accountId;				// 계정 아이디
	private String noticeFileName;			// 공지사항 파일 새 이름
	private String noticeFileOriginName;	// 공지사항 파일 원본 이름
	private String noticeFileType;			// 공지사항 파일 타입
	private long noticeFileSize;				// 공지사항 파일 크기
	private String createDate;				// 공지사항 파일 등록일
	private List<MultipartFile> noticeFileList;	// 게시글 하나에 들어있는 파일 리스트
}
