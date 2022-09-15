package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegisterController {
	@Autowired
	MemberService memberService;

	// login.jsp 접속시 나타나는 로그인 폼
	// 파라미터 : HttpSession(sessionLevel)
	// 리턴값 : 로그인 폼	
	// 멤버 회원가입 Form
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	// 멤버 회원가입 Action
	@PostMapping("/register")
	public String register(Member member) {
		int row = memberService.addMember(member);
		// 디버깅
		if (row != 0) { // 성공
			log.debug(TeamColor.debuging+" add 성공" + TeamColor.PSY + TeamColor.TEXT_RESET);
		} else { // 실패
			log.debug(TeamColor.debuging+" add 실패" + TeamColor.PSY + TeamColor.TEXT_RESET);
		}
		return "redirect:/login";
	}

}
