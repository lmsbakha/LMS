package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.ReportSubmitFile;

/**
 * @author 박소연 작성일 : 2022-09 ~ 과제 제출 첨부파일 Mapper 기능 : 제출할 과제 첨부파일 첨부, 제출한 과제
 *         첨부파일 수정하기, 제출한 과제 첨부파일 삭제하기
 */

@Mapper
public interface ReportSubmitFileMapper {

	// 과제 제출하기 첨부파일 업로드 메소드
	// 파라미터 : ReportSubmitFile
	// 리턴값 : int
	int insertReportSubmitFile(ReportSubmitFile reportSubmitFile);

	// 제출한 과제 상세 조회하기 메소드
	// modifyReportSubmit Form
	// 파라미터 : reportSubmitNo
	// 리턴값 : ReportSubmit
	ReportSubmitFile selectReportSubmitFile(int reportSubmitNo);

	// 과제 수정하기 첨부파일 업로드 메소드
	// modifyReportSubmit Action
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	int updateReportSubmitFile(ReportSubmitFile reportSubmitFile);
	
	// 제출한 과제 첨부파일 삭제하기 메소드
	// 파라미터 : reportSubmitNo
	// 리턴값 : X
	int deleteReportSubmitFile(int reportSubmitNo);

}
