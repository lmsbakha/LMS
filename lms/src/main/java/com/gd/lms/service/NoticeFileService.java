package com.gd.lms.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.NoticeFileMapper;
import com.gd.lms.vo.NoticeFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class NoticeFileService {
	@Autowired private NoticeFileMapper noticeFileMapper;
	// 공지글 파일 불러오기(다운로드)
	public NoticeFile downloadNoticeFile(int noticeFileNo) {
		
		return null;
		
	}
	
	// 공지글 파일 첨부
	public int addNoticeFile(NoticeFile noticeFile) {
		log.debug(TeamColor.LHN + "addNotice 실행" + TeamColor.TEXT_RESET);
		int addNoticeFile = 0;
		addNoticeFile = noticeFileMapper.insertNoticeFile(noticeFile);
		
		// 디버깅
		log.debug(TeamColor.PSY + "addNoticeFile: "+ addNoticeFile  + TeamColor.TEXT_RESET);
		return addNoticeFile; 
	} 
	
	// 공지글 파일 삭제
	public int deleteNoticeFile(int noticeNo) {

		
		return noticeNo;
		
		
	}
}
