package com.gd.lms.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitFileMapper;
import com.gd.lms.mapper.ReportSubmitMapper;
import com.gd.lms.vo.ReportSubmitForm;
import com.gd.lms.vo.ReportSubmitFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ReportSubmitFileService {
	@Autowired 
	// ReportSubmitFile 객체 주입
	ReportSubmitFileMapper reportSubmitFileMapper;
	@Autowired 
	// ReportSubmitFile 객체 주입
	ReportSubmitMapper reportSubmitMapper;
	
	// 과제 제출하기 첨부파일 업로드 메소드
	// 파라미터 : ReportSubmitFile
	// 리턴값 : int
	public int addReportSubmitFile(ReportSubmitFile reportSubmitFile) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@addReportSubmitFile Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);
		
		//  Mapper Call
		int addReportSubmitFile = reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);
		//  Mapper에서 받아온 addReportSubmitFile 디버깅
		log.debug(TeamColor.PSY + addReportSubmitFile + "<-- addReportSubmitFile" + TeamColor.TEXT_RESET);
		
		return addReportSubmitFile;
	} // end addReportSubmitFile
	
	public void addReportSubmitFile(ReportSubmitForm fileForm, String path) {
		// 디버깅
		int row = reportSubmitMapper.insertReportSubmit(fileForm.getReportSubmit());
		// 디버깅
		System.out.println(fileForm.getReportSubmit());  // board.getBoardNo()  -> selectkey
		System.out.println("row : " + row);
		
		if(row == 1 & fileForm.getMultiList() != null) {
			for(MultipartFile mf : fileForm.getMultiList()){
				
				// 매번 새로운 reportSubmitfile을 만들어야 함
				ReportSubmitFile reportSubmitFile = new  ReportSubmitFile();
				reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);
				
				// 중복되지 않는 랜덤이름 생성 UUID API를 사용
				String filename = UUID.randomUUID().toString().replace("-", "");
				reportSubmitFile.setReportSubmitFilename(filename);
				reportSubmitFile.setReportSubmitFileType(mf.getContentType());
				reportSubmitFile.setReportSubmitOriginName(mf.getOriginalFilename());
				reportSubmitFile.setReportSubmitFileSize(mf.getSize());
				// reportSubmitFile값 디버깅
				log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

				// insertReportSubmit 메서드 호출하고 안에 매개변수 reportSubmitFile값 넣어주기
				reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);

				// 파일 확장자 - mf.getOriginalFilename()에서 인덱스를 자르면 됨
				// mf.getOriginalFilename().lastIndexOf(".")로 마지막 점을 찾음
				// substring()로 .txt를 찾음
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
				// 디버깅
				System.out.println("ext : " + ext);

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
	}
	
	// 과제 제출하기 메소드
		// 파라미터 : ReportSubmit
		// 리턴값 : void
		public void addReportSubmitFile2(ReportSubmitForm fileForm, String path) {
			// 디버깅 영역구분
			log.debug(TeamColor.PSY + "\n\n@addReportSubmitFile Service" + TeamColor.TEXT_RESET);
			// 파라미터 디버깅
			log.debug(TeamColor.PSY + fileForm.getReportSubmit() + "<-- fileForm.getReportSubmit()" + TeamColor.TEXT_RESET);

		//	// Mapper call
		// addReportSubmit = reportSubmitFileMapper.insertReportSubmitFile(fileForm.getReportSubmit());
		//	// Mapper에서 받아온 addReportSubmit 값 디버깅
		//	log.debug(TeamColor.PSY + addReportSubmit + "<-- addReport" + TeamColor.TEXT_RESET);

		//	if (addReportSubmit == 1 & fileForm.getMultiList() != null) {
				for (MultipartFile mf : fileForm.getMultiList()) {

					// 매번 새호운 reportSubmitFile을 만들어야 함
					ReportSubmitFile reportSubmitFile = new ReportSubmitFile();
					reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);

					// 중복되지 않는 랜덤이름 생성 UUID API를 사용
					String filename = UUID.randomUUID().toString().replace("-", "");
					reportSubmitFile.setReportSubmitFilename(filename);
					reportSubmitFile.setReportSubmitFileType(mf.getContentType());
					reportSubmitFile.setReportSubmitOriginName(mf.getOriginalFilename());
					reportSubmitFile.setReportSubmitFileSize(mf.getSize());
					// reportSubmitFile값 디버깅
					log.debug(TeamColor.PSY + reportSubmitFile + "<-- reportSubmitFile" + TeamColor.TEXT_RESET);

					// insertReportSubmit 메서드 호출하고 안에 매개변수 reportSubmitFile값 넣어주기
					reportSubmitFileMapper.insertReportSubmitFile(reportSubmitFile);

					// 파일 확장자 - mf.getOriginalFilename()에서 인덱스를 자르면 됨
					// mf.getOriginalFilename().lastIndexOf(".")로 마지막 점을 찾음
					// substring()로 .txt를 찾음
					String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
					// reportSubmitFile값 디버깅
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
					} // end try catch
				} // end for
			} // end if
		} // end addReportSubmit
// }
