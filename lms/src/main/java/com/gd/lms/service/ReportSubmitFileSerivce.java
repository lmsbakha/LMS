package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitFileMapper;
import com.gd.lms.vo.ReportSubmitForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReportSubmitFileSerivce {
	@Autowired
	ReportSubmitFileMapper reportSubmitFileMapper;
	
	/*
	 * 과제 제출 파일 업로드 메소드 
	 * 파라미터 : ReportSubmitFile 
	 * 리턴값 : ReportSubmit
	 * addReportSubmit.jsp Action 
	 */
	public void addReportSubmitFile(ReportSubmitForm reportSubmitForm) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitForm + "<-- reportSubmitForm" + TeamColor.TEXT_RESET);
		
		// 요청값 받아오기
		String reportSubmitTitle = reportSubmitForm.getReportSubmitTitle();
		String reportSubmitContent = reportSubmitForm.getReportSubmitContent();
		int reportNo = reportSubmitForm.getReportNo();
		int reportSubmitNo = reportSubmitForm.getReportSubmitNo();
		int educationNo = reportSubmitForm.getEducationNo();
		String accountId = reportSubmitForm.getAccountId();
		MultipartFile file = reportSubmitForm.getReportSubmitFile();
		// 요청값 디버깅
		log.debug(TeamColor.PSY + reportSubmitTitle + "<-- reportSubmitTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitContent + "<-- reportSubmitContent" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + educationNo + "<-- educationNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + file + "<-- file" + TeamColor.TEXT_RESET);
		//int reportSubmitNo = reportSubmitForm.getReportSubmitNo();
		

	}
	
}
