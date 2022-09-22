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
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.EducationService;
import com.gd.lms.service.ReportService;
import com.gd.lms.service.ReportSubmitService;
import com.gd.lms.vo.Education;
import com.gd.lms.vo.FileForm;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;
import com.gd.lms.vo.ReportSubmitFile;

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

	// EducationService 객체 주입
	@Autowired
	EducationService educationService;

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

	// 과제 제출하기 메소드
	// addReportSubmit Form
	// 파라미터 : ReportSubmit 담을 Model
	// 리턴값 : addReportSubmit.jsp로 이동
	@GetMapping("/loginCheck/addReportSubmit")
	String addReportSubmit(HttpSession session, Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<--reportNo" + TeamColor.TEXT_RESET);

		// accountId 받아오기
		String accountId = ((String) session.getAttribute("sessionId"));
		// accountIdt 디버깅
		log.debug(TeamColor.PSY + accountId + "<--accountId" + TeamColor.TEXT_RESET);

		// reportOne 리스트 model값으로 보내기 Service Call
		Report reportOne = reportService.getReportOne(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportOne + "<-- reportOne" + TeamColor.TEXT_RESET);

		// getEducationInfo model값으로 보내기 Service Call
		Education getEducationInfo = educationService.getEducationInfo(accountId);
		// 디버깅
		log.debug(TeamColor.PSY + getEducationInfo + "<-- getEducationInfo" + TeamColor.TEXT_RESET);

		// 모델단에 reportOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportOne", reportOne);
		model.addAttribute("EducationInfo", getEducationInfo);

		return "report/addReportSubmit";
	}

	// 과제 제출하기 메소드
	// addReportSubmit Action
	// 파라미터 : sessionId, 받아온 reportSubmit
	// 리턴값 : addReportSubmit.jsp로 이동
	@PostMapping("/loginCheck/addReportSubmit")
	String addReportSubmit(HttpSession session, @RequestParam(value = "reportNo") int reportNo,
			@RequestParam(value = "educationNo") int educationNo,
			@RequestParam(value = "reportSubmitTitle") String reportSubmitTitle,
			@RequestParam(value = "reportSubmitContent") String reportSubmitContent) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);

		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<--reportNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + educationNo + "<--educationNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitTitle + "<--reportSubmitTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitContent + "<--reportSubmitContent" + TeamColor.TEXT_RESET);

		// accountId 받아오기
		String accountId = ((String) session.getAttribute("sessionId"));
		// accountIdt 디버깅
		log.debug(TeamColor.PSY + accountId + "<--accountId" + TeamColor.TEXT_RESET);

		// 파라미터값 받아오기
		Map<String, Object> reportSubmit = new HashMap<>();
		reportSubmit.put("accountId", accountId);
		reportSubmit.put("reportSubmitContent", reportSubmitContent);
		reportSubmit.put("reportNo", reportNo);
		reportSubmit.put("reportSubmitTitle", reportSubmitTitle);
		reportSubmit.put("educationNo", educationNo);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<--reportSubmit" + TeamColor.TEXT_RESET);

		// 과제 제출 service call
		int addReportSubmit = reportSubmitService.addReportSubmit(reportSubmit);
		// addReportSubmit 디버깅
		log.debug(TeamColor.PSY + addReportSubmit + "<--addReportSubmit" + TeamColor.TEXT_RESET);

		if (addReportSubmit != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 제출하기 성공" + TeamColor.TEXT_RESET);
			// addReportSubmit로 이동
			return "redirect:/loginCheck/reportSubmitList";
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 제출하기 실패" + TeamColor.TEXT_RESET);
			// addReportSubmit로 이동
			return "redirect:/loginCheck/addReportSubmit";
		}

	} // end addReportSubmit

	// 제출한 과제 수정하는 메소드
	// modifyReportSubmit Form
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	@GetMapping("/loginCheck/modifyReportSubmit")
	String modifyReportSubmit(Model model, @RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		
		// reportSubmitOne 리스트 model값으로 보내기 Service Call
		int reportSubmitOne = reportSubmitService.ReportSubmitOne(reportSubmitNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportSubmitOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportSubmitOne", reportSubmitOne);

		return "report/reportSubmitOne";

	}

	// 제출한 과제 수정하는 메소드
	// modifyReportSubmit action
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	@PostMapping("/loginCheck/modifyReportSubmit")
	String modifyReportSubmit() {
		return null;

	}
}
