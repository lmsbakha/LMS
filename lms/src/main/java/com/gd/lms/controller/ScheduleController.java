package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ScheduleController {
	@Autowired private LectureService lectureService;
	
	@GetMapping("/loginCheck/scheduleList")
	public String getScheduleList() {
		
		return "/schedule/scheduleList";
	}
}
