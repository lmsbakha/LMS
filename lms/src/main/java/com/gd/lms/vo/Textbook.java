package com.gd.lms.vo;

import lombok.Data;

@Data
public class Textbook {
	private int textbookISBN;
	private String textbookName;
	private String textbookPublisher;
	private String textbookWriter;
	private int textbookPrice;
	private String createDate;
	private String updateDate;
}
