package com.gd.lms.vo;

import lombok.Data;

@Data
public class MultiplechoiceExample {
	private int questionNo; // 객관식 문제 번호
	private String multiplechoiceExampleId; // (1,2,3,4,5) 객관식 지문 번호
	private String multiplechoiceExampleContent; // 객관식 문제 보기 지문
	private String createDate; // 객관식 문제 보기 최초 작성일
	private String updateDate; // 객관식 문제 보기 수정일
}
