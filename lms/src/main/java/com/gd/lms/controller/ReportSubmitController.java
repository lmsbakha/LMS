package com.gd.lms.controller;

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
import com.gd.lms.service.ReportService;
import com.gd.lms.service.ReportSubmitService;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;

import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 박소연
 * 작성일 : 2022-09 ~
 * 과제 제출 Controller
 * */

@Slf4j
@Controller
public class ReportSubmitController {
	// ReportService 객체 주입
	@Autowired
	ReportService reportService;

	// ReportSubmitService 객체 주입
	@Autowired
	ReportSubmitService reportSubmitService;

	// ROW_PER_PAGE의 개수가 변하지 않도록 상수로 선언
	private final int ROW_PER_PAGE = 10;

	// 과제 리스트 조회
	// 파라미터 : currentPage, reportSubmitList 담을 Model
	// 리턴값 : reportList.jsp로 이동
	@GetMapping("/loginCheck/reportSubmitList")
	public String reportSubmitList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitList Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);

		// 요청받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("currentPage", currentPage);
		// 요청받은 값 Map 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// 페이징 service call
		List<Report> reportSubmitList = reportService.getReportList(currentPage, ROW_PER_PAGE);
		// reportSubmitList 디버깅
		log.debug(TeamColor.PSY + reportSubmitList + "<--reportList" + TeamColor.TEXT_RESET);

		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitList Controller" + TeamColor.TEXT_RESET);

		// reportList로 값 넘겨주기
		model.addAttribute("reportList", reportSubmitList);
		model.addAttribute("currentPage", currentPage);

		if (reportSubmitList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
			// reportList로 이동
			return "report/reportSubmitList";
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회실패" + TeamColor.TEXT_RESET);
			// index로 리다이렉트
			return "redirect:/report/reportSubmitList";
		}
	} // end reportSubmitList @GetMapping

	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : reportSubmitListById 담을 Model
	// 리턴값 : reportSubmitListById.jsp로 이동
	@GetMapping("/loginCheck/reportSubmitListById")
	String reportSubmitListById(Model model, HttpSession session) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitListById Controller" + TeamColor.TEXT_RESET);

		// sessionId 값 넘겨주기
		String acountId = ((String) session.getAttribute("sessionId"));
		// accountId 디버깅
		log.debug(TeamColor.PSY + acountId + "<--acountId" + TeamColor.TEXT_RESET);

		// Service Call
		List<Map<String, Object>> reportSubmitListById = reportSubmitService.getReportListById(acountId);
		// reportSubmitListById 디버깅
		log.debug(TeamColor.PSY + reportSubmitListById + "<--reportSubmitListById" + TeamColor.TEXT_RESET);

		// model에 담기
		model.addAttribute("reportSubmitListById", reportSubmitListById);

		if (reportSubmitListById != null) {
			// 성공
			log.debug(TeamColor.PSY + " 제출한 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 제출한 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}

		// reportSubmitListById로 이동
		return "report/reportSubmitListById";
	}

	// 과제 상세보기 메소드
	// 파라미터 : reportOne 담을 Model
	// 리턴값: reportOne.jsp로 이동
	@GetMapping("/loginCheck/reportOne")
	String reportOne(Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportOne Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<--reportNo" + TeamColor.TEXT_RESET);

		// reportOne 리스트 model값으로 보내기 Service Call
		Report reportOne = reportService.getReportOne(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportOne + "<-- reportOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportOne", reportOne);

		// reportOne로 이동
		return "report/reportOne";
	} // end reportOne

	// 과제 제출하기 메소드 Form
	// 파라미터 : ReportSubmit 담을 Model
	// 리턴값 : addReportSubmit.jsp로 이동
	@GetMapping("/loginCheck/addReportSubmit")
	String addReportSubmit(Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo+ "<--reportNo" + TeamColor.TEXT_RESET);
		
		// reportOne 리스트 model값으로 보내기 Service Call
		Report reportOne = reportService.getReportOne(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportOne + "<-- reportOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportOne", reportOne);

		return "report/addReportSubmit";
	}

	// 과제 제출하기 메소드 Action
	// 파라미터 : ReportSubmit 담을 Model
	// 리턴값 : addReportSubmit.jsp로 이동
	@PostMapping("/logincheck/addReportSubmit")
	String addReportSubmit(Model model, @RequestParam("educationNo") int educationNo,
			@RequestParam(value = "reportNo") int reportNo, @RequestParam(value = "accountId") String accountId,
			@RequestParam(value = "reportSubmitTitle") String reportSubmitTitle,
			@RequestParam(value = "reportSubmitContent") String reportSubmitContent,
			@RequestParam(value = "reportSubmitScore") String reportSubmitScore) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);

		// 파라미터값 받아오기
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setAccountId(accountId);
		reportSubmit.setEducationNo(educationNo);
		reportSubmit.setReportSubmitContent(reportSubmitContent);
		reportSubmit.setReportSubmitNo(reportNo);
		reportSubmit.setReportSubmitScore(reportSubmitScore);
		reportSubmit.setReportSubmiTitle(reportSubmitTitle);

		// ReportSubmitService Call
		int addReportSubmit = reportSubmitService.addReportSubmit(reportSubmit);

		// model에 담기
		model.addAttribute("addReportSubmit", addReportSubmit);

		if (addReportSubmit != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 제출하기 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 제출하기 실패" + TeamColor.TEXT_RESET);
		}

		// addReportSubmit로 리다이렉트
		return "redirect:/report/addReportSubmit";

	} // end addReportSubmit
}
