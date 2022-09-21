package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitMapper;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;

import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 박소연
 * 작성일 : 2022-09 ~
 * 과제 제출 Service
 * */

@Slf4j
@Transactional
@Service
public class ReportSubmitService {
	@Autowired
	// ReportSubmitMapper 객체 주입
	ReportSubmitMapper reportSubmitMapper;

	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	public List<Map<String, Object>> getReportListById(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// Mapper call
		List<Map<String, Object>> getReportListById = reportSubmitMapper.selectReportListById(accountId);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + getReportListById + "<-- getReportListById" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("getReportListById", getReportListById);

		return getReportListById;
	} // end getReportListById

	// 과제 제출하기 메소드
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	public int addReportSubmit(ReportSubmit reportSubmit) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		// Mapper call
		int addReportSubmit = reportSubmitMapper.insertReportSubmit(reportSubmit);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + addReportSubmit + "<-- addReport" + TeamColor.TEXT_RESET);

		return addReportSubmit;
	} // end addReportSubmit

}
