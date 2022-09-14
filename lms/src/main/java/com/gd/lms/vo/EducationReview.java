package com.gd.lms.vo;

import lombok.Data;

@Data
public class EducationReview {

	private int educationNo;				// education 인덱스 번호
	private String educationReviewStar;		// 강의 만족도
	private String educationReviewContent;	// 리뷰 내용
	private String createDate;				// 수정일
	private String updateDate;				// 작성일
}
