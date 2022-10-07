package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.ReportSubmit;
import com.gd.lms.vo.ReportSubmitFile;

/**
 * @author 박소연 작성일 : 2022-09 ~ 과제 제출 Mapper 기능 : 전체 과제 출제 리스트 조회, 제출한 과제 리스트 조회,
 *         출제한 과제 상세보기, 제출한 과제 수정하기, 제출한 과제 삭제하기
 */

@Mapper
public interface ReportSubmitMapper {
	
	/*
	 * 과제별 제출 리스트 조회 메소드
	 * 파라미터 : reportNo
	 * 리턴값 : List<ReportSubmit>
	 * reportSubmitList.jsp
	 */
	List<Map<String, Object>> selectReportListByReport(int reportNo);
	
	/* 
	 * 학생별 제출한 과제 리스트 조회 메소드
	 * 파라미터 : accountId, subjectName
	 * 리턴값 : List<Map<String,Object>>
	 */
	List<ReportSubmit> selectReportListById(String accountId, String subjectName);

	
	/*
	 * 제출한 과제별 정보 조회 메소드
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : ReportSubmit
	 * modifyReportSubmit.jsp
	 */
	ReportSubmit selectReportSubmitInfo(int reportSubmitNo);
	
	/* 
	 * 과제 제출하기 메소드 Form
	 * 파라미터: X
	 * 리턴값 : int
	 */
	ReportSubmit addReportSubmitForm(int reportNo);
	
	/*
	 * 과제 제출하기 메소드 Action
	 * 파라미터 : reportNo
	 * 리턴값 : int
	 */
	int insertReportSubmit(ReportSubmit reportSubmit);

	/*
	 * 과제 첨부파일 제출하기 메소드 Action
	 * 파라미터 : reportSubmitFile
	 * 리턴값 : int
	 */
	int insertReportSubmitFile(ReportSubmitFile reportSubmitFile);

	/*
	 * 제출한 과제 상세보기 메소드
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : Map<String, Object>
	 * modifyReportSubmit.jsp
     */	
	Map<String, Object> reportSubmitOne(int reportNo);

	/*
	 * 제출한 과제 수정하는 메소드 Action
	 * 파라미터 : ReportSubmit
	 * 리턴값 : int
	 */
	int updateReportSubmit(ReportSubmit reportSubmit);

	/*
	 * 제출한 과제 점수 수정하는 메소드 Form
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : int
	 * reportSubmitScore.jsp
	 */
	Map<String, Object> updateReportSubmitScoreForm(int reportSubmitNo);

	
	/*
	 * 제출한 과제 점수 수정하는 메소드 Action
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : int
	 */
	int updateReportScore(ReportSubmit reportSubmit);

	/*
	 * 관리자, 행정 가능
	 * 제출한 과제 삭제하는 메소드
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : int
	 * 
	 */
	int deleteReportSubmit(int reportSubmitNo);

}
