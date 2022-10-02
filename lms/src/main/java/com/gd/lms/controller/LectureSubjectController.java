package com.gd.lms.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureSubjectController {
	// LectureService 객체 주입
	@Autowired
	LectureService lectureService;
}
