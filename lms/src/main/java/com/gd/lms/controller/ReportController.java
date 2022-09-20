package com.gd.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ReportService;
import com.gd.lms.vo.Report;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReportController {
	// ReportService 객체 주입
	@Autowired
	ReportService reportService;

	// ROW_PER_PAGE의 개수가 변하지 않도록 상수로 선언
	private final int ROW_PER_PAGE = 10;

	// 과제 리스트 조회
	// 파라미터 : ROW_PER_PAGE, currentPage, reportList
	// 리턴값 : reportList.jsp로 이동
	@GetMapping("/reportList")
	public String reportdList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportList Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);

		// 요청받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("currentPage", currentPage);
		// 요청받은 값 Map 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// 페이징 service call
		List<Report> reportList = reportService.getReportList(currentPage, ROW_PER_PAGE);
		log.debug(TeamColor.PSY + reportList + "<--reportList" + TeamColor.TEXT_RESET);

		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportList Controller" + TeamColor.TEXT_RESET);

		// reportList로 값 넘겨주기
		model.addAttribute("reportList", reportList);
		model.addAttribute("currentPage", currentPage);

		if (reportList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
			// reportList로 리다이렉트
			return "reportList";
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회실패" + TeamColor.TEXT_RESET);
			// index로 리다이렉트
			return "redirect:/index";
		}
	} // end reportdList @GetMapping

	/*
	 * // 과제 출제하는 메소드 // addReport 폼 // 파라미터 : List<subject>를 담아둘 Model // 리턴값: 과제를
	 * 출제하기 위한 form인 addReport.jsp로 이동
	 * 
	 * @GetMapping("/addReport") String addReport(Model model) { // 디버깅 영역구분
	 * log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
	 * 
	 * // subject 리스트 model값으로 보내기 List<Subject> lecureSubjectList =
	 * lectureSubjectService. // 디버깅 log.debug(TeamColor.PSY + lecureSubjectList +
	 * "<-- lecureSubjectList" + TeamColor.TEXT_RESET); // 모델단에 전체과목리스트를
	 * addAttribute해서 폼으로 전달 model.addAttribute("lecureSubjectList",
	 * lecureSubjectList); return "addReport"; } // end addReport
	 */

	// addReport 액션
	// 파라미터 : Report
	// 리턴값 : reportList.jsp로 이동
	@PostMapping("/addReport")
	String addReport(Model model, @RequestParam("subjectName") String subjectName,
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
		return "redirect:/reportList";
	} // end addReport @PostMapping

	// 출제한 과제 수정하는 메소드
	// modifyReport 폼
	// 파라미터 : Report 담아둘 Model , reportNo
	// 리턴값: 출제한 과제를 수정하기 위한 form인 modifyReport.jsp로 이동
	@GetMapping("/modifyReport")
	String modifyReport(Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// reportOne 리스트 model값으로 보내기
		Report reportOne = reportService.getReportOne(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + "<-- lecureSubjectList" + TeamColor.TEXT_RESET);

		// 모델단에 reportOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportOne", reportOne);

		return "modifyReport";
	} // end modifyReport @GetMapping

	// 나라 수정 Action
	@PostMapping("/modifyReport")
	public String modifyList(Model model, @RequestParam("reportTitle") String reportTitle,
			@RequestParam("reportContent") String reportContent,
			@RequestParam("reportStartDate") String reportStartDate,
			@RequestParam("reportEndDate") String reportEndDate) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);

		// 받아온 값 paramReport에 셋팅
		Report paramReport = new Report();
		paramReport.setReportContent(reportContent);
		paramReport.setReportEndDate(reportEndDate);
		paramReport.setReportStartDate(reportStartDate);
		paramReport.setReportTitle(reportTitle);
		// 셋팅값 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);

		int modifyReport = reportService.modifyReport(paramReport);
		// 디버깅
		System.out.println("modifyReport");

		return "redirect:/reportList";
	}

	// 행정용 출제한 과제 삭제하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : reportList.jsp로 이동
	@GetMapping("/removeReport")
	public String removeReport(@RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

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
		return "redirect:/reportList";
	}
}
