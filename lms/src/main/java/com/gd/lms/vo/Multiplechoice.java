package com.gd.lms.vo;

import lombok.Data;

@Data
public class Multiplechoice {
	private int questionNo; // Multiplechoice 인덱스 번호(PK)
	private String subjectName; // 과목명
	private String questionTitle; // 객관식 문제 지문
	private String questionAnswer; // 객관식 문제 정답(1,2,3,4,5)
	private String createDate; // 객관식 문제 최초 작성일
	private String updateDate; // 객관식 문제 수정일
}
