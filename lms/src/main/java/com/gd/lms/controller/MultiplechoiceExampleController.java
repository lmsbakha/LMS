package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MultiplechoiceExampleService;
import com.gd.lms.vo.MultiplechoiceExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MultiplechoiceExampleController {
	@Autowired
	private MultiplechoiceExampleService multiplechoiceExampleService;

	// 해당 문제의 보기 지문 수정폼을 보여주는 메소드
	// 파라미터 : questionNo
	// 리턴 값 : 지문 리스트 상세보기 보여주기 
	@GetMapping("/loginCheck/modifyMultiplechoiceExample")
	public String modifyMultiplechoiceExample(Model model
			, RedirectAttributes redirectAttributes
			, @RequestParam(value = "questionNo") int questionNo
			, @RequestParam(value = "alertMsg", required = false) String alertMsg) {
		// 현재 위치 디버깅
		log.debug(TeamColor.PSJ + "@modifyMultiplechoiceExample" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);
		//Service에서 리스트 값 받아오기
		List<MultiplechoiceExample> MultiplechoiceListByQuestionNo = multiplechoiceExampleService.getMultiplechoiceExampleListByQuestionNo(questionNo);
		//디버깅
		log.debug(TeamColor.PSJ + MultiplechoiceListByQuestionNo + "<-- MultiplechoiceListByQuestionNo" + TeamColor.TEXT_RESET);
		
		model.addAttribute("MultiplechoiceListByQuestionNo", MultiplechoiceListByQuestionNo);
		if(alertMsg != null && !(alertMsg.equals("null")) && alertMsg != ""){	
			log.debug(TeamColor.PSJ + alertMsg + "<-- alertMsg" + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", alertMsg);
		}
		return "exam/modifyMultiplechoiceExample";
	}

	// 지문 수정하는 메소드
	// 파라미터 : questionNo, multiplechoice_example_id, multiplechoice_example_content
	// 리턴값 : modifyMultiplechoiceExample. jsp
	@PostMapping("/loginCheck/modifyMultiplechoiceExample")
	public String modifyMultiplechoiceExample(RedirectAttributes redirectAttributes
			, @RequestParam(value = "questionNo") int questionNo
			, @RequestParam(value = "multiplechoiceExampleId") String multiplechoiceExampleId
			, @RequestParam(value = "multiplechoiceExampleContent") String multiplechoiceExampleContent) {
		// 파라미터 MultiplechoiceExample에 셋팅
		MultiplechoiceExample paramMultiplechoiceExample = new MultiplechoiceExample();
		paramMultiplechoiceExample.setQuestionNo(questionNo);
		paramMultiplechoiceExample.setMultiplechoiceExampleId(multiplechoiceExampleId);
		paramMultiplechoiceExample.setMultiplechoiceExampleContent(multiplechoiceExampleContent);
		// 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoiceExample + "<-- paramMultiplechoiceExample" + TeamColor.TEXT_RESET);

		// Service call
		int row = multiplechoiceExampleService.modifyMultiplechoiceExample(paramMultiplechoiceExample);

		if (row != 0) {
			// 디버깅
			log.debug(TeamColor.PSJ + "[Success]지문 수정 성공" + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			// 디버깅
			log.debug(TeamColor.PSJ + "[Fail]지문 수정 실패"  + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Fail" );
		}
		redirectAttributes.addAttribute("questionNo", questionNo);
		return "redirect:/loginCheck/modifyMultiplechoiceExample";
	}
}
