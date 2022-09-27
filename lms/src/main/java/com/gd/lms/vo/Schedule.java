package com.gd.lms.vo;

import lombok.Data;

@Data
public class Schedule {
	private int scheduleNo;			// schedule 인덱스 번호
	private String scheduleDate;	// 일정 당일
	private String lectureName;		// Class 이름
	private String createDate;		// 일정 등록일
	private String updateDate;		// 일정 수정일
}
