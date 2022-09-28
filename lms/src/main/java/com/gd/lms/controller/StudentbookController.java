package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.LectureService;
import com.gd.lms.vo.Lecture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentbookController {
	// LectureService 객체 주입
	@Autowired
	private LectureService lectureService;

	// [강사전용] 강의중인 Class의 학생들 출석부 불러오기
	// 파라미터 : sessionId
	// 리턴값 : studentbookForTeacher 페이지로 이동 / lectureListByTeacher
	@GetMapping("/loginCheck/studentbookForTeacher")
	public String studentbookForTeacher(HttpSession session, Model model) {
		// 로그인한 아이디
		String accountId = (String) session.getAttribute("sessionId");
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		//LectureService에서 lectureList가져오기
		List<Lecture> lectureListByTeacher = lectureService.getLectureListByAccoutId(accountId);
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByTeacher", lectureListByTeacher);

		return "studentbook/studentbookForTeacher"; //포워딩으로 전송
	}

	// [행정/총관리자] 강의중인 Class의 학생들 출석부 불러오기
	// 파라미터 : X
	// 리턴값 : studentbookForManager 페이지로 이동 / lectureListByManager
	@GetMapping("/loginCheck/studentbookForManager")
	public String studentbookForManager(Model model) {
		//LectureService에서 lectureList가져오기
		List<Lecture> lectureListByManager = lectureService.getLectureListByAccoutId();
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByManager", lectureListByManager);

		return "studentbook/studentbookForManager"; //포워딩으로 전송
	}
}
