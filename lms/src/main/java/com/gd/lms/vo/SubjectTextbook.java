package com.gd.lms.vo;

import lombok.Data;

@Data
public class SubjectTextbook {
	private int subjectTextbookNo;
	private String subjectName;
	private int textbookISBN;
	private String studentName;
	private String subjectTextbookState;
	private String createDate;
}
