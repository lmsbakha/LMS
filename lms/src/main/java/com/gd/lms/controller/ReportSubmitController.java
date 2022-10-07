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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.EducationService;
import com.gd.lms.service.LectureService;
import com.gd.lms.service.LectureSubjectService;
import com.gd.lms.service.MemberService;
import com.gd.lms.service.ReportService;
import com.gd.lms.service.ReportSubmitService;
import com.gd.lms.vo.Education;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;
import com.gd.lms.vo.ReportSubmitFile;
import com.gd.lms.vo.ReportSubmitForm;

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
	MemberService memberService;

	// LectureService 객체 주입
	@Autowired
	LectureService lectureService;

	// LectureService 객체 주입
	@Autowired
	LectureSubjectService lectureSubjectService;

	/*
	 * 과제별 제출한 과제 리스트 조회 메소드 
	 * 파라미터: reportNo 
	 * 리턴값: List<ReportSubmit>
	 * reportSubmitList.jsp
	 */
	@GetMapping("/loginCheck/reportSubmitList")
	String reportSubmitList(Model model, @RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitList Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<--reportNo" + TeamColor.TEXT_RESET);

		// Service Call
		List<Map<String, Object>> reportSubmitList = reportSubmitService.getReportListByReport(reportNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitList + "<--reportSubmitList" + TeamColor.TEXT_RESET);

		// model에 담기
		model.addAttribute("reportSubmitList", reportSubmitList);

		if (reportSubmitList != null) {
			// 성공
			log.debug(TeamColor.PSY + " 과제별 제출한 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 과제별 제출한 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}
		// reportSubmitList로 이동
		return "report/reportSubmitList";
	} // end reportSubmitList

	/*
	 * 학생별 제출한 과제 리스트 조회 메소드 
	 * 파라미터: reportSubmitListById 담을 
	 * Model 리턴값: reportSubmitListById reportSubmitListById.jsp
	 */
	@GetMapping("/loginCheck/reportSubmitListById")
	String reportSubmitListById(Model model, HttpSession session, @RequestParam("subjectName") String subjectName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitListById Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);

		// sessionId 값 넘겨주기
		String accountId = ((String) session.getAttribute("sessionId"));
		// accountId 디버깅
		log.debug(TeamColor.PSY + accountId + "<--accountId" + TeamColor.TEXT_RESET);

		// Service Call
		List<ReportSubmit> listById = reportSubmitService.getReportListById(accountId, subjectName);
		// reportSubmitListById 디버깅
		log.debug(TeamColor.PSY + listById + "<--listById" + TeamColor.TEXT_RESET);

		// model에 담기
		model.addAttribute("listById", listById);

		if (listById != null) {
			// 성공
			log.debug(TeamColor.PSY + " 제출한 과제 리스트 조회 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 제출한 과제 리스트 조회 실패" + TeamColor.TEXT_RESET);
		}
		// reportSubmitListById로 이동
		return "report/reportSubmitListById";
	} // end reportSubmitListById

	/*
	 * 과제 제출하기 메소드 
	 * 파라미터: accountId, educationInfoById 담믈 Model 
	 * 리턴값: educationInfoById addReportSubmit Form 
	 * addReportSubmit.jsp
	 */
	@GetMapping("/loginCheck/addReportSubmit")
	public String addReportSubmit(Model model, HttpSession session, @RequestParam("subjectName") String subjectName,
			@RequestParam("reportNo") int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportNo + "<--reportNo" + TeamColor.TEXT_RESET);

		// sessionId 값 넘겨주기
		String accountId = ((String) session.getAttribute("sessionId"));
		// accountId 디버깅
		log.debug(TeamColor.PSY + accountId + "<--accountId" + TeamColor.TEXT_RESET);
		
		// accountId의 education 정보 받아오기
		Education educationInfoById = educationService.getEducationInfo(accountId);
		// educationInfoById 디버깅
		log.debug(TeamColor.PSY + educationInfoById + "<--educationInfoById" + TeamColor.TEXT_RESET);

		// subjectName, reportNo model값으로 보내기
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("reportNo", reportNo);
		model.addAttribute("educationInfoById", educationInfoById);

		return "/report/addReportSubmit";
	} // end addReportSubmit @GetMapping

	/*
	 * 과제 제출하기 메소드 
	 * 파라미터: ReportSubmit , ReportSubmitFile 
	 * 리턴값: ReportSubmit , ReportSubmitFile 
	 * addReportSubmit  Action 
	 * addReportSubmit.jsp
	 */
	@PostMapping("/loginCheck/addReportSubmit")
	String addReportSubmit(ReportSubmitForm reportSubmitForm) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitForm + "<--reportSubmitForm" + TeamColor.TEXT_RESET);

		// Service Call
		reportSubmitService.addReportSubmit(reportSubmitForm);

		return "redirect:/loginCheck/lectureSubjectListByStudent";
	} // end addReportSubmit

	/*
	 * 제출한 과제 상세보기 메소드 
	 * 파라미터: reportSubmitOne 담을 Model 
	 * 리턴값: reportSubmitOne 
	 * reportSubmitOne Form 
	 * reportSubmitOne.jsp 
	 */
	@GetMapping("/loginCheck/reportSubmitOne")
	String reportOne(Model model, @RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitOne Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<--reportSubmitNo" + TeamColor.TEXT_RESET);

		// 요청 받은 값 Map 객체에 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("reportSubmitNo", reportSubmitNo);
		// paramMap 디버깅
		log.debug(TeamColor.PSY + paramMap + "<--paramMap" + TeamColor.TEXT_RESET);

		// Service Call
		Map<String, Object> reportSubmitOne = reportSubmitService.reportSubmitOne(reportSubmitNo);
		// reportSubmitOne 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<--reportSubmitOne" + TeamColor.TEXT_RESET);

		// 모델단에 제출한 과제를 addAttribute해서 폼으로 전달
		model.addAttribute("reportSubmitOne", reportSubmitOne);

		if (reportSubmitOne != null) {
			// 성공
			log.debug(TeamColor.PSY + " 제출한 과제 상세보기 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 제출한 과제 상세보기 실패" + TeamColor.TEXT_RESET);
		}
		return "report/reportSubmitOne";
	} // end reportSubmitOne

	/*
	 * 제출한 과제 점수 수정하는 메소드
	 *  파라미터 : reportSubmitNo 
	 *  리턴값 : modifyReportScore
	 *  modifyReportScore Form 
	 *  modifyReportScore.jsp
	 */
	@GetMapping("/loginCheck/modifyReportScore")
	String modifyReportScore(Model model, @RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportScore Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// Service Call
		Map<String, Object> modifyScoreForm = reportSubmitService.modifyReportSubmitScoreForm(reportSubmitNo);
		// modufyScoreForm 디버깅
		log.debug(TeamColor.PSY + modifyScoreForm + "<--modifyScoreForm" + TeamColor.TEXT_RESET);

		// 모델단에 제출한 과제를 addAttribute해서 폼으로 전달
		model.addAttribute("modifyScoreForm", modifyScoreForm);

		if (modifyScoreForm != null) {
			// 성공
			log.debug(TeamColor.PSY + " 점수 수정 페이지 상세보기 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 점수 수정 페이지 상세보기 실패" + TeamColor.TEXT_RESET);
		}
		return "report/modifyReportScore";
	} // end modifyReportScore @GetMapping

	/*
	 * 교사용 제출한 과제 점수 수정하는 메소드 
	 * 파라미터 : reportSubmitNo 
	 * 리턴값 : modifyReportScore 
	 * modifyReportScore Action 
	 * modifyReportScore.jsp
	 */
	@PostMapping("/loginCheck/modifyReportScore")
	String modifyReportScore(RedirectAttributes redirectAttributes, @RequestParam("reportSubmitNo") int reportSubmitNo,
			@RequestParam("reportSubmitScore") String reportSubmitScore) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportScore Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitScore + "<-- reportSubmitScore" + TeamColor.TEXT_RESET);

		// 요청갑 셋팅
		ReportSubmit paramReportSubmit = new ReportSubmit();
		paramReportSubmit.setReportSubmitNo(reportSubmitNo);
		paramReportSubmit.setReportSubmitScore(reportSubmitScore);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paramReportSubmit + "<-- paramReportSubmit" + TeamColor.TEXT_RESET);

		// modifyReportScore 리스트 model값으로 보내기 Service Call
		int modifyReportScore = reportSubmitService.modifyReportScore(paramReportSubmit);
		// 디버깅
		log.debug(TeamColor.PSY + modifyReportScore + "<-- modifyReportScore" + TeamColor.TEXT_RESET);

		if (modifyReportScore != 0) {
			// 성공
			log.debug(TeamColor.PSY + " 점수 수정 성공" + TeamColor.TEXT_RESET);
		} else {
			// 실패
			log.debug(TeamColor.PSY + " 점수 수정 실패" + TeamColor.TEXT_RESET);
		}

		return "redirect:/loginCheck/lectureSubjectList";
	} // end modifyReportScore @PostMapping

	/*
	 * 제출한 과제 수정하는 메소드 
	 * 파라미터 : reportSubmitNo 담을 Model
	 * 리턴값: modifyReportSubmit
	 * modifyReportSubmit  Form
	 * modifyReportSubmit.jsp 
	 */
	@GetMapping("/loginCheck/modifyReportSubmit")
	String modifyReportSubmit(Model model, @RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// reportSubmitOne 리스트 model값으로 보내기 Service Call
		Map<String, Object> reportSubmitOne = reportSubmitService.reportSubmitOne(reportSubmitNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// 모델단에 reportSubmitOne을 addAttribute해서 폼으로 전달
		model.addAttribute("reportSubmitOne", reportSubmitOne);

		return "report/modifyReportSubmit";
	} // end modifyReportSubmit @GetMapping

	/*
	 * 제출한 과제 수정하는 메소드 
	 * 파라미터 : reportSubmitNo 담을 Model 
	 * 리턴값:reportSubmitListById
	 * modifyReportSubmit Action
	 * modifyReportSubmit.jsp 
	 */
	@PostMapping("/loginCheck/modifyReportSubmit")
	String modifyReportSubmit(@RequestParam("reportSubmitTitle") String reportSubmitTitle,
			@RequestParam("reportSubmitNo") int reportSubmitNo,
			@RequestParam("reportSubmitContent") String reportSubmitContent,
			@RequestParam("reportSubmitFilename") String reportSubmitFilename,
			@RequestParam("reportSubmitOriginName") String reportSubmitOriginName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitTitle + "<-- reportSubmitTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitContent + "<-- reportSubmitContent" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitFilename + "<-- reportSubmitFilename" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitOriginName + "<-- reportSubmitOriginName" + TeamColor.TEXT_RESET);

		// ReportSubmit 요청값 셋팅
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setReportSubmitContent(reportSubmitContent);
		reportSubmit.setReportSubmitTitle(reportSubmitTitle);
		reportSubmit.setReportSubmitNo(reportSubmitNo);
		// 요청값 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		ReportSubmitFile reportSubmitFile = new ReportSubmitFile();
		reportSubmitFile.setReportSubmitFilename(reportSubmitFilename);
		reportSubmitFile.setReportSubmitFileNo(reportSubmitNo);
		reportSubmitFile.setReportSubmitOriginName(reportSubmitOriginName);
		// 요청값 디버깅
		log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

		// Service Call
		String modifyReportSubmit = reportSubmitService.modifyReportSubmit(reportSubmit, reportSubmitFile);
		
		if(modifyReportSubmit != null) {
			// 디버깅 
			log.debug(TeamColor.PSY + "수정 성공" + TeamColor.TEXT_RESET);
		}

		// lectureSubjectListByStudent로 리다이렉트
		return "redirect:/loginCheck/lectureSubjectListByStudent";
	} // end modifyReportSubmit @PostMapping

	/*
	 * 제출한 과제 삭제하는 메소드 
	 * 파라미터 : reportSubmitNo 
	 * 리턴값 : reportSubmitListById
	 * reportSubmitListById.jsp
	 */
	@GetMapping("/loginCheck/removeReportSubmit")
	public String removeReportSubmit(RedirectAttributes redirectAttributes,
			@RequestParam("reportSubmitNo") int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@removeReportSubmit Controller" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// 과제 삭제 service call
		reportSubmitService.removeReportSubmit(reportSubmitNo);

		// lectureSubjectListByStudent로 리다이렉트
		return "redirect:/loginCheck/lectureSubjectListByStudent";
	} // end removeReportSubmit
}
