package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Report;

@Mapper
public interface ReportSubmitMapper {

	// 학생이 제출한 과제 리스트 조회 메소드
	List<Map<String,Object>> selectReportListById(String accountId);

	// 출제한 과제 상세보기 메소드
	// 파라미터 : reportNo
	// 리턴값 : Report
	Report selectReportOne(int reportNo);

	// 과제 제출하기 메소드
	// 파라미터 : Report
	// 리턴값 : int
	int insertReportSubmit(Report report);
	
	// 제출한 과제 수정하는 메소드 action
	// 파라미터 : Report
	// 리턴값 : int
	int updateReportSubmit(Report report);

	// 제출한 과제 삭제하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : int
	int deleteReportSubmit(int reportNo);
}
