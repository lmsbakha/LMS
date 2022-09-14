package com.gd.lms.vo;

import lombok.Data;

@Data
public class QnA {
	private int qnaNo;				// qna 인덱스 번호
	private String qnaTitle;		// 문의사항 제목		
	private String qnaContent;		// 문의사항 내용	
	private String accountId;		// 계정 아이디	
	private String qnaDisclosure;	// 문의사항 공개여부 (공개/비공개)
	private String qnaKind;			// 문의사항 글 종류 (질문/답변)
	private String qnaState;		// 문의사항 현황 (대기중/답변완료)
	private String createDate;		// 문의사항 등록일
}
