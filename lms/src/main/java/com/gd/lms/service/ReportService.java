package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureSubjectMapper;
import com.gd.lms.mapper.ReportMapper;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;

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
	 */
	public List<Map<String, Object>> getReportListStateInfo(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListStateInfo Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// Mapper Call
		List<Map<String, Object>> ReportListStateInfo = reportMapper.selectReportListStateInfo(accountId);
		// ReportListStateInfo 디버깅
		log.debug(TeamColor.PSY + ReportListStateInfo + "<-- ReportListStateInfo" + TeamColor.TEXT_RESET);
		
		return ReportListStateInfo;
	} // end getReportListStateInfo

	// 전체 과제 리스트 조회하는 메소드
	// 파라미터 : X
	// 리턴값 : reportList
	public List<Map<String, Object>> getReportList(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportList Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + "<--lectureName" + TeamColor.TEXT_RESET);

		// Mapper Call
		List<Map<String, Object>> reportList = reportMapper.selectReportList(accountId);
		// 디버깅
		log.debug(TeamColor.PSY + reportList + "<-- reportList" + TeamColor.TEXT_RESET);

		return reportList;
	} // end getReportList

	// addReport에 필요한 subjecteName, lectureStartDate , lectureEndDate 가져오기
	// 파라미터 : X
	// 리턴값 : List<LectureSubject>
	public List<LectureSubject> getlectureSubject() {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getlectureSubject Service" + TeamColor.TEXT_RESET);
		// Mapper call
		List<LectureSubject> lecureSubjectList = lectureSubjectMapper.selectLectureSubjectName();
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + lecureSubjectList + "<-- lecureSubjectList" + TeamColor.TEXT_RESET);

		return lecureSubjectList;
	}// end getlectureSubject

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
