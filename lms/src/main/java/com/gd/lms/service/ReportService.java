package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
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

	// 전체 과제 리스트 조회하는 메소드
	// 파라미터 : currentPage , rowPerPage
	// 리턴값 boardList, lastPage
	public List<Report> getReportList(int currentPage, int rowPerPage) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Service" + TeamColor.TEXT_RESET);
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

		// 마지막 페이지 변수
		int lastPage = 0;
		// 총 과제 수
		int totalCount = reportMapper.selectReportTotalCount();
		// 디버깅
		log.debug(TeamColor.PSY + totalCount + "<-- totalCount" + TeamColor.TEXT_RESET);
		// 마지막 페이지 구하기
		lastPage = totalCount / rowPerPage;
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

	// 과제 출제하는 메소드
	// 파라미터 : Report
	// 리턴값 : int
	public int addReport(Report report, @RequestParam(value = "Report") Report paramReport) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@Service" + TeamColor.TEXT_RESET);
		
		// 리턴값 받아올 변수
		int addReport = 0;
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paramReport + "<-- paramReport" + TeamColor.TEXT_RESET);
		// Mapper call
		addReport = reportMapper.insertReport(paramReport);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + report + "<-- report" + TeamColor.TEXT_RESET);

		return addReport;
	} // end addReport
}
