package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ExamService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
	@Autowired ExamService examService;
	/*
	 * [강사전용] 시험 메인페이지로 이동하는 메소드 
	 * 파라미터 : 사용자가 선택한 lectureName 
	 * 리턴값 : lecture에서 출제된 시험리스트
	 */
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
}
