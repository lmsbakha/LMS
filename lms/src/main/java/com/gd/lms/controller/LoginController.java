package com.gd.lms.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	// AccountService 객체 주입
	@Autowired
	AccountService accountService;

	// 로그인 Form
	@GetMapping("/login")
	public String login(HttpSession session) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/login)" + TeamColor.TEXT_RESET);
		// 기존에 로그인되어 있는 상태(session값이 null이 아니면)에서 로그인 폼으로 들어왔을 경우, 인덱스 페이지로 이동
		if (session.getAttribute("sessionLevel") != null) {
			return "redirect:/loginCheck/index";
		} else { // 로그인이 되어있지 않았을 경우
			return "login";
		}
	}

	@PostMapping("/login")
	public String login(Model model, HttpSession session, Account paramAccount) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(login)" + TeamColor.TEXT_RESET);

		Account account = accountService.getLogin(paramAccount);

		if (account == null) {
			// 디버깅
			log.debug(TeamColor.PCW + "로그인 정보가 일치하지 않습니다." + TeamColor.TEXT_RESET);
			return "redirect:/login";
		}

		String accountState = accountService.getAccountState(paramAccount);
		// 디버깅
		log.debug(TeamColor.PCW + accountState + "상태입니다" + TeamColor.TEXT_RESET);
		if (!accountState.equals("활성화")) {
			// 디버깅
			log.debug(TeamColor.PCW + "계정이 활성화 되지 않았습니다." + TeamColor.TEXT_RESET);
			model.addAttribute("accountState", accountState);
			return "login";
		} 
		
		session.setAttribute("sessionId", account.getAccountId());
		session.setAttribute("sessionLevel", account.getAccountLevel());

		return "redirect:/loginCheck/index";
	}
	
	// 로그아웃
	@GetMapping("/loginCheck/logout")
	public String logout(HttpSession session) {

		// 로그아웃하면 세션 끊기
		session.invalidate();
		// 디버깅
		log.debug(TeamColor.PCW + "계정이 로그아웃 되었습니다." + TeamColor.TEXT_RESET);

		return "redirect:/login";
	}
	
	// (학생, 강사, 행정) 멤버 아이디 찾기 Form
	@GetMapping("/searchAccountId")
	public String searchAccountId(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(searchAccountId)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return"searchAccountId";
	}
	
	// (학생, 강사, 행정) 멤버 아이디 찾기 Action
	@PostMapping("/searchAccountId")
	public String searchAccountId(Model model, @RequestParam(value="memberCheck") String memberCheck
											, @RequestParam(value="memberName") String memberName
											, @RequestParam(value="memberEmail") String memberEmail) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(searchAccountId) memberCheck : " + memberCheck + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "LoginController PostMapping(searchAccountId) memberName : " + memberName + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "LoginController PostMapping(searchAccountId) memberEmail : " + memberEmail + TeamColor.TEXT_RESET);
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberCheck", memberCheck);
		map.put("memberName", memberName);
		map.put("memberEmail", memberEmail);
		
		
		String resultMsg = accountService.searchMemberAccountId(map);
		   if (resultMsg != null) {
			   model.addAttribute("alertMsg", "Success");
		      } else {
		       model.addAttribute("alertMsg", "Fail");
		      }
		
		model.addAttribute("resultMsg", resultMsg);
		
		return "searchAccountId";
	}
	// index Form
	@GetMapping("/loginCheck/index")
	public String index() {
		return "/login/index";
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 Form
	@GetMapping("/searchAccountPw")
	public String searchAccountPw(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(searchAccountPw)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return "searchAccountPw"; 
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 Action
	
	
	// 회원가입 Form
	@GetMapping("/register")
	public String register(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(register)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return "register";
	}
	
	// 회원가입 Action
	@PostMapping("/register")
	public String register(HttpSession session, Member paramMember) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(register)" + TeamColor.TEXT_RESET);
		accountService.addMember(paramMember);
		
		return "redirect:/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
