package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GradeController {
	// 성적관리 페이지로 이동하는 메소드
	@GetMapping("/loginCheck/grade")
	public String getGrade() {
		log.debug(TeamColor.PSJ + "성적관리 탭으로 이동" +TeamColor.TEXT_RESET);
		return "grade/grade";
	}
}
