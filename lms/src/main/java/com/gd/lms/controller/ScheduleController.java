package com.gd.lms.controller;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ScheduleService;
import com.gd.lms.vo.Schedule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ScheduleController {
	@Autowired private ScheduleService scheduleService;
	
	// 시간표 FORM
	@GetMapping("/loginCheck/scheduleList")
	public String getScheduleList(Model model, HttpSession session
								, @RequestParam(value = "year", defaultValue = "-1") int year
								, @RequestParam(value = "month", defaultValue = "-1") int month) {
		
		// session 값 받아오기
		String accountId = (String)session.getAttribute("sessionId");
		int accountLevel = (int)session.getAttribute("sessionLevel");
		// 디버깅
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) year : " + year + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) month : " + month + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) accountLevel : " + accountLevel + TeamColor.TEXT_RESET);
		
		
		// 서비스 호출
		Map<String,Object> scheduleMap = scheduleService.getScheduleList(year, month, accountId, accountLevel);
		// 디버깅
		log.debug(TeamColor.PCW + " GetMapping(/loginCheck/scheduleList) scheduleMap : " + scheduleMap + TeamColor.TEXT_RESET);
		
		// model값 담아주기
		model.addAttribute("scheduleList", scheduleMap.get("scheduleList"));
		model.addAttribute("lectureSubjectList", scheduleMap.get("lectureSubjectList"));
		model.addAttribute("lectureName", scheduleMap.get("lectureName"));
		model.addAttribute("year", scheduleMap.get("year"));
		model.addAttribute("month", scheduleMap.get("month"));
		model.addAttribute("lastDay", scheduleMap.get("lastDay"));
		model.addAttribute("startBlank", scheduleMap.get("startBlank"));
		model.addAttribute("endBlank", scheduleMap.get("endBlank"));
		model.addAttribute("totalBlank", scheduleMap.get("totalBlank"));
		
		return "/schedule/scheduleList";
	}
	
	// 시간표 추가 Action
	@PostMapping("/loginCheck/addSchedule")
	public String addSchedule(HttpSession session, @RequestParam(value="scheduleStartDate") Date scheduleStartDate
												 , @RequestParam(value="scheduleEndDate") Date scheduleEndDate
												 , @RequestParam(value="lectureSubjectNo") int lectureSubjectNo) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " PostMapping(/loginCheck/addSchedule) scheduleStartDate : " + scheduleStartDate + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " PostMapping(/loginCheck/addSchedule) scheduleEndDate : " + scheduleEndDate + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " PostMapping(/loginCheck/addSchedule) lectureSubjectNo : " + lectureSubjectNo + TeamColor.TEXT_RESET);
		int row = scheduleService.addSchedule(scheduleStartDate, scheduleEndDate, lectureSubjectNo);
		if( row == 1) {
			log.debug(TeamColor.PCW + " PostMapping(/loginCheck/addSchedule) 성공" + lectureSubjectNo + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PCW + " PostMapping(/loginCheck/addSchedule) 실패" + lectureSubjectNo + TeamColor.TEXT_RESET);
		}
		
		return "redirect:/loginCheck/scheduleList?year";
	
	}
	
	
	// 시간표 수정 Action
	@PostMapping("/loginCheck/modifySchedule")
	public String modifySchedule(Schedule schedule , @RequestParam(value="scheduleDateTwo") Date scheduleDateTwo
									,@RequestParam(value="lectureSubjetNo") int lectureSubjetNo) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " PostMapping(/loginCheck/modifySchedule) schedule : " + schedule + TeamColor.TEXT_RESET);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String scheduleDate = dateFormat.format(scheduleDateTwo);
		
		schedule.setScheduleDate(scheduleDate);
		schedule.setLectureSubjectNo(lectureSubjetNo);
		
		int row = scheduleService.modifySchedule(schedule);
		
		if(row == 1) {
			log.debug(TeamColor.PCW + " PostMapping(/loginCheck/modifySchedule) 수정 성공" + schedule + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PCW + " PostMapping(/loginCheck/modifySchedule) 수정 실패" + schedule + TeamColor.TEXT_RESET);
		}
		
		return "redirect:/loginCheck/scheduleList";
	}
	
	// 시간표 삭제 Action
	@GetMapping("/loginCheck/removeSchedule")
	public String removeSchedule(HttpSession session, @RequestParam(value="scheduleNo") int scheduleNo) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " PostMapping(/loginCheck/removeSchedule) schedule : " + scheduleNo + TeamColor.TEXT_RESET);
		
		int accountLevel = (int)session.getAttribute("sessionLevel");
		
		if(accountLevel <= 2) {  // 행정 or 총관리자가 아니라면 메인 페이지로 보내주기
			return "redirect:/logincheck/index";
		}
		
		int row = scheduleService.removeSchedule(scheduleNo);
		
		if(row == 1) {
			log.debug(TeamColor.PCW + " removeSchedule scheduleNo 삭제 성공" + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PCW + " removeSchedule scheduleNo 삭제 실패" + TeamColor.TEXT_RESET);
		}
		
		return "redirect:/loginCheck/scheduleList";
	}
			
			
}
