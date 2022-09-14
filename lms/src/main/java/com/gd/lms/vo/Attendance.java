package com.gd.lms.vo;

import lombok.Data;

@Data
public class Attendance {
	private int attendanceNo;
	private int scheduleNo;
	private int educationNo;
	private String attendanceState;
	private String attendanceReason;
}
