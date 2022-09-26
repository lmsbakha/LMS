package com.gd.lms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ExamAnswerService;
import com.gd.lms.service.ExamQuestionSerivce;
import com.gd.lms.service.ExamService;
import com.gd.lms.service.LectureService;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.service.MemberService;
import com.gd.lms.service.MultiplechoiceService;
import com.gd.lms.service.ShortanswerQuestionService;
import com.gd.lms.service.SubjectService;
import com.gd.lms.service.TeacherService;
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

	// ShortanswerQuestionService 객체 주입
	@Autowired
	private ShortanswerQuestionService shortanswerQuestionService;

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

	// ExamQuestionSerivce 객체 주입
	@Autowired
	private ExamQuestionSerivce examQuestionSerivce;

	// MemberService 객체 주입
	@Autowired
	private MemberService memberService;
	
	//
	@Autowired
	private ExamAnswerService examAnswerService;

	//=============================================================================
	// 강사전용
	//=============================================================================

	/*
	 * [강사전용] 시험 메인페이지로 이동하는 메소드 파라미터 : sessionId Model 리턴값 : lectureListByTeacher
	 * exam.jsp
	 */
	@GetMapping("/loginCheck/exam")
	public String exam(HttpSession session, Model model) {
		// 세션에 저장된 값을 지역변수로 저장
		String accountId = (String) session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		//LectureService에서 lectureList가져오기
		List<Lecture> lectureListByTeacher = lectureService.getLectureListByAccoutId(accountId);
		// model 단에 값 저장해서 보내줌
		model.addAttribute("lectureListByTeacher", lectureListByTeacher);

		return "exam/exam"; // forwarding으로 보내줌
	}

	/*
	 * [강사전용] 문제은행 페이지를 보여주는 메소드 파라미터 : 객관식 문제를 담은 List를 view로 전송할 Model, 검색어
	 * subjectName 리턴값: 객관식 문제 리스트를 보여줄 문제 은행 view --> questionBank.jsp로 이동
	 */
	@GetMapping("/loginCheck/questionBank")
	public String questionBank(Model model, @RequestParam(value = "subjectName", required = false) String subjectName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);

		// 객관식 문제 리스트 가져오기
		List<Map<String, Object>> multiplechoiceList = multiplechoiceService.getMultipleChoiceList(subjectName);
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceList + "<-- multiplechoiceList" + TeamColor.TEXT_RESET);

		// 단답형 문제 리스트를 가져오기
		List<Map<String, Object>> shortAnswerQuestionList = shortanswerQuestionService.getShortAnswerQuestionList(subjectName);
		// 디버깅
		log.debug(TeamColor.PSJ + shortAnswerQuestionList + "<-- shortAnswerQuestionList" + TeamColor.TEXT_RESET);

		// 모델를 통해 문제리스트를 전송하기
		model.addAttribute("multiplechoiceList", multiplechoiceList);
		model.addAttribute("shortAnswerQuestionList", shortAnswerQuestionList);
		return "exam/questionBank";
	}

	/*
	 * [강사전용] 시험을 출제하는 페이지를 보여주는 메소드 파라미터 : List<Map<String, Object>를 담아둘 Model
	 * 리턴값:시험문제를 출제하기 위한 form인 addExam.jsp로 이동
	 */
	@GetMapping("/loginCheck/addExam")
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
		return "exam/addExam";
	}

	/*
	 * [강사전용] 시험을 출제하는 액션 메소드 파라미터 : 리턴 값 : addExam으로 이동하고 alertMsg로 성공 실패 여부 보내주기
	 */
	@PostMapping("/loginCheck/addExam")
	public String addExam(RedirectAttributes redirectAttributes, @RequestParam(value = "subjectName") String subjectName, @RequestParam(value = "examTitle") String examTitle, @RequestParam(value = "examContent") String examContent,
			@RequestParam(value = "multipleCnt") int multipleCnt, @RequestParam(value = "shortAnswerCnt") int shortAnswerCnt, @RequestParam(value = "examStartDate") String examStartDate,
			@RequestParam(value = "examEndDate") String examEndDate) {
		// 파라미터를 Map 객체 생성 후 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("subjectName", subjectName);
		paramMap.put("examTitle", examTitle);
		paramMap.put("examContent", examContent);
		paramMap.put("multipleCnt", multipleCnt);
		paramMap.put("shortAnswerCnt", shortAnswerCnt);
		paramMap.put("examStartDate", examStartDate);
		paramMap.put("examEndDate", examEndDate);
		// 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// Exam service call
		int row = examService.addExam(paramMap);

		if (row != 0) {
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		return "redirect:/loginCheck/addExam";
	}

	// [강사전용] addQuestionInBank 폼
	// 파라미터 : List<subject>를 담아둘 Model
	// 리턴값: 문제 은행에 문제 추가하기 위한 form인 addQuestionInBank.jsp로 이동
	@GetMapping("/loginCheck/addQuestionInBank")
	public String addExam(Model model) {
		// subject 리스트 model값으로 보내기
		List<Subject> subjectList = subjectService.getSubjectList();
		// 디버깅
		log.debug(TeamColor.PSJ + subjectList + "<-- subjectList" + TeamColor.TEXT_RESET);
		// 모델단에 전체과목리스트를 addAttribute해서 폼으로 전달한
		model.addAttribute("subjectList", subjectList);
		return "exam/addQuestionInBank";
	}

	/*
	 * [강사전용] MultiplechoiceService에서 객관식 문제를 추가한 후 객관식 보기 추가 파라미터 :
	 * Map<String,Object>에 파라미터 담아서 서비스로 전송 리턴값 : 문제 추가 유무를 알리는 msg, 문제 제출 폼
	 * addQuestionInBank.jsp으로 이동
	 * 
	 * model 대신 RedirectAttributes 사용 --> redirect로 할거여서 model단에 알람메시지를
	 * addAttribute하면 전달이 안되기 때문에 addFlashAttribute --> 1회성으로 메세지를 보여주면 되기 때문에
	 * addAttribute을 사용하지 않고 addFlashAttribute 사용함
	 */
	@PostMapping("/loginCheck/addMultipleChoice")
	public String addExam(RedirectAttributes redirectAttributes, @RequestParam(value = "subjectName") String subjectName, @RequestParam(value = "questionTitle") String questionTitle,
			@RequestParam(value = "questionAnswer") String questionAnswer, @RequestParam(value = "answer1") String answer1, @RequestParam(value = "answer2") String answer2, @RequestParam(value = "answer3") String answer3,
			@RequestParam(value = "answer4") String answer4, @RequestParam(value = "answer5") String answer5) {

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
			redirectAttributes.addFlashAttribute("alertMsg", "Success");
		} else {
			log.debug(TeamColor.PSJ + "[Fail] 객관식 문제와 보기 추가에 실패하였습니다." + TeamColor.TEXT_RESET);
			redirectAttributes.addFlashAttribute("alertMsg", "Fail");
		}
		return "redirect:/loginCheck/addQuestionInBank";
	}

	// 시험지 상세페이지
	// 파라미터 : examNo
	// 리턴값 : 시험지 리스트
	@GetMapping("/loginCheck/examOne")
	public String examOne(Model model, @RequestParam(value = "examNo") int examNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + examNo + "<-- examNo" + TeamColor.TEXT_RESET);
		//Service call
		List<Map<String, Object>> examOne = examQuestionSerivce.getExamByExamNo(examNo);

		model.addAttribute("examOne", examOne);

		return "exam/examOne";
	}

	//=============================================================================
	// 학생전용
	//=============================================================================
	// 시험 응시 폼
	// 파라미터 : SessionId
	// 리턴값 : 시험지(examAnswerIndex, examNo, examQuestionNo, multiplechoice & multiplechoiceExample에 관련된 데이터), 학생이름, educationNo
	@GetMapping("/loginCheck/submitExam")
	public String submitExam(HttpSession session, Model model, @RequestParam(value = "examNo") int examNo) {
		// 파라미터
		String loginId = (String) session.getAttribute("sessionId");
		// 로그인한 학생 아이디 디버깅
		log.debug(TeamColor.PSJ + loginId + "<-- 로그인한 sessionId" + TeamColor.TEXT_RESET);

		// 아이디로 학생 정보 가져오기
		Map<String, Object> studentInfo = memberService.getStudenetInfo(loginId);
		// 디버깅
		log.debug(TeamColor.PSJ + studentInfo + "<-- studentInfo" + TeamColor.TEXT_RESET);

		//Service call
		List<Map<String, Object>> examOne = examQuestionSerivce.getExamByExamNo(examNo);

		//model로 데이터 전송
		model.addAttribute("studentInfo", studentInfo);
		model.addAttribute("examOne", examOne);

		return "exam/submitExam";
	}

	// 시험 응시 액션
	// 파라미터 : SessionId
	// 리턴값 : 점수를 보여주는 resultExam.jsp이동
	@PostMapping("/loginCheck/submitExam")
	public String submitExam(@RequestParam(value = "educationNo") int educationNo, @RequestParam(value = "examQuestionIndex") String examQuestionIndex, @RequestParam(value = "questionType") String questionType,
			@RequestParam(value = "examAnswerContent1") String examAnswerContent1, @RequestParam(value = "examAnswerContent2") String examAnswerContent2, @RequestParam(value = "examAnswerContent3") String examAnswerContent3,
			@RequestParam(value = "examAnswerContent4") String examAnswerContent4, @RequestParam(value = "examAnswerContent5") String examAnswerContent5, @RequestParam(value = "examAnswerContent6") String examAnswerContent6,
			@RequestParam(value = "examAnswerContent7") String examAnswerContent7, @RequestParam(value = "examAnswerContent8") String examAnswerContent8, @RequestParam(value = "examAnswerContent9") String examAnswerContent9,
			@RequestParam(value = "examAnswerContent10") String examAnswerContent10) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + educationNo + "<-- educationNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + examQuestionIndex + "<-- examQuestionIndex" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + questionType + "<-- questionType" + TeamColor.TEXT_RESET);

		// 파라미터 배열로 정리
		String[] examQuestionIndexList = examQuestionIndex.split(",");
		String[] questionTypeList = questionType.split(",");
		String[] examAnswerContentList = { examAnswerContent1, examAnswerContent2, examAnswerContent3, examAnswerContent4, examAnswerContent5, examAnswerContent6, examAnswerContent7, examAnswerContent8, examAnswerContent9,
				examAnswerContent10 };
		// 배열 디버깅
		log.debug(TeamColor.PSJ + Arrays.toString(examQuestionIndexList) + "<-- examQuestionIndexList" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + Arrays.toString(questionTypeList) + "<-- questionTypeList" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + Arrays.toString(examAnswerContentList) + "<-- examAnswerContent" + TeamColor.TEXT_RESET);

		List<Map<String, Object>> answerSheet = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("educationNo", educationNo);
			paramMap.put("questionType", questionTypeList[i]);
			paramMap.put("examQuestionIndex", examQuestionIndexList[i]);
			paramMap.put("examAnswerContent", examAnswerContentList[i]);
			answerSheet.add(paramMap);
			log.debug(TeamColor.PSJ + (i + 1) + "문제 정답 셋팅" + TeamColor.TEXT_RESET);
		}
		
		//Service call
		// 점수 리턴 받기
		return "exam/exam";
	}
}
