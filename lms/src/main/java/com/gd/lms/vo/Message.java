package com.gd.lms.vo;

import lombok.Data;

@Data
public class Message {
	private int messageNo;
	private String fromId;
	private String toId;
	private String messageContent;
	private String inConfirm;
	private String messageDatetime;
}
