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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Manager;
import com.gd.lms.vo.OutRecord;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.Teacher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	// MemberService 객체주입
	@Autowired
	private MemberService memberService;
	
	// AccountService 객체주입
	@Autowired
	private AccountService accountService;
	
	
	// 학생, 강사, 행정 목록 Form
	@GetMapping("/loginCheck/memberList")
	public String getMemberList(Model model, @RequestParam(value = "memberCheck") String memberCheck) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/studentList)" + TeamColor.TEXT_RESET);
		
		model.addAttribute("memberCheck", memberCheck);
		
		// 학생, 강사, 행정 분기
		if(memberCheck.equals("student")) {
			List<Student> studentList = memberService.getStudentList();
			// 디버깅
			log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberList) studentList :" + studentList + TeamColor.TEXT_RESET);
			model.addAttribute("studentList", studentList);
		} else if(memberCheck.equals("teacher")) {
			List<Teacher> teacherList = memberService.getTeacherList();
			// 디버깅
			log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberList) teacherList :" + teacherList + TeamColor.TEXT_RESET);
			model.addAttribute("teacherList", teacherList);
		} else if(memberCheck.equals("manager")) {
			List<Manager> managerList = memberService.getManagerList();
			// 디버깅
			log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberList) managerList :" + managerList + TeamColor.TEXT_RESET);
			model.addAttribute("managerList", managerList);
		}
		
		return "member/memberList";
	}
	
	// 학생, 강사, 행정 각accountId의 상세보기 Form
	@GetMapping("/loginCheck/memberOne")
	public String getMemberOne(Model model, @RequestParam(value = "accountId") String accountId) {
		
		//디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberOne) accountId :" + accountId + TeamColor.TEXT_RESET);
		
		// accountId 해당 level값 받아오기
		int accountLevel = accountService.getMemberLevelByAccountId(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberOne) accountLevel :" + accountLevel + TeamColor.TEXT_RESET);
		
		// AccountVo에 id와 level 담아주기
		Account account = new Account();
		account.setAccountId(accountId);
		account.setAccountLevel(accountLevel);
		
		// accountId에 대한 사진 및 정보 받아오기
		Map<String,Object> memberMap = new HashMap<>();
		memberMap = memberService.getMemberOne(account);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/memberOne) memberMap :" + memberMap + TeamColor.TEXT_RESET);
		
		// model -> jsp
		model.addAttribute("accountLevel", accountLevel);
		model.addAttribute("member", memberMap.get("member"));
		model.addAttribute("memberFile", memberMap.get("memberFile"));
		
		return "member/memberOne";
	}
	
	// 비밀번호 & 정보 & 탈퇴 를 위한 비밀번호 확인하기 Form
	@GetMapping("/loginCheck/checkAccountPw")
	public String checkAccountPw(Model model, HttpSession session, @RequestParam(value = "path") String path) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/checkAccountPw)" + TeamColor.TEXT_RESET);
		
		// 세션을 통해 accountId 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/checkAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		// model에 account 값 담아주기
		model.addAttribute("accountId", accountId);
		model.addAttribute("path", path);
		if("modifyAccountPw".equals(path) || "modifyMember".equals(path) || "removeMember".equals(path) ) {
			return "member/checkAccountPw";
		} else {
			return "member/checkAccountPw";
		}
	}
	
	// 비밀번호 & 정보 & 탈퇴 를 위한 비밀번호 확인하기 Action
	@PostMapping("/loginCheck/checkAccountPw")
	public String checkAccountPw(Model model, HttpSession session, Account account, OutRecord outRecord
								, @RequestParam(value = "accountId") String accountId
								, @RequestParam(value = "accountPw") String accountPw
								, @RequestParam(value = "path") String path) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(/loginCheck/checkAccountPw accountId : )" + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "LoginController PostMapping(/loginCheck/checkAccountPw accountPw : )" + accountPw + TeamColor.TEXT_RESET);
		
		// account에 담기
		account.setAccountId(accountId);
		account.setAccountPw(accountPw);
		
		// 비밀번호가 맞는지 확인하기
		int checkRow = memberService.getAccountPwCheck(account);
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController PostMapping(/loginCheck/checkAccountPw) checkRow : " + checkRow + TeamColor.TEXT_RESET);
		
		// model값에 담아주기
		model.addAttribute("accountId", accountId);
		model.addAttribute("path", path);
		
		// path에 따라서 분기 나누기
		if("modifyAccountPw".equals(path)) {
			if(checkRow == 1 ) {
				// 디버깅
				log.debug(TeamColor.PCW + "본인 확인 성공! 비밀번호 수정 폼으로 이동합니다." + TeamColor.TEXT_RESET);
				return "redirect:/loginCheck/modifyAccountPw";
			}else {
				// 디버깅
				log.debug(TeamColor.PCW + "본인 확인 실패! 본인 확인 폼으로 이동합니다." + TeamColor.TEXT_RESET);
				model.addAttribute("alertMsg", "Fail");
				return "/member/checkAccountPw";
			}
		} else if("modifyMember".equals(path)) {
			if(checkRow == 1) {
				// 디버깅
				log.debug(TeamColor.PCW + "본인 확인 성공! 개인정보 수정 폼으로 이동합니다." + TeamColor.TEXT_RESET);
				return "redirect:/loginCheck/modifyMember";
			}else {
				// 디버깅
				log.debug(TeamColor.PCW + "본인 확인 실패! 본인 확인 폼으로 이동합니다." + TeamColor.TEXT_RESET);
				model.addAttribute("alertMsg", "Fail");
				return "/member/checkAccountPw";
			}
		} else{
			if(checkRow == 0) {
				// 디버깅
				log.debug(TeamColor.PCW + "본인 확인 실패! 본인 확인 폼으로 이동합니다." + TeamColor.TEXT_RESET);
				model.addAttribute("alertMsg", "Fail");
				return "/member/checkAccountPw";
			}else if("removeMember".equals(path)){
				// 세션에 저장된 accountLevel값 받아오기
				int accountLevel = (int)session.getAttribute("sessionLevel");
				// 디버깅
				log.debug(TeamColor.PCW + "session에 저장된 레벨값 accountLevel : " + accountLevel + TeamColor.TEXT_RESET);
				if(checkRow == 1) {
					if(accountLevel == 1) {
						memberService.removeStudent(account, outRecord);  // 학생 탈퇴
					} else if(accountLevel == 2) {
						memberService.removeTeacher(account, outRecord);  // 강사 탈퇴
					} else if(accountLevel == 3) {
						memberService.removeManager(account, outRecord);  // 행정 탈퇴
					}
						return "redirect:/loginCheck/logout";
				} else {
					return "/member/checkAccountPw";
				}
			}
		}
		return "/member/checkAccountPw";
	}
	
	// 멤버 비밀번호 수정 Form
	@GetMapping("/loginCheck/modifyAccountPw")
	public String modifyAccountPw(Model model, HttpSession session) {
		
		// 세션을 통해 accountId 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController GetMappingg(modifyAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		model.addAttribute("accountId", accountId);
		
		return "member/modifyAccountPw";
	}
	
	// 멤버 비밀번호 수정 Action
	@PostMapping("/loginCheck/modifyAccountPw")
	public String modifyAccountPw(Model model
								, @RequestParam(value = "accountId") String accountId
								, @RequestParam(value = "accountPw") String accountPw) {
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyAccountPw) accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyAccountPw) accountPw : " + accountPw + TeamColor.TEXT_RESET);
		
		model.addAttribute("accountId", accountId);
		
		// Account 객체 생성
		Account account = new Account();
		// account에 담아주기
		account.setAccountId(accountId);
		account.setAccountPw(accountPw);
		
		
		int row = memberService.modifyAccountPw(account);
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyAccountPw) row : " + accountPw + TeamColor.TEXT_RESET);

		if(row == 1) {
			return "redirect:/loginCheck/logout";
		} else {
			// 디버깅
			log.debug(TeamColor.PCW + " 비밀번호 변경 실패! 비밀번호 변경 폼으로 이동합니다. "+ TeamColor.TEXT_RESET);
			return "/member/modifyAccountPw";
		}
	}
	
	// 학생, 강사, 행정 정보 수정하기 Form
	@GetMapping("/loginCheck/modifyMember")
	public String modifyMember(Model model, HttpSession session) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) "+ TeamColor.TEXT_RESET);
		
		// 세션을 통해 accountId 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		// accountId 해당 level값 받아오기
		int accountLevel = accountService.getMemberLevelByAccountId(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) accountLevel : "+ accountLevel + TeamColor.TEXT_RESET);
		
		// Account 객체 생성
		Account account = new Account();
		// account에 담아주기
		account.setAccountId(accountId);
		account.setAccountLevel(accountLevel);
		
		Map<String,Object> memberMap = new HashMap<>();
		// member 상세보기
		memberMap = memberService.getMemberOne(account);
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) memberMap : "+ memberMap + TeamColor.TEXT_RESET);
		
		// model에 담아주기
		model.addAttribute("member", memberMap.get("member"));
		model.addAttribute("memberFile", memberMap.get("memberFile"));
		
		return "member/modifyMember";
	}
	
	// 학생, 강사, 행정 정보 수정하기 Action
	@PostMapping("/loginCheck/modifyMember")
	public String modifyMember(HttpSession session, RedirectAttributes redirectAttributes, Student student, Teacher teacher, Manager manager) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController PostMapping(/loginCheck/modifyMember) student : "+ student + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "  MemberController PostMapping(/loginCheck/modifyMember) teacher : "+ teacher + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "  MemberController PostMapping(/loginCheck/modifyMember) manager : "+ manager + TeamColor.TEXT_RESET);
		
		// 세션을 통해 accountId 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		// accountId 해당 level값 받아오기
		int accountLevel = accountService.getMemberLevelByAccountId(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "  MemberController GetMapping(/loginCheck/modifyMember) accountLevel : "+ accountLevel + TeamColor.TEXT_RESET);
		
		if(accountLevel == 1) {
			// student에 accountId 담아주기
			student.setAccountId(accountId);
			int row = memberService.modifyStudent(student);
			if(row == 1) {
				// 디버깅
				log.debug(TeamColor.PCW + " student row :  "+ row + "  정보 수정 성공! " + TeamColor.TEXT_RESET);
				return "redirect:/loginCheck/memberOne?accountId="+ accountId;
			} else {
				// 디버깅
				log.debug(TeamColor.PCW + " student row :  "+ row + "  정보 수정 실패! " + TeamColor.TEXT_RESET);
				redirectAttributes.addFlashAttribute("alertMsg", "Fail");
				return "redirect:/loginCheck/modifyMember?accountId=" + accountId;
			}
		} else if(accountLevel == 2) {
			// teacher에 accountId 담아주기
			teacher.setAccountId(accountId);
			int row = memberService.modifyTeacher(teacher);
			if(row == 1) {
				// 디버깅
				log.debug(TeamColor.PCW + " teacher row :  "+ row + "  정보 수정 성공! " + TeamColor.TEXT_RESET);
				return "redirect:/loginCheck/memberOne?accountId=" + accountId;
			} else {
				// 디버깅
				log.debug(TeamColor.PCW + " teacher row :  "+ row + "  정보 수정 실패! " + TeamColor.TEXT_RESET);
				redirectAttributes.addFlashAttribute("alertMsg", "Fail");
				return "redirect:/loginCheck/modifyMember?accountId=" + accountId;
			}
		} else if(accountLevel == 3) {
			// manager에 accountId 담아주기
			manager.setAccountId(accountId);
			int row = memberService.modifyManager(manager);
			if(row == 1) {
				// 디버깅
				log.debug(TeamColor.PCW + " manager row :  "+ row + "  정보 수정 성공! " + TeamColor.TEXT_RESET);
				return "redirect:/loginCheck/memberOne?accountId=" + accountId;
			} else {
				// 디버깅
				log.debug(TeamColor.PCW + " manager row :  "+ row + "  정보 수정 실패! " + TeamColor.TEXT_RESET);
				redirectAttributes.addFlashAttribute("alertMsg", "Fail");
				return "redirect:/loginCheck/modifyMember?accountId=" + accountId;
			}
		} else {
			return "redirect:/loginCheck/modifyMember?accountId=" + accountId;
		}
	}
	
	// 멤버 프로필 memberFile 수정 Form
	@GetMapping("/loginCheck/modifyMemberFile")
	public String modifyMemberFile(Model model, @RequestParam(value = "memberFileName") String memberFileName) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "LoginController GetMapping(/loginCheck/modifyMemberFile) memberFileName :" + memberFileName + TeamColor.TEXT_RESET);
		
		// model에 담아주기
		model.addAttribute("memberFileName", memberFileName);
		
		return "/member/modifyMemberFile";
	}
	
	// 멤버 프로필 memberFile 수정 Action
	@PostMapping("/loginCheck/modifyMemberFile")
	public String modifyMemberFile(HttpSession session, HttpServletRequest request
								, RedirectAttributes redirectAttributes
								, @RequestParam(value = "prMemberFileName") String prMemberFileName
								, @RequestPart(value = "newMemberFile") MultipartFile newMemberFile) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyMemberFile) prMemberFile :" + prMemberFileName + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyMemberFile) newMemberFile :" + newMemberFile + TeamColor.TEXT_RESET);
		
		// 세션을 통해 accountId 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController GetMapping(/loginCheck/modifyMember) accountId : " + accountId + TeamColor.TEXT_RESET);
		
		// 파일 경로 지정
		String path = request.getServletContext().getRealPath("/file/memberPhoto/");
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyMember) path : " + path  + TeamColor.TEXT_RESET);
		
		// 폴더 및 DB memberFile 삭제
		int row = memberService.modifyMemberFile(accountId, path, prMemberFileName, newMemberFile);
		// 디버깅
		log.debug(TeamColor.PCW + " MemberController PostMapping(/loginCheck/modifyMember) row : " + row  + TeamColor.TEXT_RESET);
		
		// 수정 성공 / 실패 분기
		if(row == 1) {
			return "redirect:/loginCheck/memberOne?accountId=" + accountId;
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
			return "redirect:/loginCheck/modifyMemberFile?accountId=" + accountId;
		}
	
	}
	
}
