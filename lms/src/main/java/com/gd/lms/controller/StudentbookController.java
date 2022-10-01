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

		// LectureService에서 lectureList가져오기
		List<Lecture> lectureListByTeacher = lectureService.getLectureListByAccoutId(accountId);
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByTeacher", lectureListByTeacher);

		return "studentbook/studentbookForTeacher"; // 포워딩으로 전송
	}

	// [강사전용] 학생관리 메인페이지로 이동하는 메소드
	// 파라미터 : 사용자가 선택한 lectureName, 강사 accountId
	// 리턴값 : 선택된 강좌의 학생 출석부를 보여주는 학생관리 페이지
	@PostMapping("/loginCheck/lectureListByTeacherForAttendance")
	public String lectureListByTeacherForAttendance(RedirectAttributes redirectAttributes, HttpSession session,
			@RequestParam(value = "lectureName") String lectureName) {
		// 파라미터 디버깅
		String accountId = (String) session.getAttribute("sessionId");
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// 출석부 리스트 service call
		List<Map<String, Object>> attendanceList = lectureService.getStudentBookListByTeacher(accountId, lectureName);
		// redirectAttributes을 통해서 값 전달
		redirectAttributes.addFlashAttribute("attendanceList", attendanceList);

		return "redirect:/loginCheck/studentbookForTeacher";
	}

	// [행정/총관리자] 강의중인 Class의 학생들 출석부 불러오기
	// 파라미터 : X
	// 리턴값 : studentbookForManager 페이지로 이동 / lectureListByManager
	@GetMapping("/loginCheck/studentbookForManager")
	public String studentbookForManager(Model model) {
		// LectureService에서 lectureList가져오기
		List<Lecture> lectureListByManager = lectureService.getLectureListByAccoutId();
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByManager", lectureListByManager);

		return "studentbook/studentbookForManager"; // 포워딩으로 전송
	}

	// [행정/총관리자] 학생관리 메인페이지로 이동하는 메소드
	// 파라미터 : 사용자가 선택한 lectureName
	// 리턴값 : 강좌의 학생 출석부를 보여주는 학생관리 페이지
	@PostMapping("/loginCheck/lectureListByManagerForAttendance")
	public String lectureListByManagerForAttendance(RedirectAttributes redirectAttributes,
			@RequestParam(value = "lectureName") String lectureName) {
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// 출석부 리스트 service call
		List<Map<String, Object>> attendanceList = lectureService.getStudentBookListByManager(lectureName);
		// redirectAttributes을 통해서 값 전달
		redirectAttributes.addFlashAttribute("attendanceList", attendanceList);

		return "redirect:/loginCheck/studentbookForManager";
	}
}
