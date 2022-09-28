package com.gd.lms.vo;

import lombok.Data;

@Data
public class ExamSubmit {
	private int educationNo; //학생의 고유번호
	private int examNo; //시험 고유번호
	private String createDate; //시험을 응시한 날짜
}
