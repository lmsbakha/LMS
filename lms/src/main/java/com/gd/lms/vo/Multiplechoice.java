package com.gd.lms.vo;

import lombok.Data;

@Data
public class Multiplechoice {
	private int multiplechoiceNo;			// Multiplechoice 인덱스 번호
	private String subjectName;				// 과목명
	private String multiplechoiceQuestion;	// 객관식 문제 지문
	private String multiplechoiceAnswer;	// 객관식 문제 정답
	private int multiplechoiceScore;		// 객관식 문제 할당 점수
	private String createDate;				// 객관식 문제 수정일
	private String updateDate;				// 객관식 문제 작성일
}
