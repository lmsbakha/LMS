package com.gd.lms.vo;

import lombok.Data;

@Data
public class Lecture {
	private String lectureName;			// 강좌명
	private String teacherName;			// 배정된 강사이름
	private String managerName;			// 배정된 행정 이름
	private String founderName;			// 강의 개설자
	private String lectureRoomName; 	// 강의실 이름
	private int lectureMaxStudent;		// 강의 정원 수
	private String lectureActive;		// 강좌 개설 현황(개설대기/개설승인) - admin에서 승인을 해주면 개설승인으로 변경
	private String lectureState;		// 강좌 상태(대기/수강/수료) - 대기---<강좌시작일>---수강---<강좌종료일>---수료
	private String lectureStartDate;	// 강좌 시작일
	private String lectureEndDate;		// 강좌 종료일
	private String createDate; 			// 강좌 정보 수정일
	private String updateDate; 			// 강좌 개설일
	
}
