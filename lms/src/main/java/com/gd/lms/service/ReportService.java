package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureSubjectMapper;
import com.gd.lms.mapper.ReportMapper;
import com.gd.lms.vo.Report;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ReportService {
	// ReportMapper 객체 주입
	@Autowired
	ReportMapper reportMapper;

	// LectureSubjectMapper 객체 주입
	@Autowired
	LectureSubjectMapper lectureSubjectMapper;

	/*
	 * 제출기한을 넘기지 않은 출제된 과제 중 과제 제출 하지 않은 과제에 대한 정보를 추출하는 메소드 
	 * 파라미터 : educationNo 
	 * 리턴값 : List<Map<String,Object>>
	 * reportListByStudent.jsp
	 */
	public List<Map<String, Object>> getReportListStateInfo(String accountId, String subjectName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListStateInfo Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);
		
		// Mapper Call
		List<Map<String, Object>> ReportListStateInfo = reportMapper.selectReportListStateInfo(accountId, subjectName);
		// ReportListStateInfo 디버깅
		log.debug(TeamColor.PSY + ReportListStateInfo + "<-- ReportListStateInfo" + TeamColor.TEXT_RESET);

		return ReportListStateInfo;
	} // end getReportListStateInfo

	/*
	 * 강의별 과제리스트 조회하는 메소드 
	 * 파라미터 : lectureName 
	 * 리턴값 : List<Map<String, Object>> 과제 리스트
	 * reportList.jsp
	 */
	public List<Map<String, Object>> getReportListBySubjectName(String subjectName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListBySubjectName Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + subjectName + "<--subjectName" + TeamColor.TEXT_RESET);

		// reportMapper Call
		List<Map<String, Object>> reportList = reportMapper.selectReportListBySubjectName(subjectName);
		// reportList 디버깅
		log.debug(TeamColor.PSY + reportList + "<-- reportList" + TeamColor.TEXT_RESET);
		
		return reportList;
	} // end getReportListBySubjectName

	/*
	 * 강사용 강의별 과제 리스트 조회하는 메소드
	 * 파라미터 : lectureName 
	 * 리턴값 : List<Map<String, Object>> 과제 리스트
	 */
	public List<Map<String, Object>> getReportList(String lectureName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportList Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + "<--lectureName" + TeamColor.TEXT_RESET);

		// Mapper Call
		List<Map<String, Object>> reportList = reportMapper.selectReportListBySubjectName(lectureName);
		// 디버깅
		log.debug(TeamColor.PSY + reportList + "<-- reportList" + TeamColor.TEXT_RESET);

		return reportList;
	} // end getReportList


	// 과제 출제하는 메소드
	// 파라미터 : Report
	// 리턴값 : int
	public int addReport(Report report) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReport Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + report + "<-- paramReport" + TeamColor.TEXT_RESET);

		// Mapper call
		int addReport = reportMapper.insertReport(report);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + addReport + "<-- addReport" + TeamColor.TEXT_RESET);

		return addReport;
	} // end addReport

	// 출제한 과제 수정하는 메소드
	// getReportOne Form
	// 파라미터 : Report
	// 리턴값 : int
	public Report getReportOne(int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// Mapper call
		Report getReportOne = reportMapper.selectReportOne(reportNo);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + getReportOne + "<-- getReportOne" + TeamColor.TEXT_RESET);

		return getReportOne;
	} // end getReportOne

	// 출제한 과제 수정하는 메소드
	// modifyReport Action
	// 파라미터 : Report
	// 리턴값 : int
	public int modifyReport(Report paramReport) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReport Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);

		// Mapper call
		int modifyReport = reportMapper.updateReport(paramReport);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + modifyReport + "<-- addReport" + TeamColor.TEXT_RESET);

		return modifyReport;
	} // modifyReport

	// 행정용 출제한 과제 삭제하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : int
	public int removeReport(int paramReportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@removeReport Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paramReportNo + "<-- paramReportNo" + TeamColor.TEXT_RESET);

		// Mapper call
		int removeReport = reportMapper.deleteReport(paramReportNo);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + removeReport + "<-- deleteReport" + TeamColor.TEXT_RESET);

		return removeReport;
	} // removeReport
}
