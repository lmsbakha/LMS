package com.gd.lms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MultiplechoiceExampleService;
import com.gd.lms.service.MultiplechoiceService;
import com.gd.lms.vo.Multiplechoice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MultichoiceController {
	// MultiplechoiceService 객체 주입
	@Autowired
	private MultiplechoiceService multiplechoiceService;

	// 객관식 문제 상세보기
	// 파라미터 : questionNo
	// 리턴값 : 객관식 문제와 보기 답안을 multiplechoiceOne에서 보여주기
	@GetMapping("/loginCheck/multiplechoiceOne")
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

		return "exam/multiplechoiceOne";
	}

	// 객관식 문제 수정하는 메소드
	// 파라미터 : questionNo,questionTitle,questionAnswer
	// 리턴값 : 수정된 question 데이터 받아서 multichiceOne 뷰로 이동
	@PostMapping("/loginCheck/modifyMultiplechoiceOne")
	public String modifyMultiplechoiceOne(RedirectAttributes redirectAttributes
			, @RequestParam(value = "questionNo") int questionNo
			, @RequestParam(value = "questionTitle") String questionTitle
			, @RequestParam(value = "questionAnswer") String questionAnswer) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionTitle + "<-- questionTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionAnswer + "<-- questionAnswer" + TeamColor.TEXT_RESET);

		// 전송받은 값들을 객체에 셋팅
		Multiplechoice paramMultiplechoice = new Multiplechoice();
		paramMultiplechoice.setQuestionNo(questionNo);
		paramMultiplechoice.setQuestionTitle(questionTitle);
		paramMultiplechoice.setQuestionAnswer(questionAnswer);
		
		// 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoice + "<-- paramMultiplechoice" + TeamColor.TEXT_RESET);

		//Serivce call
		int row = multiplechoiceService.modifyMultiplechoiceOne(paramMultiplechoice);
		if (row != 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		// getMapping이므로 addAttrubute로 값 전송 --> 새로고침도 똑같아야 한다
		redirectAttributes.addAttribute("questionNo", questionNo);
		
		return "redirect:/loginCheck/multiplechoiceOne";
	}

	// 객관식 문제 삭제하는 메소드
	// 파라미터 : questionNo
	// 리턴값 : questionBank 페이지로 이동/ alertMsg를 보낼 Red
	@GetMapping("/loginCheck/removeMultiplechoiceOne")
	public String removeMultiplechoiceOne(RedirectAttributes redirectAttributes, int questionNo) {
		// 파라미터 디버깅 
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// Service call
		int removeCk = multiplechoiceService.removeMultiplechoiceOne(questionNo);
		if (removeCk != 0) { // 삭제에 성공했다면
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else { // 삭제에 실패했다면
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		return "redirect:/loginCheck/questionBank";
	}

}
