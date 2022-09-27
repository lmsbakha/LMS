package com.gd.lms.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureSubjectMapper;
import com.gd.lms.mapper.ReportSubmitFileMapper;
import com.gd.lms.mapper.ReportSubmitMapper;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.ReportSubmit;
import com.gd.lms.vo.ReportSubmitFile;
import com.gd.lms.vo.ReportSubmitForm;

import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 박소연
 * 작성일 : 2022-09 ~
 * 과제 제출 Service
 * */

@Slf4j
@Transactional
@Service
public class ReportSubmitService {
	@Autowired
	// ReportSubmitMapper 객체 주입
	ReportSubmitMapper reportSubmitMapper;

	@Autowired
	// ReportSubmitFileMapper 객체 주입
	ReportSubmitFileMapper reportSubmitFileMapper;

	// 학생별 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	public Map<String, Object> getReportListById(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListById Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// ReportMapper에 넣어줄 매개변수 설정
		Map<String, Object> paramMap = new HashMap<>();
		// paramMap에 값 넣어주기
		paramMap.put("accountId", accountId);

		// Mapper call
		Map<String, Object> reportSubmitListById = reportSubmitMapper.selectReportListById(paramMap);
		// 파마리터 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
		// Mapper에서 받아온 ReportSubmitListById 값 디버깅
		log.debug(TeamColor.PSY + reportSubmitListById.toString() + "<-- ReportSubmitListById" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("reportSubmitListById", reportSubmitListById);

		return reportSubmitListById;
	} // end getReportListById

	// 강좌별 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	public List<ReportSubmit> getReportListBySubject(String lectureName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListBySubject Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + lectureName + "<-- educationNo" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// ReportMapper에 넣어줄 매개변수 설정
		Map<String, Object> paramMap = new HashMap<>();
		// paramMap에 값 넣어주기
		paramMap.put("lectureName", lectureName);
		// lectureName 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// Mapper call
		List<ReportSubmit> ReportSubmitListBySubject = reportSubmitMapper.selectReportListBySubject(lectureName);
		// Mapper에서 받아온 ReportSubmitListById 값 디버깅
		log.debug(TeamColor.PSY + ReportSubmitListBySubject.toString()
				+ "<-- ReportReportSubmitListBySubjectSubmitListById" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("ReportSubmitListBySubject", ReportSubmitListBySubject);

		return ReportSubmitListBySubject;
	} // end getReportSubmitListBySubject

	// 과제 제출하는 메소드
	// addReportSubmit Form
	// 파라미터 : reportNo
	// 리턴값 : ReportSubmit
	public ReportSubmit addReportSubmitForm(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		// Mapper call
		ReportSubmit ReportSubmit = reportSubmitMapper.addReportSubmitForm(reportSubmitNo);
		// Mapper에서 받아온 ReportSubmitOne 값 디버깅
		log.debug(TeamColor.PSY + ReportSubmit + "<-- ReportSubmit" + TeamColor.TEXT_RESET);

		return ReportSubmit;
	} // end addReportSubmitForm

	// 과제 제출하는 메소드
	// addReportSubmit Action
	// 파라미터 : ReportSubmit, ReportSubmitFile
	// 리턴값 : ReportSubmit
	public void addReportSubmit(ReportSubmitForm reportSubmitForm) {// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitForm + "<-- reportSubmitForm" + TeamColor.TEXT_RESET);

		String reportSubmitTitle = reportSubmitForm.getReportSubmitTitle();
		String reportSubmitContent = reportSubmitForm.getReportSubmitContent();
		int reportNo = reportSubmitForm.getReportNo();
		int educationNo = reportSubmitForm.getEducationNo();
		String accountId = reportSubmitForm.getAccountId();
		MultipartFile file = reportSubmitForm.getReportSubmitFile();
		// 요청값 디버깅
		log.debug(TeamColor.PSY + reportSubmitTitle + "<-- reportSubmitTitle" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportSubmitContent + "<-- reportSubmitContent" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + educationNo + "<-- educationNo" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + file + "<-- file" + TeamColor.TEXT_RESET);

		// ReportSubmit 입력
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setAccountId(accountId);
		reportSubmit.setEducationNo(educationNo);
		reportSubmit.setReportNo(reportNo);
		reportSubmit.setReportSubmitContent(reportSubmitContent);
		reportSubmit.setReportSubmitTitle(reportSubmitTitle);
		// reportSubmit 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<--reportSubmit" + TeamColor.TEXT_RESET);

		// insertReportSubmit Mapper Call
		int reportsubmitResult = reportSubmitMapper.insertReportSubmit(reportSubmit);
		// reportSubmit 디버깅
		log.debug(TeamColor.PSY + reportsubmitResult + "<--reportsubmitResult" + TeamColor.TEXT_RESET);

		// 파일이 업로드 되었다면
		if (file != null) {
			// file 디버깅
			log.debug(TeamColor.PSY + file + "<--file" + TeamColor.TEXT_RESET);
			ReportSubmitFile reportSubmiFile = new ReportSubmitFile();
			reportSubmiFile.setReportSubmitNo(reportNo);
			// reportSubmiFile 디버깅
			log.debug(TeamColor.PSY + reportSubmiFile + "<--reportSubmiFile" + TeamColor.TEXT_RESET);

			// 랜던이름 생성 API
			String fileName = UUID.randomUUID().toString();
			// 중복되지않는 문자이름 직접 생성 or API
			reportSubmiFile.setReportSubmitFilename(fileName);

			// 원본이름
			String reportSubmitOriginName = file.getOriginalFilename();
			// 마지막 점 위치
			int ext = reportSubmitOriginName.lastIndexOf(".");
			// 오리지널이름 뒤에서 점까지 자르기
			String fileExt = reportSubmitOriginName.substring(ext + 1);
			log.debug(TeamColor.PSY + fileExt + "<--fileExt" + TeamColor.TEXT_RESET);

			// 오리지널 이름
			reportSubmiFile.setReportSubmitOriginName(fileExt);
			// 첨부파일 타입
			reportSubmiFile.setReportSubmitFileType(fileExt);
			// 첨부파일 사이즈
			reportSubmiFile.setReportSubmitFileSize(file.getSize());
			// reportSubmit 디버깅
			log.debug(TeamColor.PSY + reportSubmiFile + "<--reportSubmiFile" + TeamColor.TEXT_RESET);
			// insertReportSubmitFile Mapper Call
			int reportSubmitFileResult = reportSubmitMapper.insertReportSubmitFile(reportSubmiFile);
			// row 디버깅
			log.debug(TeamColor.PSY + reportSubmitFileResult + "<--reportSubmitFileResult" + TeamColor.TEXT_RESET);

			// 파일저장
			File f = new File("C:\\Users\\Park\\git-LMS\\lms\\src\\main\\webapp\\file\\reportSubmitFile\\" + fileName
					+ "." + fileExt);
			// f 디버깅 C:\Users\Park\git-LMS\lms\src
			log.debug(TeamColor.PSY + f + "<--f" + TeamColor.TEXT_RESET);

			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				// Transactional 구동조건 -> 예외 발생
				throw new RuntimeException();
			}
		}
	} // end addReportSubmit

	// 제출한 과제 상세보기 메소드
	// reportSubmitOne
	// 파라미터 : reportSubmitNo
	// 리턴값 :
	public  List<ReportSubmit> reportSubmitOne(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// Mapper에 넣어줄 매개변수 설정
		Map<String, Object> paramMap = new HashMap<>();
		// paramMap에 값 넣어주기
		paramMap.put("reportSubmitNo", paramMap);

		// Mapper call
		List<ReportSubmit> reportSubmitOne = reportSubmitMapper.ReportSubmitOne(paramMap);
		// Mapper에서 받아온 reportSubmitOne값 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne.toString() + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("reportSubmitOne", reportSubmitOne);

		return reportSubmitOne;

	} // end ReportSubmitOne

	// 제출한 과제 수정하는 메소드
	// modifyReportSubmit Action
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	public int modifyReportSubmit(ReportSubmit reportSubmit) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		// Mapper call
		int modifyReportSubmit = reportSubmitMapper.updateReportSubmit(reportSubmit);
		// Mapper에서 받아온 modifyReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		return modifyReportSubmit;
	} // end modifyReportSubmit

	// 제출한 과제 점수 수정하는 메소드
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	public int modifyReportScore(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// Mapper call
		int modifyReportScore = reportSubmitMapper.updateReportScore(reportSubmitNo);
		// Mapper에서 받아온 removeReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + modifyReportScore + "<-- modifyReportScore" + TeamColor.TEXT_RESET);

		return modifyReportScore;
	}

	// 제출한 과제 삭제하는 메소드
	// 파라미터 : reportSubmitNo
	// 리턴값 : int
	public int removeReportSubmit(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// Mapper call
		int removeReportSubmit = reportSubmitMapper.deleteReportSubmit(reportSubmitNo);
		// Mapper에서 받아온 removeReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + removeReportSubmit + "<-- removeReportSubmit" + TeamColor.TEXT_RESET);

		return removeReportSubmit;
	} // end removeReportSubmit

}
