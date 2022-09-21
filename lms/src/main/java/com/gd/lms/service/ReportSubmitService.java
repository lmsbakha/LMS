package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitMapper;
import com.gd.lms.vo.Report;

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

	// 출제한 과제 상세보기 메소드
	// 파라미터 : Report
	// 리턴값 : int
	public Report getReportOne(int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// Mapper call
		Report getReportOne = reportSubmitMapper.selectReportOne(reportNo);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + getReportOne + "<-- getReportOne" + TeamColor.TEXT_RESET);

		return getReportOne;
	} // end getReportOne

	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	public List<Map<String, Object>> getReportListById(String accountId){
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// Mapper call
		List<Map<String,Object>> getReportListById = reportSubmitMapper.selectReportListById(accountId);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + getReportListById + "<-- getReportListById" + TeamColor.TEXT_RESET);
		
		return getReportListById;
	} // end getReportListById

}
