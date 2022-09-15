package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Member;

@Controller
public class RegistController {
	@Autowired MemberService memberservice;
	
	@GetMapping("/register")
	public String join() {
		return "register";
	}
	

	@GetMapping("/submitRegister")
	// 회원가입
	public String register(Member member) {
		
		//List<Member> list = MemberService.addMemberform(member);
		memberservice.addMember(member);	
		
		return "redirect:/index";
	}
	
	
	
	/*public String IdCheck(Member member) {
		
	}
	*/
}
