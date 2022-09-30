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
	 * 강의 과제 조회하는 메소드
	 * 
	 * 
	 */
	// report 전체 과제 수를 추출하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : int
	int selectReportTotalCount();

	// reportSubmit와 관련된 subjectName 가져오기
	// 파라미터 : reportNo
	// 리턴값 : List<LectureSubject>
	List<LectureSubject> selectLectureSubject(int reportNo);
	
	/*
	 * 학생용
	 * 제출기한을 넘기지 않은 출제된 과제 중 과제 제출 하지 않은 과제에 대한 정보를 추출하는 메소드 
	 * 파라미터 : accountId
	 * 리턴값 : Map<String, Object> 
	 */
	List<Map<String, Object>> selectReportListStateInfo(String accountId);
	
	// 과제 출제하는 메소드
	// 파라미터 : Report
	// 리턴값 : int
	int insertReport(Report report);

	// 출제한 과제 수정하는 메소드 form
	// 파라미터 : reportNo
	// 리턴값 : Report
	Report selectReportOne(int reportNo);

	// 출제한 과제 수정하는 메소드 action
	// 파라미터 : Report
	// 리턴값 : int
	int updateReport(Report report);

	// 행정용 출제한 과제 삭제하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : int
	int deleteReport(int reportNo);
}
