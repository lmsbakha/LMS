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
import com.gd.lms.vo.FileForm;
import com.gd.lms.vo.Report;
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
	public List<Map<String, Object>> getReportListById(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getReportOne Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// 리턴값 받아올 객체 생성
		Map<String, Object> returnMap = new HashMap<>();

		// Mapper call
		List<Map<String, Object>> getReportListById = reportSubmitMapper.selectReportListById(accountId);
		// Mapper에서 받아온 getReportListById 값 디버깅
		log.debug(TeamColor.PSY + getReportListById + "<-- getReportListById" + TeamColor.TEXT_RESET);

		// list에 값 넣어주기
		returnMap.put("getReportListById", getReportListById);

		return getReportListById;
	} // end getReportListById

	// 과제 제출하기 메소드
	// 파라미터 : ReportSubmit
	// 리턴값 : int
	public int addReportSubmit(FileForm fileForm, String path) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmit Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + fileForm.getReportSubmit() + "<-- reportSubmiut.reportSubmitNo()"
				+ TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + path + "<-- path" + TeamColor.TEXT_RESET);

		// Mapper call
		int addReportSubmit = reportSubmitMapper.insertReportSubmit(fileForm.getReportSubmit());
		// Mapper에서 받아온 addReportSubmit 값 디버깅
		log.debug(TeamColor.PSY + addReportSubmit + "<-- addReport" + TeamColor.TEXT_RESET);

		// insertReportSubmit 성공 시
		if (addReportSubmit == 1 & fileForm.getMultiList() != null) {
			for (MultipartFile mf : fileForm.getMultiList()) {
				// 매번 새로운 reportSubmitFIle을 만들기 위한 객체 생성
				ReportSubmitFile reportSubmitFile = new ReportSubmitFile();
				// Mapper call
				reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);

				// 중복되지 않는 랜덤이름 생성 UUID API를 사용
				String filename = UUID.randomUUID().toString().replace("-", "");
				reportSubmitFile.setReportSubmitFilename(filename);
				reportSubmitFile.setReportSubmitFileType(mf.getContentType());
				reportSubmitFile.setReportSubmitOriginName(mf.getOriginalFilename());
				reportSubmitFile.setReportSubmitFileSize(mf.getSize());
				
				// insertBoardfile메서드 호출하고 안에 매개변수 reportSubmitFile값 넣어주기
				reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);
				// reportSubmitFile 넣어준 값 디버깅
				log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

				// 파일 확장자 - mf.getOriginalFilename()에서 인덱스를 자름
				// mf.getOriginalFilename().lastIndexOf(".")로 마지막 점을 찾음
				// substring()로 .txt를 찾음
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
				// 디버깅
				log.debug(TeamColor.PSY + ext + "<-- ext" + TeamColor.TEXT_RESET);

				// 파일 생성 - MultipartFile 안에 파일 생성 API(transferTo)가 있음
				// transferTo 리턴타입을 주기 위해 new File()파일 객체 생성
				try {
					// c://upload/ttt.txt
					// 새로운 bean 파일 안에 MultipartFile안에 파일을 하나씩 복사
					mf.transferTo(new File(path + filename + ext));
				} catch (Exception e) {
					e.printStackTrace();
					// @Transactional 처리가 되도록 강제로 RuntimeException(try절을 발생시키지 않는) 발생
					throw new RuntimeException();
				}
			}
		}
		return addReportSubmit;
	} // end addReportSubmit

}
