package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gd.lms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
	//LectureService 객체 주입
	@Autowired
	private LectureService lectureService;
	
	/*
	 * 강사가 담당한 역대 lecture List 가져오는 메소드
	 * 파라미터 : sessionId
	 * 리턴값 : List<Lecture>
	 * */
	String getLectureListByTeacherName(HttpSession session) {
		session.getAttribute("sessionId");
		return "exam";
	}
}
