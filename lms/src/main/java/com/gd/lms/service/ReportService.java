package com.gd.lms.service;

import java.util.HashMap;
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

	// 전체 과제 리스트 조회하는 메소드
	// 파라미터 : currentPage , rowPerPage
	// 리턴값 : boardList, lastPage
	public List<Report> getReportList(int currentPage, int rowPerPage) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportList Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + rowPerPage + "<-- rowPerPage" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// ReportMapper에 넣어줄 매개변수 설정
		Map<String, Object> paramMap = new HashMap<>();

		// 시작하는 행 구하기
		int beginRow = (currentPage - 1) * rowPerPage;
		// beginRow값 디버깅
		log.debug(TeamColor.PSY + paramMap.get("beginRow") + "<-- beginRow" + TeamColor.TEXT_RESET);

		// paramMap에 값 넣어주기
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);

		// ReportMapper 실행
		List<Report> reportList = reportMapper.selectReportList(paramMap);
		// 파마리터 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
		// 디버깅
		log.debug(TeamColor.PSY + reportList.toString() + "<-- reportList" + TeamColor.TEXT_RESET);

		// 총 과제 수
		int totalCount = reportMapper.selectReportTotalCount();
		// 디버깅
		log.debug(TeamColor.PSY + totalCount + "<-- totalCount" + TeamColor.TEXT_RESET);
		
		// 마지막 페이지 구하기
		int lastPage = totalCount / rowPerPage;
		// 디버깅
		log.debug(TeamColor.PSY + lastPage + "<-- lastPage" + TeamColor.TEXT_RESET);
		
		// rowPerPage = 한 페이지당 보여질 과제 개수
		// rowPerPage로 나눠 떨어지지 않는다면 마지막 페이지에 +1
		if (totalCount % rowPerPage != 0) {
			lastPage += 1;
		}
		
		// list에 값 넣어주기
		returnMap.put("reportList", reportList);
		returnMap.put("lastPage", lastPage);
		// 리턴값 디버깅
		log.debug(TeamColor.PSY + returnMap.get("reportList") + "<-- reportdList" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + returnMap.get("lastPage") + "<-- lastPage" + TeamColor.TEXT_RESET);

		return reportList;
	} // end getReportList

	// addReport에 필요한 subjecteName, lectureStartDate , lectureEndDate 가져오기
	// 파라미터 : X
	// 리턴값 : List<LectureSubject>
	public  List<LectureSubject>getlectureSubject() {
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

	// 출제한 과제 수정하는 메소드 폼
	// 파라미터 : reportNo
	// 리턴값 : Report
	public Report getReportOne(int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// Mapper call
		Report  getReportOne = reportMapper.selectReportOne(reportNo);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + getReportOne + "<-- getReportOne" + TeamColor.TEXT_RESET);

		return getReportOne;
	} // end getReportOne

	// 출제한 과제 수정하는 메소드 액션
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
