package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.NoticeMapper;
import com.gd.lms.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	
	// 공지사항 리스트
	public List<Map<String, Object>> getNoticeList(){
		List<Map<String, Object>> noticeList = noticeMapper.selectNoticeList();
		return noticeList;
	}
	
	// 공지사항 신규 작성
	public int addNotice(Notice notice) {
		// 디버깅
		log.debug(TeamColor.debuging+" addNotice 실행" + TeamColor.LHN + TeamColor.TEXT_RESET);
		int row = noticeMapper.addNotice(notice);
		return row;
	}
	
	
}
