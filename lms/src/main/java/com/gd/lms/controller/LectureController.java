package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AttendanceService;
import com.gd.lms.service.ExamService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
	//ExamService 객체 주입
	@Autowired
	private ExamService examService;

	// AttendanceService 객체 주입
	@Autowired
	private AttendanceService attendanceService;
	
	
	// [강사전용] 시험 메인페이지로 이동하는 메소드 
	// 파라미터 : 사용자가 선택한 lectureName 
	// 리턴값 : lecture에서 출제된 시험리스트
	@PostMapping("/loginCheck/lectureListByTeacher")
	public String lectureListByTeacher(RedirectAttributes redirectAttributes, @RequestParam(value = "lectureName") String lectureName) {
		// 디버깅
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// ExamList 가져오기
		List<Map<String, Object>> examListByLecture = examService.getExamListByLecture(lectureName);
		// model 단에 값 저장해서 보내줌
		redirectAttributes.addFlashAttribute("examListByLecture", examListByLecture);

		return "redirect:/loginCheck/exam";
	}

	// [강사전용] 출석 메인페이지로 이동하는 메소드
	// 파라미터 : 사용자가 선택한 lectureName, 강사 accountId 
	// 리턴값 : 선택된 강좌의 학생출석부를 보여주는 출결관리 페이지
	@PostMapping("/loginCheck/lectureListByTeacherForAttendance")
	public String lectureListByTeacherForAttendance(RedirectAttributes redirectAttributes,HttpSession session, @RequestParam(value = "lectureName") String lectureName) {
		// 파라미터 디버깅
		String accountId = (String) session.getAttribute("sessionId");
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);
		
		// 출석부 리스트 service call
		List<Map<String, Object>> attendanceList = attendanceService.getAttendanceListByTeacher(accountId, lectureName);
		// redirectAttributes을 통해서 값 전달
		redirectAttributes.addFlashAttribute("attendanceList", attendanceList);
		
		return "redirect:/loginCheck/attendanceForTeacher";
	}

	// [행정/총관리자] 출석 메인페이지로 이동하는 메소드
	// 파라미터 : 사용자가 선택한 lectureName
	// 리턴값 : 강좌의 학생 출석부를 보여주는 출결관리 페이지
	@PostMapping("/loginCheck/lectureListByManagerForAttendance")
	public String lectureListByManagerForAttendance(RedirectAttributes redirectAttributes,@RequestParam(value = "lectureName") String lectureName) {
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);
		
		// 출석부 리스트 service call
		List<Map<String, Object>> attendanceList = attendanceService.getAttendanceListByManager(lectureName);
		// redirectAttributes을 통해서 값 전달
		redirectAttributes.addFlashAttribute("attendanceList", attendanceList);
		
		return "redirect:/loginCheck/attendanceForManager";
	}
}
