package com.gd.lms.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ScheduleRestController {
	@Autowired private ScheduleService scheduleService;
	
	@GetMapping("/getScheduleOne")
	public Map<String,Object> getReferenceOne(@RequestParam(value = "scheduleNo") int scheduleNo) {
		
		// 디버깅
		log.debug(TeamColor.PCW + "ScheduleRestController getReferenceOne scheduleNo : " + scheduleNo + TeamColor.TEXT_RESET);
		
		// 서비스 실행
		Map<String,Object> map = scheduleService.getScheduleOne(scheduleNo);
		log.debug(TeamColor.PCW + "ScheduleRestController getReferenceOne map : " + map + TeamColor.TEXT_RESET);
		
		return map;
	}
}
