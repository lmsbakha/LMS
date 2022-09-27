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
import com.gd.lms.mapper.NoticeFileMapper;
import com.gd.lms.mapper.NoticeMapper;
import com.gd.lms.vo.Notice;
import com.gd.lms.vo.NoticeFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;
	private NoticeFileMapper noticeFileMapper;

	// 개시글 갯수
	public int countTotalNotice() {
		return noticeMapper.selectTotalNotice();
	}

	// 공지사항 리스트
	public List<Notice> getNoticeList(int beginRow, int rowPerPage) {
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		noticeMap.put("beginRow", beginRow);
		noticeMap.put("rowPerPage", rowPerPage);
		// 디버그
		log.debug(TeamColor.LHN + "beginRow" + beginRow+ TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "rowPerPage" + rowPerPage+ TeamColor.TEXT_RESET);


		return noticeMapper.selectNoticeList(noticeMap);
	}
	
	// 공지사항 상세보기 
	public Notice showNoticeOne(int noticeNo) {
		log.debug(TeamColor.LHN + "selectNoticeOne 호출" + TeamColor.TEXT_RESET);
		// 수정할 객체
		Notice notice = null;
		log.debug(TeamColor.LHN + "noticeNo: " + noticeNo +  TeamColor.TEXT_RESET);
		// 매퍼 적용
		notice = noticeMapper.selectNoticeOne(noticeNo);
		log.debug(TeamColor.LHN+ "notice : " +notice + TeamColor.TEXT_RESET);
		return notice;
	}
	
	
	//공지사항 신규 작성 액션
	// 파일없
	
//	public int addNotice(Notice notice) {
//		// 디버깅
//		log.debug(TeamColor.LHN + " addNotice 실행" + TeamColor.TEXT_RESET);
//		int addNotice = 0;	// 리턴값
//		log.debug(TeamColor.LHN + "Notice: " + notice + TeamColor.TEXT_RESET);
//		// 매퍼 실행
//		addNotice = noticeMapper.insertNotice(notice);
//		return addNotice;
//	}
	
	
	//파일있
	public int addNotice(Notice notice, String path) {
		// 디버깅
		log.debug(TeamColor.LHN + " addNotice(+file) 실행" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + " addNotice(+file) 실행" + TeamColor.TEXT_RESET);
		
		int addNotice = 0;	// 리턴값
		log.debug(TeamColor.LHN + "Notice: " + notice + TeamColor.TEXT_RESET);
		
		// 매퍼 실행
		noticeMapper.insertNotice(notice);
		MultipartFile mf = notice.getNoticeFile();
//		addNotice = noticeMapper.insertNotice(notice);
//		log.debug(TeamColor.LHN + "addNotice: " + addNotice + TeamColor.TEXT_RESET);
//		
//		MultipartFile mf = notice.getNoticeFile();
//		log.debug(TeamColor.LHN + "MultipartFile: " + mf + TeamColor.TEXT_RESET);
//		
		//원본 파일명
		String originName = mf.getOriginalFilename();	
		log.debug(TeamColor.LHN + "originName: " + originName + TeamColor.TEXT_RESET);

		// 랜덤으로 생성되는 고유 파일명(UUID)
		String fileName = UUID.randomUUID().toString();	
		log.debug(TeamColor.LHN + "fileName: " + fileName + TeamColor.TEXT_RESET);
		
		//확장자 확인
		String ext = originName.substring(originName.lastIndexOf("."));	
		log.debug(TeamColor.LHN + "ext: " + ext + TeamColor.TEXT_RESET);

		// uuid+확장자
		fileName=fileName+ext;
		log.debug(TeamColor.LHN + "fileName(file+ext): " + fileName + TeamColor.TEXT_RESET);
		
		// NoticeFile 객체에 적용
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setAccountId(notice.getAccountId());
		noticeFile.setNoticeFileName(fileName);
		noticeFile.setNoticeFileOriginName(originName);
		noticeFile.setNoticeFileType(mf.getContentType());
		noticeFile.setNoticeFileSize(mf.getSize());
		
		log.debug(TeamColor.LHN + "noticeFile: " + noticeFile + TeamColor.TEXT_RESET);
		// 파일 저장 경로
		String savePath = path+fileName;
		
		try {
			// 파일 저장
			mf.transferTo(new File(savePath));
		} catch (Exception e) {
			e.printStackTrace();
			// 새로운 예외 발생=> @Transactional 작동
			throw new RuntimeException(); // RuntimeException은 예외처리를 하지 않아도 컴파일됨
		}
		// noticeFile 파일 입력
        int row = noticeFileMapper.insertNoticeFile(noticeFile);

		// 디버깅
		log.debug(TeamColor.LHN + "addNotice: "+ addNotice  + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "noticeFile 입력: "+ row  + TeamColor.TEXT_RESET);
		return addNotice;
	}
	
	// 공지글 조회수 증가	
	public int updateNoticeCount(int noticeNo) {
		log.debug(TeamColor.LHN + " 조회수 증가" + TeamColor.TEXT_RESET);
		return noticeMapper.updateNoticeCount(noticeNo);
	}
	
	// 공지글 수정 폼
	public Notice modifyNoticeForm(int noticeNo) {
		log.debug(TeamColor.LHN + "updateNoticeForm 호출" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "noticeNo: " + noticeNo +  TeamColor.TEXT_RESET);
		// 수정할 객체
		Notice notice = noticeMapper.updateNoticeForm(noticeNo);
		log.debug(TeamColor.LHN+ "(Service)notice : " +notice + TeamColor.TEXT_RESET);
		
		/*
		// 게시글과 파일 묶기
		Map<String, Object> noticeOneReturnMap = new HashMap<>();
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		
		if(noticeFileMapper.selectNoticeFileList(noticeNo)!=null) {
			//File이 존재할 경우
			List<String> noticeFileList = noticeFileMapper.selectNoticeFileList(noticeNo);
			log.debug(TeamColor.LHN + "noticeFileList" + noticeFileList + TeamColor.TEXT_RESET);
			
			noticeOneReturnMap.put("noticeFileList", noticeFileList);
			log.debug(TeamColor.LHN + "noticeOneReturnMap" + noticeOneReturnMap + TeamColor.TEXT_RESET);
		}else{
			noticeOneReturnMap.put("notice", notice);
			return noticeOneReturnMap;
		}
		
		noticeOneReturnMap.put("notice", notice);
		
		*/
		return notice;
	}
	
	// 공지글 수정 액션
	public int modifyNotice(Notice notice) {
		
		
		
		return noticeMapper.updateNotice(notice);
	}

	// 공지글 삭제
	public int removeNoticeOne(int noticeNo) {
		log.debug(TeamColor.LHN + "게시글 삭제" + TeamColor.TEXT_RESET);
		
		
		int removeNotice = 0;
		log.debug(TeamColor.LHN  + "게시글 번호: " + noticeNo + TeamColor.TEXT_RESET);
		// 매퍼 적용
		removeNotice = noticeMapper.deleteNotice(noticeNo);
		log.debug(TeamColor.LHN + "삭제여부: "+ removeNotice  + TeamColor.TEXT_RESET);
		return removeNotice;
	}

}
