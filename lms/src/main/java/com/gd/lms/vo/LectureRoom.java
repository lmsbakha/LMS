package com.gd.lms.vo;

import lombok.Data;

@Data
public class LectureRoom {
	private String lectureRoomName;		// 강의실 이름
	private String lectureRoomLocation;	// 강의실 위치
	private int lectureRoomMaxStudent;	// 강의실에 들어갈 수 있는 최대 정원
	private String createDate;			// 강의실 정보 생성일
	private String updateDate;			// 강의실 정보 수정일
}
