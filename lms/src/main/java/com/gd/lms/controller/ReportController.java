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
import com.gd.lms.service.SubjectService;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReportController {
	// ReportService 객체 주입
	@Autowired
	ReportService reportService;
	// SubjectService 객체 주입
	@Autowired
	SubjectService subjectService;

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
	} // end reportdList 
	

	// 과제 출제하는 메소드
	// addReport 폼
	// 파라미터 : List<subject>를 담아둘 Model
	// 리턴값: 과제를 출제하기 위한 form인 addReport.jsp로 이동
	@GetMapping("/addReport")
	String addReport(Model model) {
		// subject 리스트 model값으로 보내기
		List<Subject> subjectList = subjectService.getSubjectList();
		// 디버깅
		log.debug(TeamColor.PSY + subjectList + "<-- subjectList" + TeamColor.TEXT_RESET);
		// 모델단에 전체과목리스트를 addAttribute해서 폼으로 전달한
		model.addAttribute("subjectList", subjectList);
		return "addReport";
	} // end addReport

	// 파라미터 : Report
	// 파라미터 : 
	// 리턴값 : int
	
}
