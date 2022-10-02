package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Report;
import com.gd.lms.vo.ReportSubmit;

@Mapper
public interface ReportMapper {
	
	/*
	 * 강의별 과제 리스트 조회하는 메소드
	 * 파라미터 : subjectName
	 * 리턴값 : List<Map<String, Object>>
	 * reportList.jsp
	 */
	List<Map<String, Object>> selectReportListBySubjectName(String subjectName);
	
	/*
	 * 학생용
	 * 제출기한을 넘기지 않은 출제된 과제 중 과제 제출 하지 않은 과제에 대한 정보를 추출하는 메소드 
	 * 파라미터 : accountId, subjectName
	 * 리턴값 : Map<String, Object> 
	 * reportListByStudent.jsp
	 */
	List<Map<String, Object>> selectReportListStateInfo(String accountId, String subjectName);

	/*
	 * 과제 출제하는 메소드
	 * 파라미터 : Report
	 * 리턴값 : int
	 * addReport Action
	 * addReport.jsp
	 */
	int insertReport(Report report);

	/*
	 * 출제한 과제 수정하는 메소드 
	 * 파라미터 : ReportNo
	 * 리턴값 : Report
	 * addReport Form
	 * addReport.jsp
	 */
	Report selectReportOne(int reportNo);
	
	/*
	 * 출제한 과제 수정하는 메소드 
	 * 파라미터 : Report
	 * 리턴값 : int
	 * addReport Action
	 * addReport.jsp
	 */
	int updateReport(Report report);

	/*
	 * 행정용 출제한 과제 삭제하는 메소드
	 * 파라미터 : reportNo
	 * 리턴값 : int
	 */
	int deleteReport(int reportNo);
}
