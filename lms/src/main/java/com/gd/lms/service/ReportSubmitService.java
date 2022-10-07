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
import com.gd.lms.mapper.ReportSubmitFileMapper;
import com.gd.lms.mapper.ReportSubmitMapper;
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

	/*
	 * 학생별 제출한 과제 리스트 조회 메소드 
	 * 파라미터 : accountId, subjectName 
	 * 리턴값 : List<Map<String,Object>>
	 * reportSubmitListById.jsp
	 */
	public List<ReportSubmit> getReportListById(String accountId, String subjectName) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListById Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);

		// reportSubmitMapper call
		List<ReportSubmit> reportSubmitListById = reportSubmitMapper.selectReportListById(accountId, subjectName);
		// reportSubmitMapper에서 받아온 ReportSubmitListById 값 디버깅
		log.debug(TeamColor.PSY + reportSubmitListById.toString() + "<-- ReportSubmitListById" + TeamColor.TEXT_RESET);

		return reportSubmitListById;
	} // end getReportListById

	/*
	 * 제출한 과제별 정보 조회 메소드
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : ReportSubmit
	 * modifyReportSubmit.jsp -> 보류
	 */
	public ReportSubmit getReportSubmitInfo(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportSubmitInfo Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		
		// Mapper Call
		ReportSubmit reportSubmitInfo = reportSubmitMapper.selectReportSubmitInfo(reportSubmitNo);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmitInfo + "<-- reportSubmitInfo" + TeamColor.TEXT_RESET);
		
		return reportSubmitInfo;
	} // end getReportSubmitInfo

	/*
	 * 과제별 제출한 과제 리스트 조회 메소드 
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : List<Map<String, Object>>
	 * 제출한 과제 리스트 reportSubmitList.jsp
	 */
	public List<Map<String, Object>> getReportListByReport(int reportNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportListByReport Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportNo + "<-- reportNo" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// reportSubmitMapper Call
		List<Map<String, Object>> reportSubmitList = reportSubmitMapper.selectReportListByReport(reportNo);
		// reportSubmitList 디버깅
		log.debug(TeamColor.PSY + reportSubmitList + "<-- reportSubmitList" + TeamColor.TEXT_RESET);

		returnMap.put("reportSubmitList", reportSubmitList);
		
		return reportSubmitList;
	} // end getReportListByReport

	/*
	 * 과제 제출하는 메소드 
	 * 파라미터 : ReportSubmit, ReportSubmitFile 
	 * 리턴값 : ReportSubmit
	 * addReportSubmit.jsp Action 
	 */
	public void addReportSubmit(ReportSubmitForm reportSubmitForm) {
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

		// ReportSubmit 입력
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setAccountId(accountId);
		reportSubmit.setEducationNo(educationNo);
		reportSubmit.setReportNo(reportNo);
		reportSubmit.setReportSubmitNo(reportSubmitNo);
		reportSubmit.setReportSubmitContent(reportSubmitContent);
		reportSubmit.setReportSubmitTitle(reportSubmitTitle);
		reportSubmit.setReportSubmitNo(reportNo);
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
			reportSubmiFile.setReportSubmitNo(reportSubmit.getReportSubmitNo());
			// reportSubmiFile 디버깅
			log.debug(TeamColor.PSY + reportSubmiFile + "<--reportSubmiFile" + TeamColor.TEXT_RESET);

			// 랜던이름 생성 API
			String fileName = UUID.randomUUID().toString();
			// 중복되지않는 문자이름 직접 생성 or API
			reportSubmiFile.setReportSubmitFilename(fileName);

			// 원본이름
			String reportSubmitOriginName = file.getOriginalFilename();
			// 디버깅
			log.debug(TeamColor.PSY + reportSubmitOriginName + "<--reportSubmitOriginName" + TeamColor.TEXT_RESET);
			// 마지막 점 위치
			int ext = reportSubmitOriginName.lastIndexOf(".");
			// 디버깅
			log.debug(TeamColor.PSY + ext + "<--ext" + TeamColor.TEXT_RESET);
			// 오리지널이름 뒤에서 점까지 자르기
			String fileExt = reportSubmitOriginName.substring(ext + 1);
			// 디버깅
			log.debug(TeamColor.PSY + fileExt + "<--fileExt" + TeamColor.TEXT_RESET);

			// 오리지널 이름 구하기
			String originName = reportSubmitOriginName.substring(reportSubmitOriginName.length() - ext,
					reportSubmitOriginName.length());
			// 디버깅
			log.debug(TeamColor.PSY + originName + "<--originName" + TeamColor.TEXT_RESET);

			// 오리지널 이름
			reportSubmiFile.setReportSubmitOriginName(originName);
			// 첨부파일 타입
			reportSubmiFile.setReportSubmitFileType(fileExt);
			// 첨부파일 사이즈
			reportSubmiFile.setReportSubmitFileSize(file.getSize());
			// reportSubmiFile 디버깅
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

	/*
	 * 제출한 과제 상세보기 메소드 
	 * 파라미터 : reportSubmitNo 
	 * 리턴값 : Map<String, Object>
	 */
	public Map<String, Object> reportSubmitOne(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmitOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// reportSubmitMapper call
		Map<String, Object> reportSubmitOne = reportSubmitMapper.reportSubmitOne(reportSubmitNo);
		// reportSubmitMapper에서 받아온 reportSubmitOne값 디버깅
		log.debug(TeamColor.PSY + reportSubmitOne + "<-- reportSubmitOne" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("reportSubmitOne", reportSubmitOne);

		return reportSubmitOne;
	} // end ReportSubmitOne

	/*
	 * 제출한 과제 수정하는 메소드 
	 * modifyReportSubmit Action 
	 * 파라미터 : ReportSubmit,
	 * ReportSubmitFile 리턴값 : X
	 */
	public String modifyReportSubmit(ReportSubmit paramReportSubmit, ReportSubmitFile paramReportSubmitFile) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paramReportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + paramReportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

		// 요청값 받아오기
		// ReportSubmit 입력
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setReportSubmitContent(paramReportSubmit.getReportSubmitContent());
		reportSubmit.setReportSubmitNo(paramReportSubmit.getReportSubmitNo());
		reportSubmit.setReportSubmitTitle(paramReportSubmit.getReportSubmitTitle());
		// reportSubmit 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<--reportSubmit" + TeamColor.TEXT_RESET);

		// reportSubmitMapper call
		int modifyReportSubmit = reportSubmitMapper.updateReportSubmit(reportSubmit);
		// reportSubmitMapper에서 받아온 modifyReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + modifyReportSubmit + "<-- modifyReportSubmit" + TeamColor.TEXT_RESET);

		// ReportSubmitFile 요청값 받아오기
		String reportSubmitFilename = paramReportSubmitFile.getReportSubmitFilename();
		String orignFilename = paramReportSubmitFile.getReportSubmitOriginName();

		// ReportSubmit 입력
		ReportSubmitFile reportSubmiFile = new ReportSubmitFile();
		reportSubmiFile.setReportSubmitNo(reportSubmit.getReportSubmitNo());
		reportSubmiFile.setReportSubmitFilename(reportSubmitFilename);
		reportSubmiFile.setReportSubmitOriginName(orignFilename);
		// 디버깅
		log.debug(TeamColor.PSY + reportSubmiFile + "<--reportSubmiFile" + TeamColor.TEXT_RESET);

		// reportSubmitMapper call
		int modifyReportSubmitFile = reportSubmitFileMapper.updateReportSubmitFile(reportSubmiFile);
		// modifyReportSubmitFile 디버깅
		log.debug(TeamColor.PSY + modifyReportSubmitFile + "<--modifyReportSubmitFile" + TeamColor.TEXT_RESET);

		return "lectureSubjectListByStudent";
	} // end modifyReportSubmit


	/*
	 * 제출한 과제 점수 수정하는 메소드 Form
	 * 파라미터 : reportSubmitNo
	 * 리턴값 : reportSubmit
	 * reportSubmitScore.jsp
	 */
	public Map<String, Object> modifyReportSubmitScoreForm(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportSubmitScoreForm Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		
		// Mapper Call
		Map<String, Object> reportSubmit = reportSubmitMapper.updateReportSubmitScoreForm(reportSubmitNo);
		// reportSubmitMapper에서 받아온 reportSubmit 값 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);
		
		return reportSubmit;
	} // end modifyReportSubmitScoreForm
	
	/*
	 * 제출한 과제 점수 수정하는 메소드 
	 * modifyReportScore Action
	 * 파라미터 : reportSubmitNo 
	 * 리턴값 : int
	 * modifyReportScore.jsp
	 */
	public int modifyReportScore(ReportSubmit reportSubmit) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@modifyReportScore Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);

		// reportSubmitMapper call
		int modifyReportScore = reportSubmitMapper.updateReportScore(reportSubmit);
		// reportSubmitMapper에서 받아온 removeReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + modifyReportScore + "<-- modifyReportScore" + TeamColor.TEXT_RESET);

		return modifyReportScore;
	} // end modifyReportScore

	/*
	 * 제출한 과제 삭제하는 메소드 파라미터 : reportSubmitNo 리턴값 : int
	 */
	public int removeReportSubmit(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@reportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);

		// reportSubmitFileMapper Call
		int removeReportSubmitFile = reportSubmitFileMapper.deleteReportSubmitFile(reportSubmitNo);
		// reportSubmitFileMapper에서 받아온 removeReportSubmitFile 값 디버깅
		log.debug(TeamColor.PSY + removeReportSubmitFile + "<-- removeReportSubmitFile" + TeamColor.TEXT_RESET);

		// reportSubmitMapper call
		int removeReportSubmit = reportSubmitMapper.deleteReportSubmit(reportSubmitNo);
		// reportSubmitMapper에서 받아온 removeReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + removeReportSubmit + "<-- removeReportSubmit" + TeamColor.TEXT_RESET);
		
		return removeReportSubmit;
	} // end removeReportSubmit

}
