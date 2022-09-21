package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author  박소연
 * 작성일 : 2022-09 ~
 * 과제 제출 첨부파일 cMapper 
 * 기능 : 제출할 과제 첨부파일 첨부, 제출한 과제 첨부파일 수정하기, 제출한 과제 첨부파일 삭제하기
 */

@Mapper
public interface ReportSumbitFileMapper {

	// 과제 제출하기 첨부파일 업로드 메소드
	// 파라미터 : Report
	// 리턴값 : int
	int insertReportSubmitFile(int reportSubmitNo);
}
