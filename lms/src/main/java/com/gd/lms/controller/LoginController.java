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
import com.gd.lms.service.ScheduleService;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;
import com.gd.lms.vo.MemberFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	// AccountService 객체 주입
	@Autowired
	private AccountService accountService;
	// MemberService 객체 주입
	@Autowired
	private MemberService memberService;
	
	// ScheduleService 객체 주입
	@Autowired 
	private ScheduleService scheduleService;
	
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
		
		// 마지막 비밀번호 변경 며칠 지났는지
		int pwRecordDiffDate = accountService.getAccountPwRecordByDiffDate(paramAccount.getAccountId());
		// 디버깅
		log.debug(TeamColor.PCW + " pwRecordDiffDate : " + pwRecordDiffDate + TeamColor.TEXT_RESET);
		if(pwRecordDiffDate > 90) { // 90일 이상 지났다면
			String msg = "later";
			model.addAttribute("accountId", account.getAccountId());
			model.addAttribute("msg", msg);
			// 로그인 성공 분기
			account = accountService.getLogin(paramAccount);
			if(account == null) {
				log.debug(TeamColor.PCW + "로그인 정보가 일치하지 않습니다." + TeamColor.TEXT_RESET);
				redirectAttributes.addFlashAttribute("alertMsg", "Fail");
				return "redirect:/bakha/login";  // 로그인 실패시
			}
			return "login/login"; // 로그인 성공시
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
	
	// 비밀번호 연장 Form
	@GetMapping("/laterAccountPw")
	public String laterAccountPw(RedirectAttributes redirectAttributes
								, @RequestParam(value = "later") String later
								, @RequestParam(value = "accountId") String accountId) {
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(laterAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " LoginController GetMappingg(laterAccountPw) later : " + later + TeamColor.TEXT_RESET);
		
		if(later.equals("yes")) {
			accountService.modifyLastLoginDateByChangeAccountPwDate(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + " 비밀번호 변경 3개월 기간 연장 성공! " + later + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("later", "Success");
			return "redirect:/bakha/login";
		}
		
		// 연장 말고 비밀번호 변경경로 디버깅
		log.debug(TeamColor.PCW + " 비밀번호 변경 폼으로 이동! " + later + TeamColor.TEXT_RESET);
		return "redirect:/modifySearchAccountPw?accountId=" + accountId;
	}
	 
	// (학생, 강사, 행정) 멤버 비밀번호 변경 Form - 찾기를 통해 변경하는 경우
	@GetMapping("/modifySearchAccountPw")
	public String searchModifyAccountPw(Model model , @RequestParam(value = "accountId") String accountId) {
		
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
		
		int row = accountService.modifySearchMemberAccountPw(account);
		if(row == 1) {
			int addRow = accountService.addPwRecord(account);
			// 디버깅
			log.debug(TeamColor.PCW + " 패스워드기록 테이블 추가 addRow : " + addRow + TeamColor.TEXT_RESET);
			return "login/login";
		} else {
			// 디버깅
			log.debug(TeamColor.PCW + " 패스워드 변경 실패" + TeamColor.TEXT_RESET);
			return "login/modifySearchAccountPw";
		}
	}
	
	// index Form
	@GetMapping("/loginCheck/index")
	public String index(Model model, HttpSession session
			, @RequestParam(value = "year", defaultValue = "-1") int year
			, @RequestParam(value = "month", defaultValue = "-1") int month) {
		Account account = new Account();
		
		// sessionId & sessionLevel 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(/loginCheck/index) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		int accountLevel = (int)session.getAttribute("sessionLevel");
		// 디버깅
		log.debug(TeamColor.PCW + " LoginController GetMappingg(/loginCheck/index) accountLevel : " + accountLevel + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/index) year : " + year + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/index) month : " + month + TeamColor.TEXT_RESET);
		
		
		account.setAccountId(accountId);
		account.setAccountLevel(accountLevel);
		
		// MemberFile 멤버사진 받아오기
		Map<String,Object> memberMap = memberService.getMemberOne(account);
		MemberFile memberFile = (MemberFile) memberMap.get("memberFile");
		String memberFileName = memberFile.getMemberFileName();
		session.setAttribute("memberFileName", memberFileName);
		model.addAttribute("memberFile", memberFile);
		
		// 서비스 호출
		Map<String,Object> scheduleMap = scheduleService.getScheduleList(year, month, accountId, accountLevel);
		// 디버깅
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) scheduleMap : " + scheduleMap + TeamColor.TEXT_RESET);
		
		// model값 담아주기
		model.addAttribute("scheduleList", scheduleMap.get("scheduleList"));
		model.addAttribute("lectureSubjectList", scheduleMap.get("lectureSubjectList"));
		model.addAttribute("lectureName", scheduleMap.get("lectureName"));
		model.addAttribute("year", scheduleMap.get("year"));
		model.addAttribute("month", scheduleMap.get("month"));
		model.addAttribute("lastDay", scheduleMap.get("lastDay"));
		model.addAttribute("startBlank", scheduleMap.get("startBlank"));
		model.addAttribute("endBlank", scheduleMap.get("endBlank"));
		model.addAttribute("totalBlank", scheduleMap.get("totalBlank"));
		
		
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
