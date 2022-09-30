package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TextbookController {
	// 교재관리 페이지로 이동하는 메소드
	@GetMapping("/loginCheck/textbook")
	public String getTextbookList() {
		return "textbook/textbook";
	}
}
