package com.gd.lms.vo;

import lombok.Data;

@Data
public class Attendance {
	private int attendanceNo; 			// attendance 인덱스번호
	private int scheduleNo;				// schedule 번호
	private int educationNo;			// education 번호
	private String attendanceState;		// 출석 상태
	private String attendanceReason;	// 조퇴/결석 이유
}
