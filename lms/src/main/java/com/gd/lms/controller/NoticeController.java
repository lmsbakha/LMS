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
import com.gd.lms.service.NoticeFileService;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	NoticeFileService noticeFileService;
	
	// 공지 리스트 페이지
	@GetMapping("/noticeList")
	public String noticeList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		
		// 페이지 당 게시글 수
		final int ROW_PER_PAGE = 10;				
		// 시작 페이지
		int beginRow = (currentPage-1)*ROW_PER_PAGE;	
		// 총 공지 수
		int totalNotice = noticeService.countTotalNotice();	
		// 전체 페이지 수
		int totalPage = totalNotice/ROW_PER_PAGE; 		
		
		// 리스트 불러오기
		List<Notice> noticeList = noticeService.getNoticeList(beginRow, ROW_PER_PAGE);	
		log.debug(TeamColor.debuging + TeamColor.LHN + "noticeList: " + noticeList + TeamColor.TEXT_RESET);
		
		// 페이지 내비게이션 바
		// 첫번째 페이지 
		int firstPage = currentPage - (currentPage % ROW_PER_PAGE) + 1;	
				
		// 내비게이션 마지막 페이지
		int lastPage = firstPage + ROW_PER_PAGE - 1;
				
		// 10으로 나누어 떨어지는 경우 처리하는 코드
		if (currentPage % ROW_PER_PAGE == 0 && currentPage != 0) {
			firstPage = firstPage - ROW_PER_PAGE;
			lastPage = lastPage - ROW_PER_PAGE;
		}
				
		// 현재 페이지에 대한 이전 페이지
		int prePage;
		if (currentPage > 10) { 
			prePage = currentPage - (currentPage % ROW_PER_PAGE) + 1 - 10;
		} else {
			prePage = 1;
		}
				
		// 현재 페이지에 대한 다음 페이지
		int nextPage = currentPage - (currentPage % ROW_PER_PAGE) + 1 + 10;
		if (nextPage > totalPage) {
			nextPage = totalPage;
			}
		
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
	
	@GetMapping("/noticeOne/{noticeNo}")
	public String NoticeOne(Model model, @PathVariable(name="noticeNo") int noticeNo) {
		noticeService.updateNoticeCount(noticeNo);
		noticeService.showNoticeOne(noticeNo);
		return null;
	}
	
	@GetMapping("/noticeOne")
	public String NoticeOne(Model model) {
		
		return ("/noticeOne");
	}
	/*
	
	 @GetMapping("/noticeOne/")
	 public String noticeOne(Model model, @RequestParam(value="noticeNo") int noticeNo) {
		 
		 log.debug(TeamColor.debuging + " noticeNo: " + noticeNo +TeamColor.LHN + TeamColor.TEXT_RESET);
		 
		 noticeService.updateNoticeCount(noticeNo); 
		 Notice notice = noticeService.showNoticeOne(noticeNo);
		 			
		 model.addAttribute("notice",notice); 
		 log.debug(TeamColor.debuging + " notice: " + notice +TeamColor.LHN + TeamColor.TEXT_RESET);
		 
		 return "/noticeOne/"; 
	 
	 }
	*/
	
	
	
	// 공지글 수정
	
	@GetMapping("/updateNoticeOne/{noticeNo}") 
	public String updateNoticeOne(Model model, @PathVariable(name="noticeNo") int noticeNo) {
		Notice notice = noticeService.showNoticeOne(noticeNo);

	 model.addAttribute("notice", notice); 
	 return "updatenoticeOne";
	 }

	@PostMapping("/notice/updateNoticeOne") 
	public String updateNoticeOne(Notice notice) {
		noticeService.updateNotice(notice);

	 return "/updateNoticeOne";

	 }
	
	// 공지글 삭제 액션
	@GetMapping("deleteNotice/{noticeNo}")
	public String deleteNotice(@RequestParam(name="noticeNo") int noticeNo) {
		noticeService.deleteNoticeOne(noticeNo);
		 log.debug(TeamColor.LHN + noticeNo);
		return "redirect:/noticeList/1";
		
	}
	
}
