package com.gd.lms.vo;

import lombok.Data;

@Data
public class Exam {
	private int examNo;				// Exam 인덱스 번호
	private String subjectName;		// 강좌명
	private String examTitle;		// 시험명 
	private String examContent;		// 시험 설명
	private int totalCnt;			// 문제 갯수
	private String examStartDate;	// 시험 응시 시작시간
	private String examEndDate;		// 시험 응시 마감시간
	private String createDate;		// 수정일
	private String updateDate;		// 출제일
}
