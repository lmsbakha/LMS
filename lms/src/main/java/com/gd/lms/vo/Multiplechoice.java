package com.gd.lms.vo;

import lombok.Data;

@Data
public class Multiplechoice {
	private int multiplechoiceNo;
	private String subjectName;
	private String multiplechoiceQuestion;
	private String multiplechoiceAnswer;
	private int multiplechoiceScore;
	private String createDate;
	private String updateDate;
	
}
