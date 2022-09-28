package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AttendanceController {
	@GetMapping("/loginCheck/attendanceForTeacher")
	public String attendanceForTeacher() {
		
		return "attendance/attendanceForTeacher";
	}
}
