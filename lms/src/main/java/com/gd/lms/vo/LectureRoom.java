package com.gd.lms.vo;

import lombok.Data;

@Data
public class LectureRoom {
	private String lectureRoomName;
	private String lectureRoomLocation;
	private int lectureRoomMaxStudent;
	private String createDate;
	private String updateDate;
}
