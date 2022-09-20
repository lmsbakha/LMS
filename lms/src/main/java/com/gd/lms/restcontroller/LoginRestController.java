package com.gd.lms.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginRestController {
	@Autowired
	AccountService accountService;

	// 아이디 중복체크
	@GetMapping("/idck")
	public String idck(@RequestParam(value = "idck") String idck) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController 아이디 중복체크 idck : " + idck + TeamColor.TEXT_RESET);
		// 아이디 중복체크 후 중복된 cnt 받아오기
		int cnt = accountService.accountIdCheck(idck);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController 아이디 중복체크 cnt : " + cnt + TeamColor.TEXT_RESET);

		// 중복된 아이디가 있는지 확인
		if (cnt == 1) {
			return "false";
		}
		return idck;
	}

	// 이메일 중복체크
	@GetMapping("/email")
	public String email(@RequestParam(value = "email") String email) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController 이메일 중복체크 email : " + email + TeamColor.TEXT_RESET);
		// 이메일 중복체크 후 중복된 cnt 받아오기
		int cnt = accountService.studentEmailCheck(email);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController - student 이메일 중복체크 cnt : " + cnt + TeamColor.TEXT_RESET);
		int cnt2 = accountService.teacherEmailCheck(email);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController - teacher 이메일 중복체크 cnt : " + cnt + TeamColor.TEXT_RESET);
		int cnt3 = accountService.managerEmailCheck(email);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginRestController - manager 이메일 중복체크 cnt : " + cnt + TeamColor.TEXT_RESET);
		// 중복된 이메일 있는지 확인
		if (cnt == 1) {
			return "false";
		}
		if (cnt2 == 1) {
			return "false";
		}
		if (cnt3 == 1) {
			return "false";
		}
		return email;

	}
}
