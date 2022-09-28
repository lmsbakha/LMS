package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AttendanceMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AttendanceService {
	// AttendanceMapper 객체 주입
	@Autowired
	private AttendanceMapper attendanceMapper;

	// 강사가 강의하는 강좌의 학생 출석부
	// 파라미터 :  accountId, lectureName
	// 리턴값 : List<Map<String,Object>>
	public List<Map<String, Object>> getAttendanceListByTeacher(String accountId, String lectureName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);
		
		// 파라미터 변수 셋팅
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("accountId", accountId);
		paramMap.put("lectureName", lectureName);
		
		// Mapper에서 출석부 리스트 받아오기
		List<Map<String, Object>> attendanceList = attendanceMapper.selectAttendanceListByTeacher(paramMap);
		// 디버깅
		log.debug(TeamColor.PSJ + attendanceList + "<-- attendanceList" + TeamColor.TEXT_RESET);
		
		return attendanceList;
	}
}
