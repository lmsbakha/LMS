package com.gd.lms.vo;

import lombok.Data;

@Data
public class QnaFile {
	private int qnaFileNo; 				// qnaFile 인덱스 번호
	private int qnaNo; 					// qna 번호
	private String accountId; 			// 계정 아이디	
	private String qnaFileName; 		// 문의사항 파일 새 이름
	private String qnaFileOriginName; 	// 문의사항 파일 원본 이름
	private String qnaFileType; 		// 문의사항 파일 타입
	private int qnaFileSize; 			// 문의사항 파일 크기
	private String createDate; 			// 문의사항 파일 등록일
}
