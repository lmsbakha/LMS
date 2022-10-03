package com.gd.lms.controller;

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
import com.gd.lms.service.LectureService;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.service.MemberService;
import com.gd.lms.service.ReportService;
import com.gd.lms.service.ReportSubmitService;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Report;

import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 박소연
 * 작성일 : 2022-09 ~
 * 과제 출제 Controller
 * */

@Slf4j
@Controller
public class ReportController {
	// ReportService 객체 주입
	@Autowired
	ReportService reportService;

	// TeacherService 객체 주입
	@Autowired
	MemberService memberService;

	// ReportSubmitService 객체 주입
	@Autowired
	ReportSubmitService reportSubmitService;

	// ReportSubmitService 객체 주입
	@Autowired
	LectureService lectureService;

	// LectureSubjectService 객체 주입
	@Autowired
	LectureSubjectService lectureSubjectService;

	/*
	 * 행정/강사용 강좌 리스트 정보 받아오는 메소드
	 * 파라미터 : 강사 아이디 accountId , lectureListByTeacher 담을 Model
	 * 리턴값 : lectureListByTeacher 
	 * lectureSubjectList.jsp
	 */
	@GetMapping("/loginCheck/lectureSubjectList")
	String lectureSubjectList(HttpSession session, Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@lectureSubjectList Controller" + TeamColor.TEXT_RESET);

		// 세션에 저장된 아이디 받아오기
		String accountId = (String) session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// 세션에 저장된 레벨 받아오기
		int sessionLevel = (int) session.getAttribute("sessionLevel");
		// 디버깅
		log.debug(TeamColor.PSJ + sessionLevel + "<-- sessionLevel" + TeamColor.TEXT_RESET);
		
		// 강사용
		if(sessionLevel == 2) {
			// LectureService에서 lectureListByTeacher 가져오기
			List<Lecture> lectureListByTeacher = lectureService.getLectureListByAccoutId(accountId);
			// 디버깅
			log.debug(TeamColor.PSY + lectureListByTeacher + "<--lectureListByTeacher" + TeamColor.TEXT_RESET);

			// model 단에 값 저장해서 보내줌
			model.addAttribute("lectureListByTeacher", lectureListByTeacher);
		}else {
			// LectureService에서 lectureListByAdmin 가져오기
			List<Lecture> lectureListByAdmin = lectureService.getLectureListByAccoutId();
			// 디버깅
			log.debug(TeamColor.PSY + lectureListByAdmin + "<--lectureListByAdmin" + TeamColor.TEXT_RESET);

			// model 단에 값 저장해서 보내줌
			model.addAttribute("lectureListByAdmin", lectureListByAdmin);
		}
		// lectureSubjectList로 이동
		return "report/lectureSubjectList";
	} // end lectureSubjectList @GetMapping

	/*
	 * 행정/강사용 강의 리스트 정보 조회하는 메소드
	 * 파라미터 : 강좌명 lectureName 
	 * 리턴값 : lectureSubjectList
	 * lectureSubjectList.jsp
	 */
	@PostMapping("/loginCheck/lectureSubjectList")
	String lectureSubjectList(RedirectAttributes redirectAttributes, @RequestParam("lectureName") String lectureName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@lectureSubjectList Controller" + TeamColor.TEXT_RESET);
		// 파라미터값 디버깅
		log.debug(TeamColor.PSY + lectureName + "<--lectureName" + TeamColor.TEXT_RESET);

		// lectureSubjectList를 가져오기 위한 Service Call
		List<Map<String, Object>> lectureSubjectList = lectureSubjectService.getLectureSubjectList(lectureName);
		// lectureSubjectList 디버깅
		log.debug(TeamColor.PSY + lectureSubjectList + "<--lectureSubjectList" + TeamColor.TEXT_RESET);

		// model 단에 값 저장해서 보내줌
		redirectAttributes.addFlashAttribute("lectureSubjectList", lectureSubjectList);

		// lectureSubjectList로 리다이랙트
		return "redirect:/loginCheck/lectureSubjectList";
	} // end lectureSubjectList @PostMapping

	/*
	 * 행정/강사용 강의별 과제 리스트 조회하는 메소드
	 * 파라미터 : subjectName, reportList을 담아줄 Model 
	 * 리턴값 : reportList 
	 * reportList.jsp
	 */
	@GetMapping("/loginCheck/reportList")
	String reportList(@RequestParam("subjectName") String subjectName, Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportList Controller" + TeamColor.TEXT_RESET);
		// 파라미터값 디버깅
		log.debug(TeamColor.PSY + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);

		// reportList를 받아오기 위한 Service Call
		List<Map<String, Object>> reportList = reportService.getReportListBySubjectName(subjectName);
		// reportList 디버깅
		log.debug(TeamColor.PSY + reportList + "<--reportList" + TeamColor.TEXT_RESET);

		// model 단에 값 저장해서 보내줌
		model.addAttribute("reportList", reportList);

		if (reportList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}
		// reportList로 이동
		return "report/reportList";
	} // end reportList

	/*
	 * 과제 출제하는 메소드
	 * 파라미터: List<LectureSubject>를 담아둘 Model, 세션 값 
	 * 리턴값: addReport
	 * addReport.jsp Form
	 */
	@GetMapping("/loginCheck/addReport")
	String addReport(Model model, @RequestParam("subjectName") String subjectName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReport Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);

		// 모델단에 넘겨받은 subjectName을 addAttribute해서 폼으로 전달
		model.addAttribute("subjectName", subjectName);

		return "report/addReport";
	} // end addReport

	/*
	 * 과제 출제하는 메소드
	 * 파라미터 : 받아온 Report
	 * 리턴값 : lectureSubjectList 
	 * addReport.jsp Action
	 */
	@PostMapping("/loginCheck/addReport")
	String addReport(@RequestParam("subjectName") String subjectName, @RequestParam("reportTitle") String reportTitle,
			@RequestParam("reportContent") String reportContent,
			@RequestParam("reportStartDate") String reportStartDate,
			@RequestParam("reportEndDate") String reportEndDate) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReport Controller" + TeamColor.TEXT_RESET);

		// 받아온 값 paramReport에 셋팅
		Report paramReport = new Report();
		paramReport.setReportContent(reportContent);
		paramReport.setReportEndDate(reportEndDate);
		paramReport.setReportStartDate(reportStartDate);
		paramReport.setReportTitle(reportTitle);
		paramReport.setSubjectName(subjectName);
		// 셋팅값 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);

		// 과제 출제 service call
		int row = reportService.addReport(paramReport);

		if (row != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 출제 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 출제 실패" + TeamColor.TEXT_RESET);
		}
		// lectureSubjectList로 리다이렉트
		return "redirect:/loginCheck/lectureSubjectList";
	} // end addReport @PostMapping

	/*
	 * 출제한 과제 수정하는 메소드
	 * 파라미터 : Report 담아둘 Model , reportNo 
	 * 리턴값: modifyReport
	 * modifyReport.jsp Form
	 */
	@GetMapping("/loginCheck/modifyReport")
	String modifyReport(Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReport Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// reportOne 리스트 model값으로 보내기 Service Call
		Report reportOne = reportService.getReportOne(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportOne + "<-- reportOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportOne", reportOne);

		// modifyReport.jsp로 이동
		return "report/modifyReport";
	} // end modifyReport @GetMapping

	/*
	 * 출제한 과제 수정하는 메소드
	 * 파라미터 : 받아온 Report 
	 * 리턴값: modifyReport 
	 * modifyReport.jsp Action
	 */
	@PostMapping("/loginCheck/modifyReport")
	public String modifyReport(@RequestParam("reportNo") int reportNo, @RequestParam("reportTitle") String reportTitle,
			@RequestParam("subjectName") String subjectName, @RequestParam("reportContent") String reportContent,
			@RequestParam("reportStartDate") String reportStartDate,
			@RequestParam("reportEndDate") String reportEndDate) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReport Controller" + TeamColor.TEXT_RESET);

		// 받아온 값 paramReport에 셋팅
		Report paramReport = new Report();
		paramReport.setReportNo(reportNo);
		paramReport.setReportTitle(reportTitle);
		paramReport.setSubjectName(subjectName);
		paramReport.setReportContent(reportContent);
		paramReport.setReportEndDate(reportEndDate);
		paramReport.setReportStartDate(reportStartDate);
		// 셋팅값 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);

		// 과제 수정 service call
		int modifyReport = reportService.modifyReport(paramReport);
		// 디버깅
		log.debug(TeamColor.PSY + modifyReport + "<-- modifyReport" + TeamColor.TEXT_RESET);

		if (modifyReport != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 수정 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 수정 실패" + TeamColor.TEXT_RESET);
		}
		// lectureSubjectList로 리다이렉트
		return "redirect:/loginCheck/lectureSubjectList";
	} // end modifyReport @PostMapping

	/*
	 * 출제한 과제 삭제하는 메소드
	 * 파라미터 : reportNo 
	 * 리턴값 : lectureSubjectList 
	 * reportList.jsp
	 */
	@GetMapping("/loginCheck/removeReport")
	public String removeReport(@RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@removeReport Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// 과제 삭제 service call
		int removeReport = reportService.removeReport(reportNo);
		// 파라미터
		log.debug(TeamColor.PSY + removeReport + "<-- removeReport" + TeamColor.TEXT_RESET);

		if (removeReport != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 삭제 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 삭제 실패" + TeamColor.TEXT_RESET);
		}
		// lectureSubjectList로 리다이렉트
		return "redirect:/loginCheck/lectureSubjectList";
	} // end removeReport

	/*
	 * 학생용 강의 리스트 정보 조회하는 메소드
	 * 파라미터 : 학생 아이디 accountId, reportList을 담아줄 Model 
	 * 리턴값 : lectureSubjectList 
	 * lectureSubjectList.jsp
	 */
	@GetMapping("/loginCheck/lectureSubjectListByStudent")
	public String lectureSubjectListByStudent(HttpSession session, Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@lectureSubjectListByStudent Controller" + TeamColor.TEXT_RESET);

		// 세션에 저장된 아이디 받아오기
		String accountId = (String) session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 과제 삭제 service call
		List<LectureSubject> lectureSubjectListByStudent = lectureSubjectService.lectureSubjectInfoByStudent(accountId);
		// 파라미터
		log.debug(
				TeamColor.PSY + lectureSubjectListByStudent + "<-- lectureSubjectListByStudent" + TeamColor.TEXT_RESET);

		// 모델단에 lectureSubjectListByStudent을 addAttribute해서 폼으로 전달
		model.addAttribute("lectureSubjectListByStudent", lectureSubjectListByStudent);

		if (lectureSubjectListByStudent != null) {
			// 성공
			log.debug(TeamColor.PSY + " 학생용 강의 리스트 정보 조회하기 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 학생용 강의 리스트 정보 조회하기 실패" + TeamColor.TEXT_RESET);
		}

		// lectureSubjectListByStudent로 이동
		return "report/lectureSubjectListByStudent";
	} // end lectureSubjectListByStudent

	/*
	 * 학생용 강의별 과제 리스트 조회하는 메소드
	 * 파라미터 : sessionId, reportListByStudent을 담아줄 Model
	 *리턴값 :  reportList 
	 *reportListByStudent.jsp
	 */
	@GetMapping("/loginCheck/reportListByStudent")
	String reportListByStudent(HttpSession session, @RequestParam("subjectName") String subjectName, Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportListByStudent Controller" + TeamColor.TEXT_RESET);
		// 파라미터값 디버깅
		log.debug(TeamColor.PSY + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);

		// 세션에 저장된 아이디 받아오기
		String accountId = (String) session.getAttribute("sessionId");
		// 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// Service Call
		List<Map<String, Object>> reportListByStudent = reportService.getReportListStateInfo(accountId, subjectName);
		// lectureSubjectList 디버깅
		log.debug(TeamColor.PSY + reportListByStudent + "<--reportListByStudent" + TeamColor.TEXT_RESET);

		// model 단에 값 저장해서 보내줌
		model.addAttribute("reportListByStudent", reportListByStudent);

		if (reportListByStudent != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}
		// reportListByStudent로 이동
		return "report/reportListByStudent";
	} // end reportListByStudent
}
