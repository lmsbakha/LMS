package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AccountService;
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Manager;
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
	
	
	// 학생 목록
	@GetMapping("/loginCheck/memberList")
	public String getMemberList(Model model, @RequestParam(value="memberCheck") String memberCheck) {
		
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
}
