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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.service.ExamService;
import com.gd.lms.service.LectureService;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.service.MultiplechoiceExampleService;
import com.gd.lms.service.MultiplechoiceService;
import com.gd.lms.service.ShortanswerQuestionService;
import com.gd.lms.service.SubjectService;
import com.gd.lms.service.TeacherService;
import com.gd.lms.vo.Exam;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 박소정
 * 작성일 : 2022-09 ~
 * 시험 출제와 관련된 메소드 
 * */

@Slf4j
@Controller
public class ExamController {
	// MultiplechoiceService 객체 주입
	@Autowired
	private MultiplechoiceService multiplechoiceService;

	// LectureService 객체 주입
	@Autowired
	private LectureSubjectService lectureSubjectService;

	// SubjectService 객체 주입
	@Autowired
	private SubjectService subjectService;

	// TeacherService 객체 주입
	@Autowired
	private TeacherService teacherService;

	// ExamService 객체 주입
	@Autowired
	private ExamService examService;

	//LectureService 객체 주입
	@Autowired
	private LectureService lectureService;

	/*
	 * [강사전용] 시험 메인페이지로 이동하는 메소드 
	 * 파라미터 : sessionId
	 * Model 리턴값 : lectureListByTeacher
	 * exam.jsp
	 */
	@GetMapping("/exam")
	public String exam(HttpSession session, Model model) {
		// 세션에 저장된 값을 지역변수로 저장
		String accountId = (String) session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		//LectureService에서 lectureList가져오기
		List<Lecture> lectureListByTeacher = lectureService.getLectureListByAccoutId(accountId);
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByTeacher", lectureListByTeacher);

		return "exam"; // forwarding으로 보내줌
	}

	/*
	 * [강사전용] 시험 메인페이지로 이동하는 메소드 
	 * 파라미터 : 사용자가 선택한 lectureName 
	 * 리턴값 : lecture에서 출제된 시험리스트
	 */
	@PostMapping("/lectureListByTeacher")
	public String lectureListByTeacher(RedirectAttributes redirectAttributes, @RequestParam(value = "lectureName") String lectureName) {
		// 디버깅
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// ExamList 가져오기
		List<Map<String, Object>> examListByLecture = examService.getExamListByLecture(lectureName);
		// model 단에 값 저장해서 보내줌
		redirectAttributes.addFlashAttribute("examListByLecture", examListByLecture);

		return "redirect:/exam"; 
	}

	/*
	 * [강사전용] 문제은행 페이지를 보여주는 메소드 
	 * 파라미터 : 객관식 문제를 담은 List를 view로 전송할 Model, 검색어 subjectName 
	 * 리턴값: 객관식 문제 리스트를 보여줄 문제 은행 view --> questionBank.jsp로 이동
	 */
	@GetMapping("/questionBank")
	public String examList(Model model, @RequestParam(value = "subjectName", required = false) String subjectName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);

		// 단답형 문제와 객관식 문제들이 들어 있는 문제 리스트 객체 생성
		// 객관식 문제 리스트 가져오기
		List<Map<String, Object>> multiplechoiceList = multiplechoiceService.getMultipleChoiceList(subjectName);
		// 단답형 문제 리스트를 가져오기
		log.debug(TeamColor.PSJ + multiplechoiceList + "<-- multiplechoiceList" + TeamColor.TEXT_RESET);

		// 모델 단으로 전송하기
		model.addAttribute("multiplechoiceList", multiplechoiceList);
		return "questionBank";
	}

	/*
	 * [강사전용] 시험을 출제하는 페이지를 보여주는 메소드 
	 * 파라미터 : List<Map<String, Object>를 담아둘 Model 
	 * 리턴값:시험문제를 출제하기 위한 form인 addExam.jsp로 이동
	 */
	@GetMapping("/addExam")
	public String addExam(HttpSession session, Model model) {
		String accountId = (String) session.getAttribute("sessionId");
		// 로그인한 강사의 아이디 확인
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 로그인한 아이디의 강사 정보 받아오기
		Map<String, Object> infoAboutTeacher = teacherService.getInfoAboutTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + infoAboutTeacher + "<-- infoAboutTeacher" + TeamColor.TEXT_RESET);

		// 특정 강사가 강의하는 과목 리스트 가져오기
		List<Map<String, Object>> lectureSubjectList = lectureSubjectService.getLectureSubjectList((String) infoAboutTeacher.get("lectureName"));
		// 디버깅
		log.debug(TeamColor.PSJ + lectureSubjectList + "<-- lectureSubjectList" + TeamColor.TEXT_RESET);

		// 모델단에 전체과목리스트를 addAttribute해서 폼으로 전달한
		model.addAttribute("lectureSubjectList", lectureSubjectList);
		model.addAttribute("infoAboutTeacher", infoAboutTeacher);
		return "addExam";
	}

	/*
	 * [강사전용] 시험을 출제하는 액션 메소드 
	 * 파라미터 : 
	 * 리턴 값 : addExam으로 이동하고 alertMsg로 성공 실패 여부 보내주기
	 */
	@PostMapping("/addExam")
	public String addExam(RedirectAttributes redirectAttributes
			, @RequestParam(value = "subjectName") String subjectName
			, @RequestParam(value = "examTitle") String examTitle
			, @RequestParam(value = "examContent") String examContent
			, @RequestParam(value = "multipleCnt") int multipleCnt
			, @RequestParam(value = "shortAnswerCnt") int shortAnswerCnt
			, @RequestParam(value = "examStartDate") String examStartDate
			, @RequestParam(value = "examEndDate") String examEndDate) {
		// 파라미터를 Map 객체 생성 후 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectName", subjectName);
		paramMap.put("examTitle", examTitle);
		paramMap.put("examContent", examContent);
		paramMap.put("multipleCnt", multipleCnt);
		paramMap.put("shortAnswerCnt", shortAnswerCnt);
		paramMap.put("examStartDate", examStartDate);
		paramMap.put("examEndDate", examEndDate);
		;
		// 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// Exam service call
		int row = examService.addExam(paramMap);

		if (row != 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "[Success] 문제 출제에 성공하였습니다");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "[Fail] 문제 출제에 실패하였습니다.");
		}
		return "redirect:/addExam";
	}

	// [강사전용] addQuestionInBank 폼
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

	/*
	 * [강사전용] MultiplechoiceService에서 객관식 문제를 추가한 후 객관식 보기 추가 
	 * 파라미터 : Map<String,Object>에 파라미터 담아서 서비스로 전송 
	 * 리턴값 : 문제 추가 유무를 알리는 msg, 문제 제출 폼 addQuestionInBank.jsp으로 이동
	 * 
	 * model 대신 RedirectAttributes 사용 --> redirect로 할거여서 model단에 알람메시지를 addAttribute하면 전달이 안되기 때문에
	 * addFlashAttribute --> 1회성으로 메세지를 보여주면 되기 때문에 addAttribute을 사용하지 않고 addFlashAttribute 사용함
	 */
	@PostMapping("/addMultipleChoice")
	String addExam(RedirectAttributes redirectAttributes
			, @RequestParam(value = "subjectName") String subjectName
			, @RequestParam(value = "questionTitle") String questionTitle
			, @RequestParam(value = "questionAnswer") String questionAnswer
			, @RequestParam(value = "answer1") String answer1
			, @RequestParam(value = "answer2") String answer2
			, @RequestParam(value = "answer3") String answer3
			, @RequestParam(value = "answer4") String answer4
			, @RequestParam(value = "answer5") String answer5) {

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
			redirectAttributes.addFlashAttribute("alertMessage", "[Success] 문제 추가 성공");
		} else {
			log.debug(TeamColor.PSJ + "[Fail] 객관식 문제와 보기 추가에 실패하였습니다." + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMessage", "[Fail] 문제 추가 실패. 다시 시도해주세요");
		}
		return "redirect:/addQuestionInBank";
	}
}
