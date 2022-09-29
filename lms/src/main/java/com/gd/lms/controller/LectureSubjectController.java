package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.vo.LectureSubject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureSubjectController {
	
	// LectureSubjectService 객체 주입
	@Autowired
	LectureSubjectService lectureSubjectService;
	
	/*
	 * 강사와 관련된 강의 리스트 정보 받아오기
	 * 파라미터 : 강사 아이디 accountId
	 * 리턴값 : 강사와 관련된 강의 정보 List<LectureSubject>
	 */
	@GetMapping("/loginCheck/lectureSubjectList")
	String lectureSubjectList(HttpSession session, Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportList Controller" + TeamColor.TEXT_RESET);

		// 세션아이디 받아오기
		String accountId = (String) session.getAttribute("sessionId");
		// 로그인한 Student의 아이디 확인 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// Service Call
		List<LectureSubject> lectureSubjectList = lectureSubjectService.lectureSubjectInfoByTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSY + lectureSubjectList + "<-- lectureSubjectList" + TeamColor.TEXT_RESET);
		
		// lectureSubjectList Model로 넘겨주기
		model.addAttribute("lectureSubjectList",lectureSubjectList);
		
		return "";
	} // end lectureSubjectList
}
