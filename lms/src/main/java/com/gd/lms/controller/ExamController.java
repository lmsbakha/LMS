package com.gd.lms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import com.gd.lms.service.MultiplechoiceExampleService;
import com.gd.lms.service.MultiplechoiceService;
import com.gd.lms.service.ShortanswerQuestionService;
import com.gd.lms.service.SubjectService;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

/*
 강사가 시험문제 출제할 때 사용하는 Controller
 객관식/주관식 형식으로 출제가 가능하다
 */
@Slf4j
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

	// LectureService 객체 주입
	@Autowired
	private LectureService lectureService;

	// SubjectService 객체 주입
	@Autowired
	private SubjectService subjectService;

	// [강사전용] 문제은행 페이지를 보여주는 메소드
	// 파라미터 : 객관식 문제/단답형 문제를 담은 List를 view로 전송할 Model, 검색어 subjectName
	// 리턴값: 객관식,단답형 문제 리스트를 보여줄 문제 은행 view --> questionBank.jsp로 이동
	@GetMapping("/questionBank")
	String examList(Model model, @RequestParam(value = "subjectName", required = false) String subjectName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);
		// 단답형 문제와 객관식 문제들이 들어 있는 문제 리스트 객체 생성
		List<Map<String, Object>> examList = new ArrayList<>();
		// 객관식 문제 리스트 가져오기
		List<Map<String, Object>> multichoiceList = multiplechoiceService.getMultipleChoiceList(subjectName);
		examList.addAll(multichoiceList);
		// 단답형 문제 리스트를 가져오기
		log.debug(TeamColor.PSJ + examList + "<-- examList" + TeamColor.TEXT_RESET);
		// 모델 단으로 전송하기
		model.addAttribute("examList", examList);
		return "questionBank";
	}

	// [강사전용] 시험을 출제하는 페이지를 보여주는 메소드
	// 파라미터 : List<Map<String, Object>를 담아둘 Model
	// 리턴값: 시험문제를 출제하기 위한 form인 addExam.jsp로 이동
	@GetMapping("/addExam")
	String exam(HttpSession session, Model model) {
		String accountId= (String) session.getAttribute("sessionId");
		// 로그인한 강사의 아이디 확인
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		// 특정 강사가 강의하는 리스트 가져오기
		List<Map<String, Object>> lectureListByTeacher = lectureService.getLectureListByTeacher(accountId);
		// 디버깅 
		log.debug(TeamColor.PSJ + lectureListByTeacher + "<-- lectureListByTeacher" + TeamColor.TEXT_RESET);
		// 모델단에 전체과목리스트를 addAttribute해서 폼으로 전달한
		model.addAttribute("lectureListByTeacher", lectureListByTeacher);
		return "addExam";
	}

	// addQuestionInBank 폼
	// 파라미터 : List<subject>를 담아둘 Model
	// 리턴값: 문제 은행에 문제 추가하기 위한 form인 addQuestionInBank.jsp로 이동
	@GetMapping("/addQuestionInBank")
	String addExam(Model model) {
		// subject 리스트 model값으로 보내기
		List<Subject> subjectList = subjectService.getSubjectList();
		// 디버깅
		log.debug(TeamColor.PSJ + subjectList + "<-- subjectList" + TeamColor.TEXT_RESET);
		// 모델단에 전체과목리스트를 addAttribute해서 폼으로 전달한
		model.addAttribute("subjectList", subjectList);
		return "addQuestionInBank";
	}

	// MultiplechoiceService에서 객관식 문제를 추가한 후 객관식 보기 추가
	// 파라미터 : Map<String, Object>에 파라미터 담아서 서비스로 전송
	// 리턴값 : addExam.jsp
	@PostMapping("/addMultipleChoice")
	String addExam(Model model, @RequestParam(value = "subjectName") String subjectName,
			@RequestParam(value = "questionTitle") String questionTitle,
			@RequestParam(value = "questionAnswer") String questionAnswer,
			@RequestParam(value = "answer1") String answer1, @RequestParam(value = "answer2") String answer2,
			@RequestParam(value = "answer3") String answer3, @RequestParam(value = "answer4") String answer4,
			@RequestParam(value = "answer5") String answer5) {

		// MultiplechoiceService에 전송할 파라미터 생성
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectName", subjectName);
		paramMap.put("questionTitle", questionTitle);
		paramMap.put("questionAnswer", questionAnswer);
		paramMap.put("answer1", answer1);
		paramMap.put("answer2", answer2);
		paramMap.put("answer3", answer3);
		paramMap.put("answer4", answer4);
		paramMap.put("answer5", answer5);
		// 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// MultiplechoiceService call
		int row = multiplechoiceService.addMultipleChoiceAndExample(paramMap);
		// 서비스 정상적으로 작동했는지 디버깅
		if (row != 0) {
			log.debug(TeamColor.PSJ + "[Success] 정상적으로 객관식 문제와 해당 문제의 보기들이 추가되었습니다" + TeamColor.TEXT_RESET);
			model.addAttribute("alertMessage", "[Success] 문제 추가 성공");
		} else {
			log.debug(TeamColor.PSJ + "[Fail] 객관식 문제와 보기 추가에 실패하였습니다." + TeamColor.TEXT_RESET);
			model.addAttribute("alertMessage", "[Fail] 문제 추가 실패. 다시 시도해주세요");
		}
		return "addQuestionInBank";
	}
}
