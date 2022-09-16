package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	// 공지 리스트 페이지
	@GetMapping("/noticeList/{currentPage}")
	public String noticeList(Model model, @PathVariable(name="currentPage") int currentPage) {
		
		int rowPerPage = 10;						// 페이지 당 게시글 수
		int beginRow = (currentPage-1)*rowPerPage;	// 시작 페이지
		int totalNotice = noticeService.countTotalNotice();	// 총 공지 수
		int lastPage = totalNotice/rowPerPage; 		// 전체 페이지 수
		
		List<Notice> noticeList = noticeService.getNoticeList(beginRow, rowPerPage);	// 리스트 불러오기
		
		// model에 데이터 세팅
		model.addAttribute("noticeList", noticeList);
		
		return "noticeList";
	}
	
	// 공지글 작성 폼
	@GetMapping("/addNotice")
	public String addNoticeForm() {
		return "addNotice";
	}

	// 공지글 작성 액션
	@GetMapping("/addNoticeOne")
	public String addNotice(Notice notice, @RequestParam(value = "notice") Notice newNotice) {
		// service 리턴값
		int row = noticeService.addNotice(notice);
		// 디버깅
		if (row != 0) { // 성공
			log.debug(TeamColor.debuging + " add 성공" + TeamColor.LHN + TeamColor.TEXT_RESET);
		} else { // 실패
			log.debug(TeamColor.debuging + " add 실패" + TeamColor.LHN + TeamColor.TEXT_RESET);
		}
		return "redirect:/noticeList";
	}
	
	// 공지사항 상세보기
	@GetMapping("/NoticeOne/{noticeNo}")
	public String NoticeOne(Model model, @PathVariable(name="noticeNo") int noticeNo) {
		noticeService.updateNoticeCount(noticeNo);
		return null;
	}
	
	// 공지글 수정
	
	@GetMapping("/updateNoticeOne/{lectNoticeNo}") 
	public String updateLecNoticeOne(Model model, @PathVariable(name="noticeNo") int noticeNo) {
		Notice notice = noticeService.showNoticeOne(noticeNo);

	 model.addAttribute("notice", notice); 
	 return "/updatenoticeOne";
	 }

	@PostMapping("/notice/updateNoticeOne") 
	public String updateNoticeOne(Notice notice) {
		noticeService.updateNotice(notice);

	 return "/updateLecNoticeOne";

	 }
	
	// 공지글 수정 액션
	
	
}
