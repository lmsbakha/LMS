package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.MultiplechoiceExampleService;
import com.gd.lms.service.MultiplechoiceService;
import com.gd.lms.service.ShortanswerQuestionService;

/*
 강사가 시험문제 출제할 때 사용하는 Controller
 객관식/주관식 형식으로 출제가 가능하다
 */

@Controller
public class ExamController {
	// MultiplechoiceService 객체 주입
	@Autowired
	private MultiplechoiceService multiplechoiceService;
	// MultiplechoiceExampleService 객체 주입
	@Autowired
	private MultiplechoiceExampleService multiplechoiceExampleService;
	// ShortanswerQuestionService 객체 주입
	@Autowired
	private ShortanswerQuestionService shortanswerQuestionService;
	
	// addExam 폼
	// 파라미터 : X
	// 리턴값: 시험문제를 출제하기 위한 form인 addExam.jsp로 이동 
	@GetMapping("/addExam")
	String addExam() {
		return "addExam";
	}
}
