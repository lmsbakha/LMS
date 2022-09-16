package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Map<String, Object> getReportList(int currentPage, int rowPerPage) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + currentPage + "<-- currentPage" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + rowPerPage + "<-- rowPerPage" + TeamColor.TEXT_RESET);
		
		// ReportMapper에 넣어줄 매개변수 설정
		Map<String, Object> paramMap = new HashMap<>();
		
		// 시작하는 행 구하기
		int beginRow = (currentPage-1) * rowPerPage;
		
		// paramMap에 값 넣어주기
		paramMap.put("beginRow", beginRow); 
		paramMap.put("rowPerPage", rowPerPage);
		
		// ReportMapper 실행
		List<Report> reportList = reportMapper.selectReportList(paramMap);
		
		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();
		
		// 마지막 페이지 변수
		int lastPage = 0;
		// 총 과제 수
		int totalCount = reportMapper.selectReportTotalCount();
		
		// 마지막 페이지 구하기
		lastPage = totalCount / rowPerPage;
		
		// rowPerPage = 한 페이지당 보여질 과제 개수
		// rowPerPage로 나눠 떨어지지 않는다면 마지막 페이지에 +1
		if(totalCount % rowPerPage != 0) {
			lastPage += 1;
		}
		// returnMap에 값 넣어주기
		returnMap.put("reportList", reportList);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}
}

// 전체 과제 리스트 조회하는 메소드
// 파라미터 : X
// 리턴값 : List<Map<String, Object>>
/*
 * public List<Report> getReportList(){ List<Report> reportList =
 * reportMapper.selectReportList(); // Mapper에서 받아온 reportList 값 디버깅
 * log.debug(TeamColor.PSY + reportList + "<-- account" + TeamColor.TEXT_RESET);
 * 
 * return reportList; }
 */
