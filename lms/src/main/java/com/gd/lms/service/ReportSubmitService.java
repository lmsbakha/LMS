package com.gd.lms.service;

import java.io.File;
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

	// 과제 제출하기 메소드
	// 파라미터 : ReportSubmit
	// 리턴값 : void
	public void addReportSubmit(ReportSubmitForm reportSubmitForm, String path) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitForm.getReportSubmit() + "<-- fileForm.getReportSubmit()"
				+ TeamColor.TEXT_RESET);

		// ReportSubmitMapper
		ReportSubmit reportSubmit = new ReportSubmit();
		reportSubmit.setReportSubmitContent(reportSubmitForm.getReportSubmitContent());
		reportSubmit.setReportSubmitTitle(reportSubmitForm.getReportSubmitTitle());

		// Mapper call
		int addReportSubmit = reportSubmitMapper.insertReportSubmit(reportSubmit);
		// Mapper에서 받아온 addReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + addReportSubmit + "<-- addReport" + TeamColor.TEXT_RESET);

		if (reportSubmitForm.getMultiList().get(0).getSize() > 0 && addReportSubmit != 0) {
			// 디버깅
			log.debug(TeamColor.PSY + "첨부된 파일이 있습니다." + TeamColor.TEXT_RESET);
			for (MultipartFile mf : reportSubmitForm.getMultiList()) {

				// 매번 새호운 reportSubmitFile을 만들어야 함
				ReportSubmitFile reportSubmitFile = new ReportSubmitFile();

				// 기존 첨부파일명
				String reportSubmitOriginFilename = mf.getOriginalFilename();

				// 파일을 저장할때 사용할 중복되지않는 새로운 이름 필요(UUID API사용)
				String reportSubmitFilename = UUID.randomUUID().toString();

				// 파일 확장자 - reportSubmitOriginFilename에서 마지막 .문자열 위치
				// substring()로 .txt를 찾음
				String ext = reportSubmitOriginFilename.substring(reportSubmitOriginFilename.lastIndexOf("."));
				// ext값 디버깅
				log.debug(TeamColor.PSY + ext + "<-- ext" + TeamColor.TEXT_RESET);

				// 새 첨부파일명
				reportSubmitFilename = reportSubmitFilename + ext;// reportSubmitFile값 디버깅
				// 디버깅
				log.debug(TeamColor.PSY + reportSubmitOriginFilename + "<-- reportSubmitOriginFilename"
						+ TeamColor.TEXT_RESET);

				reportSubmitFile.setReportSubmitFilename(reportSubmitFilename);
				reportSubmitFile.setReportSubmitFileType(mf.getContentType());
				reportSubmitFile.setReportSubmitFileSize(mf.getSize());
				// 디버깅
				log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

				// insertReportSubmitFile 메서드 호출하고 안에 매개변수 reportSubmitFile값 넣어주기
				reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);

				// 파일 생성 - MultipartFile 안에 파일 생성 API(transferTo)가 있음
				// transferTo 리턴타입을 주기 위해 new File()파일 객체 생성
				try {
					// c://upload/ttt.txt
					// 새로운 bean 파일 안에 MultipartFile안에 파일을 하나씩 복사
					mf.transferTo(new File(path + reportSubmitFilename));
				} catch (Exception e) {
					e.printStackTrace();
					// @Transactional 처리가 되도록 강제로 RuntimeException(try절을 발생시키지 않는) 발생
					throw new RuntimeException();
				} // end try catch
			} // end for
		} // end if
	} // end addReportSubmit

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

}
