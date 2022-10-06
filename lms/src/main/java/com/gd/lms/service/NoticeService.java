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
import com.gd.lms.mapper.NoticeMapper;
import com.gd.lms.vo.Notice;

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
	public List<Notice> getNoticeList() {
		return noticeMapper.selectNoticeList();
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
	
	// 공지사항 페이징
	public Map<String, Object> getNoticeListByPage(Map<String, Object> map) {

		int totalCnt = noticeMapper.selectTotalNotice(); // 총 개수
		int rowPerPage = (int)map.get("rowPerPage"); // 한 페이지당 행 개수
		int beginRow = ((int)map.get("currentPage")-1)*10; // 시작 row
		
		int lastPage = totalCnt/ rowPerPage; // 마지막 페이지
		if(totalCnt % rowPerPage != 0) { // 나눠떨어지지않는다면
			lastPage += 1; // 마지막페이지 +1 해주기
		}
		
		map.put("beginRow", beginRow);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("lastPage", lastPage);
		
		return returnMap;

		
	}
	//공지사항 신규 작성 액션
	public int addNotice(Notice notice) {
		// 디버깅
		log.debug(TeamColor.LHN + " addNotice 실행" + TeamColor.TEXT_RESET);
		int addNotice = 0;	// 리턴값
		log.debug(TeamColor.LHN + "Notice: " + notice + TeamColor.TEXT_RESET);
		// 매퍼 실행
		addNotice = noticeMapper.insertNotice(notice);
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
		String noticeContent = notice.getNoticeContent();
		noticeContent = noticeContent.replace("<br>", "\r\n");
		notice.setNoticeContent(noticeContent);
		log.debug(TeamColor.LHN + "자동 개행 적용" + noticeContent +  TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN+ "(Service)notice : " +notice + TeamColor.TEXT_RESET);
		return notice;
	}
	
	// 공지글 수정 액션
	public int modifyNotice(Notice notice) {
		log.debug(TeamColor.LHN + "modifyNotice 실행" + TeamColor.TEXT_RESET);
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
