package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;
import com.gd.lms.vo.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	// AccountService 객체 주입
	@Autowired
	AccountService accountService;

	// login.jsp 접속시 나타나는 로그인 폼
	// 파라미터 : HttpSession(sessionLevel)
	// 리턴값 : 로그인 폼
	@GetMapping("/login")
	public String login(HttpSession session) {
		// 기존에 로그인되어 있는 상태(sessionLevel값이 null이 아니면)에서 로그인 폼으로 들어왔을 경우, 인덱스 페이지로 이동
		if (session.getAttribute("sessionLevel") != null) {
			return "redirect:/loginCheck/index";
		} else { // 로그인이 되어있지 않았을 경우
			return "login";
		}
	}

	// login.jsp에서 Login 버튼을 클릭시 로그인 액션을 처리하는 메소드
	// 파라미터 : HttpSession, accountId, accountPw
	// 리턴값 : index 페이지로 이동
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam(value = "accountId") String accountId,
			@RequestParam(value = "accountPw") String accountPw) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + accountPw + "<-- accountPw" + TeamColor.TEXT_RESET);
		// 요청받은 값들을 account 객체에 셋팅
		Account paramAccount = new Account();
		paramAccount.setAccountId(accountId);
		paramAccount.setAccountPw(accountPw);

		// Service call
		// 서비스에서 계정 조회 결과(accountId, accountLevel, accountState) 가져오기
		Account loginAccount = accountService.getLogin(paramAccount);
		// 디버깅
		log.debug(TeamColor.PSJ + loginAccount + "<-- loginAccount" + TeamColor.TEXT_RESET);

		// 계정이 없는 경우 또는 로그인 정보를 잘못 입력했을 경우
		if (loginAccount.getAccountId().isEmpty() == true) {
			log.debug(TeamColor.PSJ + "로그인 정보를 확인해주세요" + TeamColor.TEXT_RESET);
			return "redirect:/login";
		}

		// accountState 상태 값(대기,탈퇴, 거절)에 따라서 처리
		if (loginAccount.getAccountState().equals("대기")) { // 대기 상태
			log.debug(TeamColor.PSJ + "계정 승인 대기중입니다." + TeamColor.TEXT_RESET);
			return "redirect:/login";
		} else if (loginAccount.getAccountState().equals("탈퇴")) { // 탈퇴 상태
			log.debug(TeamColor.PSJ + "탈퇴된 계정입니다." + TeamColor.TEXT_RESET);
			return "redirect:/login";
		} else if (loginAccount.getAccountState().equals("거절")) { // 회원가입 승인 거절 상태
			log.debug(TeamColor.PSJ + "회원가입 승인이 거절된 계정입니다." + TeamColor.TEXT_RESET);
			return "redirect:/login";
		}

		// session에 로그인한 아이디 값과 레벨값 셋팅해주기
		session.setAttribute("sessionId", loginAccount.getAccountId());
		session.setAttribute("sessionLevel", loginAccount.getAccountLevel());

		// 리다이렉트
		// loginCheck에서 sessionId 값을 확인
		return "redirect:/loginCheck/index";
	}

	// 로그아웃을 위한 기능 메소드
	// 매개변수: 세션값(sessionId, sessionLevel)
	// 리턴값: login.jsp (로그인이 되어 있지 않은 상태)
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("sessionId") != null) { // 세션에 sessionId 값이 null이 아니라면
			session.invalidate(); // 세션 초기화
			log.debug(TeamColor.PSJ + "session값을 초기화합니다" + TeamColor.TEXT_RESET);
		}
		return "redirect:/login";
	}
}
