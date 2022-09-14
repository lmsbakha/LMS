package com.gd.lms.vo;

import lombok.Data;

@Data
public class LectureSubject {
	private int lectureSubjectNo;	// lectureSubject 인덱스 번호
	private String subjectName;		// 강좌명
	private String lectureName;		// 과목명
}
