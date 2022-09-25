package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ShortanswerQuestionService;
import com.gd.lms.vo.ShortAnswerQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ShortAnswerQuestionController {

	@Autowired
	private ShortanswerQuestionService shortanswerQuestionService;

	// 단답형 문제 추가하는 메소드
	// 파라미터 : ShortAnswerQuestion
	// 리턴값 : alertMsg, questionBank 폼으로 이동
	@PostMapping("/loginCheck/addShortAnswerQuestion")
	public String addShortAnswerQuestion(RedirectAttributes redirectAttributes, @RequestParam(value = "subjectName") String subjectName, @RequestParam(value = "questionTitle") String questionTitle,
			@RequestParam(value = "questionAnswer") String questionAnswer) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionTitle + "<--questionTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionAnswer + "<--questionAnswer" + TeamColor.TEXT_RESET);

		// 요청받은 값을 ShortAnswerQuestion 객체에 셋팅
		ShortAnswerQuestion paramShortAnswerQuestion = new ShortAnswerQuestion();
		paramShortAnswerQuestion.setSubjectName(subjectName);
		paramShortAnswerQuestion.setQuestionTitle(questionTitle);
		paramShortAnswerQuestion.setQuestionAnswer(questionAnswer);
		// 디버깅
		log.debug(TeamColor.PSJ + paramShortAnswerQuestion + "<--paramShortAnswerQuestion" + TeamColor.TEXT_RESET);

		//Service call
		int row = shortanswerQuestionService.addShortAnswerQuestionOne(paramShortAnswerQuestion);
		if (row != 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		return "redirect:/loginCheck/addQuestionInBank";
	}

	// 단답형 문제 삭제하는 메소드
	// 파라미터 : questionNo
	// 리턴값 : questionBank 페이지로 이동/ alertMsg를 보낼 RedirectAttributes
	@GetMapping("/loginCheck/removeShortAnswerQuestion")
	public String removeShortAnswerQuestion(RedirectAttributes redirectAttributes, @RequestParam(value = "questionNo") int questionNo, @RequestParam(value = "page") String page) {
		// 파라미터 디버깅 
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + page + "<-- page" + TeamColor.TEXT_RESET);

		// Service call
		int removeCk = shortanswerQuestionService.removeShortAnswerQuestionOne(questionNo);
		// 결과 디버깅
		if (removeCk == 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		} else if (removeCk == 500) {
			redirectAttributes.addFlashAttribute("alertMsg", "Error");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		}

		if (page.equals("InOnePage") && (removeCk == 0 || removeCk == 500)) { // shortAnswerQuestionOne.jsp에서 실행했을 때 삭제에 실패했거나 FK로 인해서 오류가 발생했을 경우에는
			redirectAttributes.addAttribute("questionNo", questionNo);
			return "redirect:/loginCheck/shortAnswerQuestionOne"; // 상세페이지로 이동
		}
		// 상세페이지에서 삭제에 성공했을 때 && questionBank.jsp에서 삭제했을 때 성공했을 경우
		return "redirect:/loginCheck/questionBank";
	}

	// 단답형 상세페이지 폼
	// 파라미터 : questionNo
	// 리턴값 : questionNo의 단답형 문제 상세내용
	@GetMapping("/loginCheck/shortAnswerQuestionOne")
	public String shortAnswerQuestionOne(Model model, @RequestParam(value = "questionNo") int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// Service call
		ShortAnswerQuestion shortAnswerQuestion = shortanswerQuestionService.getShortAnswerQuestion(questionNo);
		// 디버깅
		log.debug(TeamColor.PSJ + shortAnswerQuestion + "<-- shortAnswerQuestion" + TeamColor.TEXT_RESET);

		//model에 요청받아온 문제정보를 보내줌
		model.addAttribute("shortAnswerQuestion", shortAnswerQuestion);
		return "exam/shortAnswerQuestionOne";
	}
	
	// 단답형 문제 수정하는 액션
	@PostMapping("/loginCheck/modifyShortAnswerQuestion")
	public String modifyShortAnswerQuestion(RedirectAttributes redirectAttributes
			, @RequestParam(value = "questionNo") int questionNo
			, @RequestParam(value = "questionTitle") String questionTitle
			, @RequestParam(value = "questionAnswer") String questionAnswer) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionTitle + "<-- questionTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionAnswer + "<-- questionAnswer" + TeamColor.TEXT_RESET);

		// 전송받은 값들을 객체에 셋팅
		ShortAnswerQuestion paramShortAnswerQuestion = new ShortAnswerQuestion();
		paramShortAnswerQuestion.setQuestionNo(questionNo);
		paramShortAnswerQuestion.setQuestionTitle(questionTitle);
		paramShortAnswerQuestion.setQuestionAnswer(questionAnswer);

		// 디버깅
		log.debug(TeamColor.PSJ + paramShortAnswerQuestion + "<-- paramShortAnswerQuestion" + TeamColor.TEXT_RESET);

		//Serivce call
		int row = shortanswerQuestionService.modifyShortAnswerQuestionOne(paramShortAnswerQuestion);
		if (row != 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		// getMapping이므로 addAttrubute로 값 전송 --> 새로고침도 똑같아야 한다
		redirectAttributes.addAttribute("questionNo", questionNo);

		return "redirect:/loginCheck/shortAnswerQuestionOne";
	}
}
