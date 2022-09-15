package com.gd.lms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegisterController {
	//MemberService 객체 주입
	@Autowired private MemberService memberService;
	
	// register.jsp 접속시 나타나는 회원가입 폼
	// 파라미터 : X
	// 리턴값 : 회원가입 폼
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	// register.jsp에서 받아온 회원정보를 이용해서 회원가입하는 액션 메소드
	// 파라미터 : member
	// 리턴값 : 로그인 폼으로 이동하기
	@PostMapping("/register")
	public String register(@RequestParam(value = "accountId") String accountId,
			@RequestParam(value = "memberName") String memberName,
			@RequestParam(value = "memberGender") String memberGender,
			@RequestParam(value = "memberBirth") String memberBirth,
			@RequestParam(value = "memberEmail") String memberEmail,
			@RequestParam(value = "memberPhone") String memberPhone,
			@RequestParam(value = "memberAddress") String memberAddress,
			@RequestParam(value = "memberDetailAddress") String memberDetailAddress,
			@RequestParam(value = "accountLevel") int accountLevel) {
		// 요청받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("accountId", accountId);
		paramMap.put("memberName", memberName);
		paramMap.put("memberGender", memberGender);
		paramMap.put("memberBirth", memberBirth);
		paramMap.put("memberEmail", memberEmail);
		paramMap.put("memberPhone", memberPhone);
		paramMap.put("memberAddress", memberAddress);
		paramMap.put("memberDetailAddress", memberDetailAddress);
		paramMap.put("accountLevel", accountLevel);
		// 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
		// service call
		int row = memberService.addMember(paramMap);

		if (row != 0) { // 성공
			// 파라미터 디버깅
			log.debug(TeamColor.PSY + " 회원가입 성공" + TeamColor.TEXT_RESET);
			return "redirect:/login";
		} else { // 실패
			log.debug(TeamColor.PSY + " 회원가입 실패" + TeamColor.TEXT_RESET);
			return "redirect:/register";
		}
	}
}
