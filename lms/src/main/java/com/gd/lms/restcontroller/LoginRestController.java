package com.gd.lms.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;
import com.gd.lms.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginRestController {
	@Autowired AccountService accountService;
	@Autowired MemberService memberService;

	@GetMapping("/idck")
	public String idck(@RequestParam(value="idck") String idck) {
		
		// accountId 중복 검사 하기 위해 accountId Cnt 받기
		int count = accountService.AccountIdCheck(idck);
		log.debug(TeamColor.PCW + "LoginRestController/idck/GetMapping/count :" + count + TeamColor.TEXT_RESET);
		
		if(count == 1) { // 중복된 acoountId 값이 있다면
			return "false"; // false값 리턴 해준다
		}
		
		return idck;
	}
	
	@GetMapping("/emck")
	public String emck(@RequestParam(value="emck") String emck) {
		
		// email 중복 검사 하기 위해 email cnt 받기
		int count = memberService.MemberEmailCheck(emck);
		log.debug(TeamColor.PCW + "LoginRestController/emck/GetMapping/count :" + count + TeamColor.TEXT_RESET);
		
		if(count == 1) { // 중복된 acoountId 값이 있다면
			return "false"; // false값 리턴 해준다
		}
		
		return emck;
	}
}
