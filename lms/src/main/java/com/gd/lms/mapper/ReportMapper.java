package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.gd.lms.vo.Report;

@Mapper
public interface ReportMapper {

	// 학생 과제를 작성/읽고/수정/삭제
	// 강사,행정는 과제출제를 할 수 있고 읽고 수정, 삭제

	// 전체 과제 리스트 조회하는 메소드 
	// 파라미터 : Map<String, Object> map  currentPage, rowPerPage
	// 리턴값 : List<Report>
	List<Report> selectReportList(Map<String, Object> map);
	
	// report 전체 과제 수를 추출하는 메소드
	// 파라미터 : X
	// 리턴값 : int
	int selectReportTotalCount();
	
	// 과제 출제하는 메소드
	// 파라미터 : Report
	// 리턴값 : int
	int insertReport(Report report);
	
	// 과제 수정하는 메소드
	// 파라미터 : Report
	// 리턴값 : int
	int updateReport(Report report);
	
	// 행정용 과제 삭제 

	
	
}
