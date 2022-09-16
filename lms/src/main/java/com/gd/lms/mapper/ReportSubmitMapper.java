package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportSubmitMapper {
	// 학생 과제 제출 전체리스트 조회하는 메소드
	List<Map<String, Object>> selectReportSubjectList();
	
	// 학생별 과제 제출 리스트 조회하는 메소드
	// 파라미터 : memberId
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> selectReportSubjectListById(String memberId);
}
