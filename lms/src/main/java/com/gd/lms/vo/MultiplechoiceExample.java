package com.gd.lms.vo;

import lombok.Data;

@Data
public class MultiplechoiceExample {
	private String multiplechoiceExampleId;			// (1,2,3,4,5) 객관식 지문 번호
	private int multiplechoiceNo;					// 객관식 문제 번호
	private String multiplechoiceExampleContent;	// 객관식 문제 보기 지문
	private String createDate;						// 객관식 문제 보기 수정일
	private String updateDate;						// 객관식 문제 보기 작성일
}
