package com.gd.lms.service;

import java.util.HashMap;
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

	// 개시글 갯수
	public int countTotalNotice() {
		return noticeMapper.selectTotalNotice();
	}
	
	// 공지사항 리스트
	public List<Notice> getNoticeList(int beginRow, int rowPerPage){
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		noticeMap.put("beginRow", beginRow);
		noticeMap.put("rowPerPage", rowPerPage);
		// 디버그
		log.debug(TeamColor.LHN+"beginRow"+beginRow);
		log.debug(TeamColor.LHN+"rowPerPage"+rowPerPage);
		
		return noticeMapper.selectNoticeList(noticeMap);
	}
	
	
	
	
	
	
	// 공지사항 신규 작성
	public int addNotice(Notice notice) {
		// 디버깅
		log.debug(TeamColor.debuging+" addNotice 실행" + TeamColor.LHN + TeamColor.TEXT_RESET);
		return noticeMapper.insertNotice(notice);
	}
	// 공지글 조회수 증가	
	
}
