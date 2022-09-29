package com.gd.lms.vo;

import lombok.Data;

@Data
public class MemberFile {
	private int memberFileNo;				// MemberFile 인덱스 번호
	private String accountId;				// 계정 아이디
	private String memberFileName;			// 사진 첨부파일 새 이름
	private String memberFileOriginName;	// 사진 첨부파일 원본 이름
	private String memberFileType;			// 사진 첨부파일 타입
	private long memberFileSize;			// 사진 첨부파일 크기
	private String createDate;				// 사진 첨부파일 등록일
}
