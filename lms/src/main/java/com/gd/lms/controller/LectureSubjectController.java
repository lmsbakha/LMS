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

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.LectureService;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.LectureSubject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureSubjectController {

	// LectureService 객체 주입
	@Autowired
	LectureService lectureService;

}
