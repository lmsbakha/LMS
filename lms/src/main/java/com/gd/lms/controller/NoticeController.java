package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Member;
import com.gd.lms.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired NoticeService noticeService;
	
	// 공지 리스트 페이지
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		
		List<Map<String, Object>> list = noticeService.getNoticeList();
		// model에 데이터 세팅
		model.addAttribute("list", list);
		
		return "noticeList";	// ("countriesList").forward(request, response);
	}
	
	// 공지글 작성 폼
	@GetMapping("/newNotice")
	public String addNoticeForm() {
		return "addNotice";
	}
	
	// 공지글 작성 액션
	@GetMapping("/addNotice")
	public String addNotice(Notice notice, @RequestParam(value = "notice") Notice newNotice) {
		
		
		
		
		
		// service 리턴값
		int row = noticeService.addNotice(notice);
		// 디버깅
		if (row != 0) { // 성공
			log.debug(TeamColor.debuging+" add 성공" + TeamColor.LHN + TeamColor.TEXT_RESET);
		} else { // 실패
			log.debug(TeamColor.debuging+" add 실패" + TeamColor.LHN + TeamColor.TEXT_RESET);
		}
		return "redirect:/noticeList";
	}
	
}
