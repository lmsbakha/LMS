package com.gd.lms.vo;

import lombok.Data;

@Data
public class QnaQuestion {
	private int qnaQuestionNo;				// qna 인덱스 번호
	private String qnaQuestionTitle;		// 문의사항 제목		
	private String qnaQuestionContent;		// 문의사항 내용	
	private String accountId;				// 계정 아이디	
	private String qnaQuestionDisclosure;	// 문의사항 공개여부 (공개/비공개)=> 제목 옆 자물쇠 아이콘으로 구분, 글 작성 시 체크박스로 여부 설정 가능
	private String qnaQuestionKind;			// 문의사항 글 종류 (질문/답변)
	private String qnaQuestionState;		// 문의사항 현황 (대기중/답변완료)
	private String createDate;				// 문의사항 등록일
}
