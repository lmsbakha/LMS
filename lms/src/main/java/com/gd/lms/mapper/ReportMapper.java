package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Report;

@Mapper
public interface ReportMapper {
	
	// 강좌별 과제 리스트 조회하는 메소드
	// 파라미터 : lectureName
	// 리턴값 : List<Report>
	List<Report> selectReportList();

	// report 전체 과제 수를 추출하는 메소드
	// 파라미터 : reportNo
	// 리턴값 : int
	int selectReportTotalCount();

	// reportSubmit와 관련된 subjectName 가져오기
	// 파라미터 : reportNo
	// 리턴값 : List<LectureSubject>
	List<LectureSubject> selectLectureSubject(int reportNo);

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
