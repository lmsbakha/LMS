package com.gd.lms.vo;

import lombok.Data;

@Data
public class ScheduleCalendar {
	private int scheduleNo;				// schedule 인덱스 번호
	private int scheduleDateDay;		// 일정 일 ex) 1일 2일 
	private String lectureName;			// 강의명
	private String subjectName;			// 과목명
}
