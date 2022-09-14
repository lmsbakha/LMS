package com.gd.lms.vo;

import lombok.Data;

@Data
public class QnA {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String accountId;
	private String createDate;
	private String qnaDisclosure;	// 공개 or 비공개
	private String qnaKind;			// 질문 or 답변
	private String qnaState;		// 대기중 or 답변완료
	
	
}
