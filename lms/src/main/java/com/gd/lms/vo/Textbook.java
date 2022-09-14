package com.gd.lms.vo;

import lombok.Data;

@Data
public class Textbook {
	private int textbookIbsn;			// 교재 국제 표준 도서 번호
	private String textbookName;		// 교재명
	private String textbookPublisher;	// 교재 출판사
	private String textbookWriter;		// 교재 저자
	private int textbookPrice;			// 교재 가격
	private String createDate;			// 교재 정보 등록일
	private String updateDate;			// 교재 정보 수정일
}
