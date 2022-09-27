package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AttendanceController {
	
	// [강사전용] 강의중인 Class의 학생들 출석부 불러오기
	// 파라미터 : session
	// 리턴값 : attendanceForTeacher 페이지로 이동 /학생 출석부 리스트
	@GetMapping("/loginCheck/attendanceForTeacher")
	public String attendanceForTeacher(HttpSession session, Model model) {
		// 로그인한 아이디
		String accountId = (String) session.getAttribute("sessionId");
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		return "";
	}
}
