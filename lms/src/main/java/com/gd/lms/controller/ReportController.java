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

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ReportService;
import com.gd.lms.service.TeacherService;
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
	TeacherService teacherService;


	// 과제 리스트 조회
	// 파라미터 : reportList값 넘겨줄 Model
	// 리턴값 : reportList.jsp로 이동
	@GetMapping("/loginCheck/reportList")
	public String reportdList(Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportList Controller" + TeamColor.TEXT_RESET);
		
		
		// service call
		List<Report> reportList = reportService.getReportList();
		log.debug(TeamColor.PSY + reportList + "<--reportList" + TeamColor.TEXT_RESET);

		// reportList로 값 넘겨주기
		model.addAttribute("reportList", reportList);
		
		if (reportList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
			// reportList로 이동
			return "report/reportList";
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회실패" + TeamColor.TEXT_RESET);
			// index로 리다이렉트
			return "redirect:/loginCheck/reportList";
		}
	} // end reportList @GetMapping

	// 과제 출제하는 메소드
	// addReport Form
	// 파라미터 : List<LectureSubject>를 담아둘 Model, 세션 값
	// 리턴값: 과제를 출제하기 위한 form인 addReport.jsp로 이동
	@GetMapping("/loginCheck/addReport")
	String addReport(Model model, HttpSession session) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
		
		// 세션 받아오기
		String accountId = (String) session.getAttribute("sessionId");
		// 로그인한 강사의 아이디 확인
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 로그인한 아이디의 강사 정보 받아오기
		Map<String, Object> infoAboutTeacher = teacherService.getInfoAboutTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSY + infoAboutTeacher + "<-- infoAboutTeacher" + TeamColor.TEXT_RESET);
		
		// lectureSubject 리스트 model값으로 보내기
		List<LectureSubject> subjectNameList = reportService.getlectureSubject();
		// 디버깅
		log.debug(TeamColor.PSY + subjectNameList + "<-- subjectNameList" + TeamColor.TEXT_RESET);
		
		// 모델단에 전체과목리스트와 과목과정 기간을 addAttribute해서 폼으로 전달
		model.addAttribute("subjectNameList", subjectNameList);
		model.addAttribute("infoAboutTeacher", infoAboutTeacher);
		
		return "report/addReport";
	} // end addReport

	// 과제 출제하는 메소드
	// addReport Action
	// 파라미터 : Report
	// 리턴값 : reportList.jsp로 이동
	@PostMapping("/loginCheck/addReport")
	String addReport(@RequestParam("subjectName") String subjectName,
			@RequestParam("reportTitle") String reportTitle, @RequestParam("reportContent") String reportContent,
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
		// reportList로 리다이렉트
		return "redirect:/loginCheck/reportList";
	} // end addReport @PostMapping

	// 출제한 과제 수정하는 메소드
	// modifyReport Form
	// 파라미터 : Report 담아둘 Model , reportNo
	// 리턴값: 출제한 과제를 수정하기 위한 form인 modifyReport.jsp로 이동
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

		return "report/modifyReport";
	} // end modifyReport @GetMapping
	
	// 출제한 과제 수정하는 메소드
	// modifyReport Action
	// 파라미터 : 받아온 Report
	// 리턴값: 출제한 과제를 수정하기 위한 form인 modifyReport.jsp로 이동
	@PostMapping("/loginCheck/modifyReport")
	public String modifyReport(@RequestParam("reportNo") int reportNo,
			@RequestParam("reportTitle") String reportTitle, @RequestParam("reportContent") String reportContent,
			@RequestParam("reportStartDate") String reportStartDate,
			@RequestParam("reportEndDate") String reportEndDate) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReport Controller" + TeamColor.TEXT_RESET);

		// 받아온 값 paramReport에 셋팅
		Report paramReport = new Report();
		paramReport.setReportNo(reportNo);
		paramReport.setReportTitle(reportTitle);
		paramReport.setReportContent(reportContent);
		paramReport.setReportEndDate(reportEndDate);
		paramReport.setReportStartDate(reportStartDate);
		// 셋팅값 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);
		
		// 과제 수정 service call
		int modifyReport = reportService.modifyReport(paramReport);
		// 디버깅
		System.out.println("modifyReport");
		if (modifyReport != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 수정 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 수정 실패" + TeamColor.TEXT_RESET);
		}
		// reportList로 리다이렉트
		return "redirect:/loginCheck/reportList";
	} // end modifyReport @PostMapping

	// 행정용 출제한 과제 삭제하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : reportList.jsp로 이동
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
		// reportList로 리다이렉트
		return "redirect:/loginCheck/reportList";
	}
}
