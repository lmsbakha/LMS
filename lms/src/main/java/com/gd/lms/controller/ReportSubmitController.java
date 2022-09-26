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
import com.gd.lms.service.LectureService;
import com.gd.lms.service.ReportService;
import com.gd.lms.service.ReportSubmitService;
import com.gd.lms.service.TeacherService;
import com.gd.lms.vo.Education;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.ReportSubmitForm;
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

	// EducationService 객체 주입
	@Autowired
	EducationService educationService;

	// TeacherService 객체 주입
	@Autowired
	TeacherService teacherService;

	// LectureService 객체 주입
	@Autowired
	LectureService lectureService;

	// 과제 리스트 조회
	// 파라미터 : currentPage, reportSubmitList 담을 Model
	// 리턴값 : reportList.jsp로 이동
	@GetMapping("/loginCheck/reportSubmitList")
	public String reportSubmitList(Model model) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitList Controller" + TeamColor.TEXT_RESET);

		// service call
		List<Report> reportSubmitList = reportService.getReportList();
		// reportSubmitList 디버깅
		log.debug(TeamColor.PSY + reportSubmitList + "<--reportList" + TeamColor.TEXT_RESET);

		// reportList로 값 넘겨주기
		model.addAttribute("reportList", reportSubmitList);

		if (reportSubmitList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
			// reportSubmitList로 이동
			return "report/reportSubmitList";
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 리스트 조회실패" + TeamColor.TEXT_RESET);
			// index로 리다이렉트
			return "redirect:/report/reportSubmitList";
		}
	} // end reportSubmitList @GetMapping

	// 학생별 제출한 과제 리스트 조회 메소드
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

		// 요청 받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("acountId", acountId);
		log.debug(TeamColor.PSY + paramMap + "<--paramMap" + TeamColor.TEXT_RESET);

		// Service Call
		List<ReportSubmit> reportSubmitListById = reportSubmitService.getReportListById(acountId);
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
	} // end reportSubmitListById

	// 강좌별 제출한 과제 리스트 조회 메소드
	// reportSubmitList Form
	// 파라미터 : infoAboutTeacher, subjectNameList 담을 Model
	// 리턴값 : reportSubmitList.jsp로 이동
	@GetMapping("/login/reportSubmitList")
	String reportSubmitList(Model model, @RequestParam("educationNo") int educationNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitList Controller" + TeamColor.TEXT_RESET);
		// 파라미터값 디버깅
		log.debug(TeamColor.PSY + educationNo + "<--educationNo" + TeamColor.TEXT_RESET);

		// 요청 받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("educationNo", educationNo);
		log.debug(TeamColor.PSY + paramMap + "<--paramMap" + TeamColor.TEXT_RESET);

		// lectureSubject 리스트 model값으로 보내기
		List<ReportSubmit> reportSubmitListBySubject = reportSubmitService.getReportListBySubject(educationNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitListBySubject + "<-- reportSubmitListBySubject" + TeamColor.TEXT_RESET);

		// 모델단에 전체과목리스트와 과목과정 기간을 addAttribute해서 폼으로 전달
		model.addAttribute("subjectNameList", reportSubmitListBySubject);

		if (reportSubmitListBySubject != null) {
			// 성공
			log.debug(TeamColor.PSY + " 학생별 제출한 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 학생별 제출한 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}
		return "report/reportSubmitList";
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

	// 제출한 과제 점수 수정하는 메소드
	// modifyReportScore Form
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	@GetMapping("/loginCheck/modifyReportScore")
	String modifyReportScore(Model model, @RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// reportSubmitOne 리스트 model값으로 보내기 Service Call
		ReportSubmit reportSubmitOne = reportSubmitService.ReportSubmitOne(reportSubmitNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportSubmitOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportSubmitOne", reportSubmitOne);

		return "report/modifyReportScore";
	} // end modifyReportScore @GetMapping

	// 제출한 과제 점수 수정하는 메소드
	// modifyReportScore Action
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	@PostMapping("/loginCheck/addReportSubmit")
	String modifyReportScore() {
		return null;

	} // end modifyReportScore @PostMapping

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
		ReportSubmit reportSubmitOne = reportSubmitService.ReportSubmitOne(reportSubmitNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportSubmitOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportSubmitOne", reportSubmitOne);

		return "report/modifyReportSubmit";

	} // end modifyReportSubmit @GetMapping

	// 제출한 과제 수정하는 메소드
	// modifyReportSubmit action
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	@PostMapping("/loginCheck/modifyReportSubmit")
	String modifyReportSubmit(@RequestParam("reportSubmitTitle") String reportSubmitTitle,
			@RequestParam("reportSubmitContent") String reportSubmitContent,
			@RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitTitle + "<-- reportSubmitTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitContent + "<-- reportSubmitContent" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// 파라미터 값 셋팅
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setReportSubmitContent(reportSubmitContent);
		reportSubmit.setReportSubmitNo(reportSubmitNo);
		reportSubmit.setReportSubmitTitle(reportSubmitTitle);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		// Service Call
		int modifyReportSubmit = reportSubmitService.modifyReportSubmit(reportSubmit);
		// modifyReportSubmit 디버깅
		log.debug(TeamColor.PSY + modifyReportSubmit + "<-- modifyReportSubmit" + TeamColor.TEXT_RESET);

		if (modifyReportSubmit != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 제출한 과제 수정 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 제출한 과제 수정 실패" + TeamColor.TEXT_RESET);
		}

		// reportSubmitListById로 이동
		return "report/reportSubmitListById";
	} // end modifyReportSubmit @PostMapping

	// 제출한 과제 삭제하는 메소드
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	@GetMapping("/loginCheck/removeReportSubmit")
	public String removeReportSubmit(@RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@removeReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// 과제 삭제 service call
		int removeReportSubmit = reportSubmitService.removeReportSubmit(reportSubmitNo);
		// 파라미터
		log.debug(TeamColor.PSY + removeReportSubmit + "<-- removremoveReportSubmiteReport" + TeamColor.TEXT_RESET);

		if (reportSubmitNo != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 과제 삭제 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제 삭제 실패" + TeamColor.TEXT_RESET);
		}
		// reportList로 리다이렉트
		return "redirect:/loginCheck/reportReportList";
	} // end
}
