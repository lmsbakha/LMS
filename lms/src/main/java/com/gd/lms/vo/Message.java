package com.gd.lms.vo;

import lombok.Data;

@Data
public class Message {
	private int messageNo;			// 메시지 번호
	private String fromId;			// 발신자 아이디
	private String toId;			// 수신자 아이디
	private String fromName;		// 발신자 이름
	private String toName;			// 수신자 이름
	private String messageContent;	// 쪽지 내용
	private String isConfirm;		// 확인 여부
	private String messageDatetime;	// 보낸 시간
}
