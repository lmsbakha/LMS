package com.gd.lms.vo;

import lombok.Data;

@Data
public class SubjectTextbook {
	private int subjectTextbookNo;			// subjectTextbook 인덱스 번호
	private String subjectName;				// 과목명
	private int textbookIsbn;				// 교재 국제 표준 도서 번호
	private String studentName;				// 교재 배부받은 학생명
	private String subjectTextbookState;	// 교재 배부 현황
	private String createDate;				// 교재 배부일
}
