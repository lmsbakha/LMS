package com.gd.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/reportList")
	public String reportdList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);

		// 요청받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("currentPage", currentPage);
		// 요청받은 값 Map 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
		
		// 페이징 service call
		List<Report> reportList = reportService.getReportList(currentPage, ROW_PER_PAGE);
		log.debug(TeamColor.PSY + reportList +"<--reportList" + TeamColor.TEXT_RESET);	

		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Controller" + TeamColor.TEXT_RESET);
		
		// reportList로 값 넘겨주기
		model.addAttribute("reportList",reportList);
		model.addAttribute("currentPage",currentPage);
		
		if (reportList != null) {
			// 성공
			// 파라미터 디버깅
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
			return "reportList";
		} else { 
			// 실패 
			log.debug(TeamColor.PSY + " 과제 리스트 조회실패" + TeamColor.TEXT_RESET);
			// 인덱스로 리다이렉트
			return "redirect:/index";
		}

	}
}