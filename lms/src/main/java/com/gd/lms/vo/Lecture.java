package com.gd.lms.vo;

import lombok.Data;

@Data
public class Lecture {
	private String lectureName;			// 강좌명
	private String lectureActive;		// 강좌 개설 현황
	private String teacherName;			// 배정된 강사이름
	private String managerName;			// 배정된 행정 이름
	private String founderName;			// 강의 개설자
	private String lectureRoomName; 	// 강의실 이름
	private int lectureMaxStudent;		// 강의 정원 수
	private String lectureStartDate;	// 강좌 시작일
	private String lectureEndDate;		// 강좌 종료일
	private String createDate; 			// 강좌 정보 수정일
	private String updateDate; 			// 강좌 개설일
	

}
