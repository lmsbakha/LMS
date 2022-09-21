package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.ReportSubmit;

/**
 * @author  박소연
 * 작성일 : 2022-09 ~
 * 과제 제출 Mapper 
 * 기능 : 전체 과제 출제 리스트 조회, 제출한 과제 리스트 조회, 출제한 과제 상세보기, 제출한 과제 수정하기, 제출한 과제 삭제하기
 */

@Mapper
public interface ReportSubmitMapper {

	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	List<Map<String,Object>> selectReportListById(String accountId);

	// 과제 제출하기 메소드
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	int insertReportSubmit(ReportSubmit reportSubmit);
	
	// 제출한 과제 수정하는 메소드 action
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	int updateReportSubmit(ReportSubmit reportSubmit);

	// 제출한 과제 삭제하는 메소드
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	int deleteReportSubmit(int reportSubmitNo);
}
