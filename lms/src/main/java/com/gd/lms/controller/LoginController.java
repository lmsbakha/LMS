package com.gd.lms.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
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
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;
import com.gd.lms.vo.MemberFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	// AccountService 객체 주입
	@Autowired
	AccountService accountService;
	// MemberService 객체 주입
	@Autowired
	MemberService memberService;
	
	// 휴면계정 Form
	@GetMapping("/accountStateMember")
	public String accountStateMember() {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(accountStateMember)" + TeamColor.TEXT_RESET);
		
		return "login/accountStateMember";
	}
	
	// 휴면계정 Action
	@PostMapping("/accountStateMember")
	public String accountStateMember(Model model, RedirectAttributes redirectAttributes, Account account) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(accountStateMember) account : " + account + TeamColor.TEXT_RESET);
		
		int row = accountService.modifyAccoutStateByMember(account);
		
		if(row == 0 ) { 
			// 디버깅
			log.debug(TeamColor.PCW + "LoginController PostMapping(accountStateMember) row : " + row + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
			return "redirect:/accountStateMember";
		}
		
		return "redirect:/bakha/login";
	}
	
	// 로그인 Form
	@GetMapping("/bakha/login")
	public String login(HttpSession session) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(login)" + TeamColor.TEXT_RESET);
		// 기존에 로그인되어 있는 상태(session값이 null이 아니면)에서 로그인 폼으로 들어왔을 경우, 인덱스 페이지로 이동
		if (session.getAttribute("sessionLevel") != null) {
			return "redirect:/loginCheck/index";
		} else { // 로그인이 되어있지 않았을 경우
			return "login/login";
		}
	}
	// 로그인 Action
	@PostMapping("/login")
	public String login(Model model, RedirectAttributes redirectAttributes, HttpSession session, Account paramAccount) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(login)" + TeamColor.TEXT_RESET);

		Account account = accountService.getLogin(paramAccount);

		if (account == null) {
			// 디버깅
			log.debug(TeamColor.PCW + "로그인 정보가 일치하지 않습니다." + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
			return "redirect:/bakha/login";
		}

		String accountState = accountService.getAccountState(paramAccount);
		// 디버깅
		log.debug(TeamColor.PCW + accountState + "상태입니다" + TeamColor.TEXT_RESET);
		
		if(accountState.equals("휴면")) {
			// 디버깅
			log.debug(TeamColor.PCW + accountState + "상태입니다" + TeamColor.TEXT_RESET);
			return "redirect:/accountStateMember";
		}
		
		if (!accountState.equals("활성화")) {
			// 디버깅
			log.debug(TeamColor.PCW + accountState + "상태입니다" + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
			redirectAttributes.addFlashAttribute("accountState", accountState);
			return "redirect:/bakha/login";
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

		return "redirect:/bakha/login";
	}
	
	// (학생, 강사, 행정) 멤버 아이디 찾기 Form
	@GetMapping("/searchAccountId")
	public String searchAccountId(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(searchAccountId)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return"login/searchAccountId";
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
		
		return "login/searchAccountId";
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 Form
	@GetMapping("/searchAccountPw")
	public String searchAccountPw(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMapping(searchAccountPw) memberCheck" + memberCheck + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return "login/searchAccountPw"; 
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 Action
	@PostMapping("/searchAccountPw")
	public String searchAccountPw(Model model, RedirectAttributes redirectAttributes
										     , @RequestParam(value="memberCheck") String memberCheck
									         , @RequestParam(value="accountId") String accountId
										     , @RequestParam(value="memberName") String memberName) {
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController PostMappingg(searchAccountPw) memberCheck : " + memberCheck + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " LoginController PostMappingg(searchAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " LoginController PostMappingg(searchAccountPw) memberName : " + memberName + TeamColor.TEXT_RESET);
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberCheck", memberCheck);
		map.put("accountId", accountId);
		map.put("memberName", memberName);
		
		int cnt = accountService.searchMemberAccountPw(map);
		
		if(cnt == 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
			return "redirect:/searchAccountPw";
		}
		
		model.addAttribute("accountId", accountId);
		
		return "login/modifySearchAccountPw";
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 변경 Form - 찾기를 통해 변경하는 경우
	@GetMapping("/modifySearchAccountPw")
	public String searchModifyAccountPw(Model model , @RequestParam(value="accountId") String accountId) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(modifySearchAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		model.addAttribute("accountId", accountId);
		
		return "login/modifySearchAccountPw";
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 변경 Action - 찾기를 통해 변경하는 경우
	@PostMapping("/modifySearchAccountPw")
	public String searchModifyAccountPw(Account account) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController PostMappingg(searchModifyAccountPw) account : " + account + TeamColor.TEXT_RESET);
		
		accountService.modifySearchMemberAccountPw(account);
		
		return "login/login";
	}
	
	// index Form
	@GetMapping("/loginCheck/index")
	public String index(Model model, HttpSession session) {
		Account account = new Account();
		
		// sessionId & sessionLevel 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(/loginCheck/index) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		int accountLevel = (int)session.getAttribute("sessionLevel");
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(/loginCheck/index) accountLevel : " + accountLevel + TeamColor.TEXT_RESET);
		
		account.setAccountId(accountId);
		account.setAccountLevel(accountLevel);
		
		// MemberFile 멤버사진 받아오기
		Map<String,Object> memberMap = memberService.getMemberOne(account);
		MemberFile memberFile = (MemberFile) memberMap.get("memberFile");
		String memberFileName = memberFile.getMemberFileName();
		session.setAttribute("memberFileName", memberFileName);
		model.addAttribute("memberFile", memberFile);
		
		
		return "/login/index";
	}
	
	// 회원가입 Form
	@GetMapping("/register")
	public String register(Model model, @RequestParam(value="memberCheck", defaultValue="student") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(register)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		return "login/register";
	}
	
	// 회원가입 Action
	@PostMapping("/register")
	public String register(HttpServletRequest request, Member paramMember) {
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(register) paramMember : " + paramMember  + TeamColor.TEXT_RESET);
		
		// 이미지를 업로드할 폴더를 설정 
		String path = request.getServletContext().getRealPath("/file/memberPhoto/");  
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(register) path : " + path  + TeamColor.TEXT_RESET);
		// 업로드한 이미지파일명 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(register) fileName: " + paramMember.getMemberFile().getOriginalFilename() + TeamColor.TEXT_RESET);
		
		accountService.addMember(paramMember, path);
		
		return "redirect:/bakha/login";
	}

	// 회원가입 승인 대기리스트 Form
	@GetMapping("/loginCheck/approveWaitMemberList")
	public String modifyAccountStateWaitMember(Model model, @RequestParam(value="memberCheck", defaultValue="all") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/approveWaitMemberList)" + TeamColor.TEXT_RESET);
		
		Map<String, Object> resultMap = accountService.approveWaitMemberList();
		model.addAttribute("studentList", resultMap.get("studentList"));
		model.addAttribute("teacherList", resultMap.get("teacherList"));
		model.addAttribute("managerList", resultMap.get("managerList"));
		model.addAttribute("memberCheck", memberCheck);
		return "login/approveWaitMemberList";
	}
	
	// 회원가입 승인 Form
	@GetMapping("/loginCheck/modifyApproveWaitMemberList")
	public String modifyApproveWaitMember(@RequestParam(value="accountId") String accountId) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/modifyApproveWaitMemberList) accountId :" + accountId + TeamColor.TEXT_RESET);
		
		int row = accountService.modifyApproveWaitMemberList(accountId);
		
		if(row == 0) {
			return "login/approveWaitMemberList";
		}
		
		return "redirect:/loginCheck/approveWaitMemberList";
	}
	
	// 회원가입 거절 Form
	@GetMapping("/loginCheck/modifyDeniedWaitMemberList")
	public String modifyDeniedWaitMember(@RequestParam(value="accountId") String accountId) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/modifyDeniedWaitMemberList) accountId :" + accountId + TeamColor.TEXT_RESET);
		
		int row = accountService.modifyDeniedWaitMemberList(accountId);
		
		if(row == 0) {
			return "login/approveWaitMemberList";
		}
		
		return "redirect:/loginCheck/approveWaitMemberList";
	}
}
