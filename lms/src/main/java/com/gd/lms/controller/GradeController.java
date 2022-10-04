package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.GradeService;
import com.gd.lms.service.LectureService;
import com.gd.lms.vo.Lecture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GradeController {
	// GradeService 객체 주입
	@Autowired
	GradeService gradeService;

	// LectureService 객체 주입
	@Autowired
	LectureService lectureService;

	// 성적관리 페이지로 이동하는 메소드
	@GetMapping("/loginCheck/grade")
	public String getGrade() {
		log.debug(TeamColor.PSJ + "성적관리 탭으로 이동" + TeamColor.TEXT_RESET);
		return "grade/grade";
	}

	/*
	 * 과제 성적관리 페이지로 이동하는 메소드
	 * 파라미터 : lectureListByAdmin을 담을 Model
	 * 리턴값 : lectureListByAdmin
	 * reportGrade.jsp
	 */
	@GetMapping("/loginCheck/reportGrade")
	public String grade(Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getGrade Controller" + TeamColor.TEXT_RESET);

		// LectureService에서 lectureListByAdmin 가져오기
		List<Lecture> lectureListByAdmin = lectureService.getLectureListByAccoutId();
		// 디버깅
		log.debug(TeamColor.PSY + lectureListByAdmin + "<--lectureListByAdmin" + TeamColor.TEXT_RESET);

		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByAdmin", lectureListByAdmin);

		return "grade/reportGrade";
	} // end getGrade @GetMapping

	@PostMapping("/loginCheck/reportGrade")
	public String grade(RedirectAttributes redirectAttributes, @RequestParam("lectureName") String lectureName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@lectureSubjectList Controller" + TeamColor.TEXT_RESET);
		// 파라미터값 디버깅
		log.debug(TeamColor.PSY + lectureName + "<--lectureName" + TeamColor.TEXT_RESET);

		// gradeList로 리다이랙트
		return "redirect:/loginCheck/grade";
	} // end gradeList @PostMapping
}
