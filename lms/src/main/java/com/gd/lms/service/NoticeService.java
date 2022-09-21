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
import com.gd.lms.vo.Report;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;

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
	public int addNotice(Notice notice) {
		// 디버깅
		log.debug(TeamColor.LHN + " addNotice 실행" + TeamColor.TEXT_RESET);
		int addNotice = 0;	// 리턴값
		log.debug(TeamColor.LHN + "Notice: " + notice + TeamColor.TEXT_RESET);
		// 매퍼 실행
		addNotice = noticeMapper.insertNotice(notice);
		
		// 디버깅
		log.debug(TeamColor.PSY + "addNotice: "+ addNotice  + TeamColor.TEXT_RESET);
		return addNotice;
	}
	
	// 공지글 조회수 증가	
	public int updateNoticeCount(int noticeNo) {
		Notice notice = noticeMapper.selectNoticeOne(noticeNo);
		log.debug(TeamColor.LHN + " 조회수 증가" + TeamColor.TEXT_RESET);
		return noticeMapper.updateNoticeCount(notice);
	}
	
	// 공지글 수정 폼
	public Notice modifyNoticeForm(int noticeNo) {
		log.debug(TeamColor.LHN + "updateNoticeForm 호출" + TeamColor.TEXT_RESET);
		// 수정할 객체
		Notice notice = null;
		log.debug(TeamColor.LHN + "noticeNo: " + noticeNo +  TeamColor.TEXT_RESET);
		// 매퍼 적용
		notice = noticeMapper.updateNoticeForm(noticeNo);
		log.debug(TeamColor.LHN+ "notice : " +notice + TeamColor.TEXT_RESET);
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
		log.debug(TeamColor.LHN + noticeNo + ": 게시글 번호" + TeamColor.TEXT_RESET);
		// 매퍼 적용
		removeNotice = noticeMapper.deleteNotice(noticeNo);
		log.debug(TeamColor.LHN + removeNotice + ": 삭제여부" + TeamColor.TEXT_RESET);
		return removeNotice;
	}

}
