package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.AttendanceService;
import com.gd.lms.service.ExamService;
import com.gd.lms.service.LectureService;
import com.gd.lms.vo.Lecture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
	//ExamService 객체 주입
	@Autowired
	private ExamService examService;

	// LectureService 객체 주입
	@Autowired
	private LectureService lectureService;

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

	// [행정/총관리자] 강좌관리 페이지로 이동하는 메소드
	// 파라미터 : X
	// 리턴값 : 전체 강좌 목록 보여주기 
	@GetMapping("/loginCheck/lecture")
	public String getLecture(Model model) {
		log.debug(TeamColor.PSJ + "강좌관리 탭으로 이동" + TeamColor.TEXT_RESET);

		// 전체 강좌목록 service call
		List<Map<String, Object>> lectureList = lectureService.getLectureDetailList();
		// 디버깅
		log.debug(TeamColor.PSJ + lectureList + "<-- lectureList" + TeamColor.TEXT_RESET);

		// model로 값 전송
		model.addAttribute("lectureList", lectureList);

		return "lecture/lecture";
	}

	// [행정/총관리자] 강좌수정 페이지 폼
	// 파라미터 : lectureName
	// 리턴값 : 강좌수정 페이지 폼 
	@GetMapping("/loginCheck/lectureOne")
	public String getLectureOne(Model model, @RequestParam(value = "lectureName") String lectureName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// 강좌 상세정보 service call
		Map<String, Object> lectureOne = lectureService.getLectureOne(lectureName);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureOne + "<-- lectureOne" + TeamColor.TEXT_RESET);

		// model로 값 전송
		model.addAttribute("lectureOne", lectureOne);

		return "lecture/lectureOne";
	}

	// [행정/총관리자] 강좌 개설 폼
	// 파라미터 : accountId
	// 리턴값 : 강좌개설 페이지 폼 
	@GetMapping("/loginCheck/addLecture")
	public String addLecture(Model model) {
		Map<String, Object> infoMap = lectureService.getInfoForAddLecture();
		model.addAttribute("infoMap", infoMap);
		return "lecture/addLecture";
	}

	// [행정/총관리자] 강좌 개설 액션
	// 파라미터 : Lecture
	// 리턴값 : lecture.jsp
	@PostMapping("/loginCheck/addLecture")
	public String addLecture(RedirectAttributes redirectAttributes, Lecture paramLecture) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramLecture + "<-- paramLecture" + TeamColor.TEXT_RESET);
		// service call
		int row = lectureService.addLecture(paramLecture);
		// 결과 처리
		if(row != 0) {
			
		} else {
			
		}
		
		return "redirect:/loginCheck/lecture";
	}

	// [행정/총관리자] 강좌 수정 액션
	// 파라미터 : 
	// 리턴값 : 강좌수정 성공시 lecture.jsp /실패시 lectureOne.jsp
	@PostMapping("/loginCheck/modifyLecture")
	public String modifyLecture(RedirectAttributes redirectAttributes, Lecture paramLecture) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramLecture + "<-- paramLecture" + TeamColor.TEXT_RESET);

		// Service call
		int row = lectureService.modifyLecture(paramLecture);
		// 결과 처리
		if (row != 0) { // 수정에 성공했을 떄
			log.debug(TeamColor.PSJ + "modifyLecture 수정 성공" + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "수정에 성공하였습니다.");
		} else { // 수정에 실패했을 때
			log.debug(TeamColor.PSJ + "modifyLecture 수정 실패" + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "수정에 실패하였습니다.");
		}
		redirectAttributes.addAttribute("lectureName", paramLecture.getLectureName());
		return "redirect:/loginCheck/lectureOne";
	}
}
