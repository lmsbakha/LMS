package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReportController {
	// ReportService 객체 주입
	@Autowired
	ReportService reportService;

	// ROW_PER_PAGE의 개수가 변하지 않도록 상수로 선언
	private final int ROW_PER_PAGE = 10;
	
	@GetMapping("/reportList")
	public String reportdList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);
		
		// 요청받은 값 Map 객체에 셋팅
		Map<String, Object> map = reportService.getReportList(currentPage, ROW_PER_PAGE);
		model.addAttribute("reportdList", map.get("reportdList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		// 셋팅 값 디버깅
		log.debug(TeamColor.PSY + map.get("reportdList") + "<-- reportdList" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + map.get("lastPage") + "<-- lastPage" + TeamColor.TEXT_RESET);
		
		return "reportdList";
	}

	/*
	 * @GetMapping("/reportList") public String regionList(Model model) {
	 * List<Report> reportList = reportService.getReportList(); // reportService에서
	 * 받아온 reportList 값 디버깅 log.debug(TeamColor.PSY + reportList + "<-- reportList"
	 * + TeamColor.TEXT_RESET); model.addAttribute("reportList",reportList); return
	 * "reportList"; }
	 */
}
