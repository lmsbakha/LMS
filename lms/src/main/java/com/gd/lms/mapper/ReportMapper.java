package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Report;

@Mapper
public interface ReportMapper {

	// 학생 과제를 작성/읽고/수정/삭제
	// 강사,행정는 과제출제를 할 수 있고 읽고 수정, 삭제
	
	/*
	 * // 전체 과제 리스트 조회하는 메소드 // 파라미터 : X // 리턴값 : List<Map<String, Object>>
	 * List<Map<String, Object>> selectReportList(M);
	 */
	
	
	// 전체 과제 리스트 조회하는 메소드 
	// 파라미터 : X 
	// 리턴값 : List<Map<String, Object>>
	List<Report> selectReportList(Map<String, Object> map);
	
	
	// report 전체 수를 추출하는 메소드
	// 파라미터 : X
	// 리턴값 : int
	int selectReportTotalCount();
	
	// 과제 

	// 댓글 달기

	
	
}
