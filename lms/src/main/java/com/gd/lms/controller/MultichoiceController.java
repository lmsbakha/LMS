package com.gd.lms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MultiplechoiceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MultichoiceController {
	@Autowired
	private MultiplechoiceService multiplechoiceService;

	// 객관식 문제 상세보기
	// 파라미터 : questionNo
	// 리턴값 : 객관식 문제와 보기 답안을 multiplechoiceOne에서 보여주기
	@GetMapping("/multiplechoiceOne")
	public String multiplechoiceOne(Model model, @RequestParam(value = "questionNo") int questionNo) {
		//파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// MultiplechoiceService에서 객관식 문제의 상세 정보 받아옴
		Map<String, Object> multiplechoiceOne = multiplechoiceService.getMultiplechoiceOne(questionNo);
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceOne + "<-- multiplechoiceOne" + TeamColor.TEXT_RESET);
		// 모델값에 넣어서 보내주기
		model.addAttribute("multiplechoiceQuestion", multiplechoiceOne.get("multiplechoiceQuestion"));
		model.addAttribute("multiplechoiceExample", multiplechoiceOne.get("multiplechoiceExample"));
		
		return "multiplechoiceOne";
	}

	// 객관식 문제 수정
	// 파라미터 : questionNo
	// 리턴값 : 수정된 question 데이터 받아서 뷰에서 보여주기

	// 객관식 문제 삭제
}
