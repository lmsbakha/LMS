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
	/*
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
	*/
	
	//공지사항 신규 작성 액션
	public int addNotice(Notice notice, NoticeFile noticeFile, String path) {
		// 디버깅
		log.debug(TeamColor.LHN + " addNotice 실행" + TeamColor.TEXT_RESET);
		int addNotice = 0;	// 리턴값
		log.debug(TeamColor.LHN + "Notice: " + notice + TeamColor.TEXT_RESET);
		// 매퍼 실행
		addNotice = noticeMapper.insertNotice(notice);
		if(noticeFile.getNoticeFileList()!=null && noticeFile.getNoticeFileList().get(0).getSize()>0 && addNotice == 1) {
			log.debug(TeamColor.LHN + "첨부파일 있음" + TeamColor.TEXT_RESET);
			log.debug(TeamColor.LHN + "첨부파일 갯수: " + noticeFile.getNoticeFileList().size() + TeamColor.TEXT_RESET);
			
			for(MultipartFile mf : noticeFile.getNoticeFileList()) {
				// mf=>noticeFile
				NoticeFile noticeFileOne = new NoticeFile();
				
				// OriginalFileName 요청
				String noticeFileOriginName = mf.getOriginalFilename();
				// 확장자 저장
				String ext = noticeFileOriginName.substring(noticeFileOriginName.lastIndexOf("."));
				
				// UUID
				String noticeFileName = UUID.randomUUID().toString();
				noticeFileName = noticeFileName+ext;
				
				noticeFileOne.setNoticeNo(notice.getNoticeNo());
				noticeFileOne.setNoticeFileName(noticeFileName);
				noticeFileOne.setNoticeFileOriginName(noticeFileOriginName);
				noticeFileOne.setNoticeFileType(mf.getContentType());
				noticeFileOne.setNoticeFileSize(mf.getSize());
				// 디버깅
				log.debug(TeamColor.LHN + "첨부파일: " + noticeFileOne + TeamColor.TEXT_RESET);
				
				try {
					//경로+이름으로 파일 저장
					mf.transferTo(new File(path+noticeFileName));
				} catch (Exception e) {
					e.printStackTrace();
					// 새로운 예외 발생=> @Transactional 작동
					throw new RuntimeException(); // RuntimeException은 예외처리를 하지 않아도 컴파일됨
				}
			}
		}
		// 디버깅
		log.debug(TeamColor.LHN + "addNotice: "+ addNotice  + TeamColor.TEXT_RESET);
		return addNotice;
	}
	
	// 공지글 조회수 증가	
	public int updateNoticeCount(int noticeNo) {
		log.debug(TeamColor.LHN + " 조회수 증가" + TeamColor.TEXT_RESET);
		return noticeMapper.updateNoticeCount(noticeNo);
	}
	
	// 공지글 수정 폼
	public Map<String, Object> showNoticeOne(int noticeNo) {
		log.debug(TeamColor.LHN + "공지글 상세보기/수정 폼 호출" + TeamColor.TEXT_RESET);
		// 수정할 객체
		Notice notice = null;
		log.debug(TeamColor.LHN + "noticeNo: " + noticeNo +  TeamColor.TEXT_RESET);
		// 매퍼 적용
		notice = noticeMapper.updateNoticeForm(noticeNo);
		log.debug(TeamColor.LHN+ "notice : " +notice + TeamColor.TEXT_RESET);
		
		/*
		//File
		List<NoticeFile> noticeFileList = noticeFileMapper.selectNoticeFileList(noticeNo);
		log.debug(TeamColor.LHN + "noticeFileList" + noticeFileList + TeamColor.TEXT_RESET);
		*/
		// 게시글과 파일 묶기
		Map<String, Object> noticeOneReturnMap = new HashMap<>();
		noticeOneReturnMap.put("notice", notice);
		/*
		noticeOneReturnMap.put("noticeFileList", noticeFileList);
		log.debug(TeamColor.LHN + "noticeOneReturnMap" + noticeOneReturnMap + TeamColor.TEXT_RESET);
		*/
		
		
		
		return noticeOneReturnMap;
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
