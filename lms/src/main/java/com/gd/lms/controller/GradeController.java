package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.GradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GradeController {
	@Autowired
	GradeService gradeService;
	
	// 성적관리 페이지로 이동하는 메소드
	@GetMapping("/loginCheck/grade")
	public String getGrade() {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getGrade Controller" + TeamColor.TEXT_RESET);
		return "grade/grade";
	}
}
