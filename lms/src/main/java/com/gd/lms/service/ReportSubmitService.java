package com.gd.lms.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitFileMapper;
import com.gd.lms.mapper.ReportSubmitMapper;
import com.gd.lms.vo.ReportSubmitForm;
import com.gd.lms.vo.ReportSubmit;
import com.gd.lms.vo.ReportSubmitFile;

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

	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	public List<ReportSubmit> getReportListById(String accountId) {
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
		List<ReportSubmit> ReportSubmitListById = reportSubmitMapper.selectReportListById(paramMap);
		// 파마리터 디버깅
		log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
		// Mapper에서 받아온 ReportSubmitListById 값 디버깅
		log.debug(TeamColor.PSY + ReportSubmitListById.toString() + "<-- ReportSubmitListById" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("ReportSubmitListById", ReportSubmitListById);

		return ReportSubmitListById;
	} // end getReportListById
	
	// 학생이 제출한 과제 리스트 조회 메소드
		// 파라미터 : accountId
		// 리턴값 : List<Map<String,Object>>
		public List<ReportSubmit> getReportListBySubject(int educationNo) {
			// 디버깅 영역구분
			log.debug(TeamColor.PSY + "\n\n@getReportListById Service" + TeamColor.TEXT_RESET);
			// 파라미터 디버깅
			log.debug(TeamColor.PSY + educationNo + "<-- accountId" + TeamColor.TEXT_RESET);

			// 리턴값 받아올 객체 생성
			Map<String, Object> returnMap = new HashMap<>();

			// ReportMapper에 넣어줄 매개변수 설정
			Map<String, Object> paramMap = new HashMap<>();
			// paramMap에 값 넣어주기
			paramMap.put("educationNo", educationNo);

			// Mapper call
			List<ReportSubmit> ReportSubmitListBySubject = reportSubmitMapper.selectReportListBySubject(paramMap);
			// 파마리터 디버깅
			log.debug(TeamColor.PSY + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);
			// Mapper에서 받아온 ReportSubmitListById 값 디버깅
			log.debug(TeamColor.PSY + ReportSubmitListBySubject.toString() + "<-- ReportReportSubmitListBySubjectSubmitListById" + TeamColor.TEXT_RESET);

			// list에 값 넣어주기
			returnMap.put("ReportSubmitListBySubject", ReportSubmitListBySubject);

			return ReportSubmitListBySubject;
		} // end getReportSubmitListBySubject
	/*
	 * // 과제 제출하기 메소드 // 파라미터 : ReportSubmit // 리턴값 : int public int
	 * addReportSubmit(ReportSubmit reportSubmit, HttpSession session,
	 * MultipartFile[] reportSubmiFile) { // 디버깅 영역구분 log.debug(TeamColor.PSY +
	 * "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET); // 파라미터 디버깅
	 * log.debug(TeamColor.PSY + reportSubmitForm + "<-- reportSubmitForm" +
	 * TeamColor.TEXT_RESET); log.debug(TeamColor.PSY + path + "<-- path" +
	 * TeamColor.TEXT_RESET);
	 * 
	 * // 요청값 셋팅 ReportSubmit reportSubmit = new ReportSubmit();
	 * reportSubmit.setReportSubmitContent(reportSubmitForm.getReportSubmitContent()
	 * );
	 * reportSubmit.setReportSubmitTitle(reportSubmitForm.getReportSubmitTitle());
	 * reportSubmit.setAccountId(reportSubmitForm.getAccountId());
	 * reportSubmit.setEducationNo(reportSubmitForm.getEducationNo());
	 * reportSubmit.setReportNo(reportSubmitForm.getReportNo());
	 * 
	 * ReportSubmitFile reportSubmitFile = new ReportSubmitFile();
	 * reportSubmitFile.setReportSubmitFilename(reportSubmitForm.
	 * getReportSubmitFilename());
	 * reportSubmitFile.setReportSubmitFileNo(reportSubmitForm.getReportNo());
	 * reportSubmitFile.setReportSubmitFileType(reportSubmitForm.
	 * getReportSubmitFileType());
	 * reportSubmitFile.setReportSubmitOriginName(reportSubmitForm.
	 * getReportSubmitOriginName()); // 요청값 디버깅 log.debug(TeamColor.PSY +
	 * reportSubmit + "<-- reportSubmit" + TeamColor.TEXT_RESET);
	 * 
	 * // Mapper call int addReportSubmit =
	 * reportSubmitMapper.insertReportSubmit(reportSubmit); // Mapper에서 받아온
	 * addReportSubmit 값 디버깅 // insert시 입력된 autoincrement값이 출력됨
	 * log.debug(TeamColor.PSY + reportSubmit.getAccountId() +
	 * "<-- reportSubmit.getAccountId() " + TeamColor.TEXT_RESET); //
	 * addReportSubmit == 1이면 if ( reportSubmitFile != null) { // 디버깅
	 * log.debug(TeamColor.PSY + "첨부된 파일이 있습니다." + TeamColor.TEXT_RESET);
	 * 
	 * // insertReportSubmitFile 메서드 호출하고 안에 매개변수 reportSubmitFile값 넣어주기 int
	 * reportFileList =
	 * reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile); //
	 * reportSubmitFilename값 디버깅 log.debug(TeamColor.PSY + reportFileList +
	 * "<-- reportFileList" + TeamColor.TEXT_RESET);
	 * 
	 * // 파일 생성 - MultipartFile 안에 파일 생성 API(transferTo)가 있음 // transferTo 리턴타입을 주기
	 * 위해 new File()파일 객체 생성 try { // c://upload/ttt.txt // 새로운 bean 파일 ->
	 * MultipartFile-> 파일을 하나씩 복사 file.transferTo(new File(path +
	 * reportSubmitFile.getReportSubmitFilename())); } catch (Exception e) {
	 * e.printStackTrace(); // @Transactional 처리가 되도록 강제로 RuntimeException(try절을
	 * 발생X) 발생 throw new RuntimeException(); } // end try catch } // end for } //
	 * end if return addReportSubmit;
	 * 
	 * } // end addReportSubmit
	 */
	
	// 제출한 과제 수정하는 메소드
	// modifyReportSubmit Form
	// 파라미터 : reportSubmitNo
	// 리턴값 : ReportSubmit
	public ReportSubmit ReportSubmitOne(int reportSubmitNo) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@ReportSubmitOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitNo + "<-- reportSubmitNo" + TeamColor.TEXT_RESET);
		// Mapper call
		ReportSubmit ReportSubmitOne = reportSubmitMapper.ReportSubmitOne(reportSubmitNo);
		// Mapper에서 받아온 ReportSubmitOne 값 디버깅
		log.debug(TeamColor.PSY + ReportSubmitOne + "<-- ReportSubmitOne" + TeamColor.TEXT_RESET);

		return ReportSubmitOne;
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

	public void addReportSubmit(MultipartFile[] reportSubmitFile, ReportSubmit reportSubmit) {
		// TODO Auto-generated method stub
		
	}

}
