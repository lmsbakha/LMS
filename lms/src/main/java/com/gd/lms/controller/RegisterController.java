package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	// register.jsp 접속시 나타나는 회원가입 폼
	// 파라미터 : X
	// 리턴값 : 회원가입 폼
	@GetMapping("/register")
	public String login(HttpSession session) {
		return "register";
	}
	
	// register.jsp
	
}
