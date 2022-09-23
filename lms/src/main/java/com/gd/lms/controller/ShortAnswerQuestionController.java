package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
