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
	// ScheduleService 객체 주입
	@Autowired 
	private ScheduleService scheduleService;
	
	
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
		
		return "redirect:/loginCheck/index";
	
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
		
		return "redirect:/loginCheck/index";
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
		
		return "redirect:/loginCheck/index";
	}
			
			
}
