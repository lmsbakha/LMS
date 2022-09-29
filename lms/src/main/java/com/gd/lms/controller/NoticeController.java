package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.service.AccountService;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Manager;
import com.gd.lms.vo.Notice;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.Teacher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	AccountService accountService;
	AccountMapper accountMapper;
	
	// 공지 리스트 페이지
	@GetMapping("/loginCheck/noticeList")
	public String noticeList(HttpServletRequest request, Model model) {
		log.debug(TeamColor.LHN + "게시글 리스트 조회" + TeamColor.TEXT_RESET);	
		
		// userId에 대한 level 가져오기
		HttpSession session = request.getSession();
		log.debug(TeamColor.LHN + "session: " + session + TeamColor.TEXT_RESET);	
		
		String accountId = (String)session.getAttribute("sessionId");	
		log.debug(TeamColor.LHN + "accountId: " + accountId + TeamColor.TEXT_RESET);
		
		int userLevel = (int) session.getAttribute("sessionLevel");
		log.debug(TeamColor.LHN + "userLevel: " + userLevel + TeamColor.TEXT_RESET);
		
		
		// 리스트 불러오기
		List<Notice> noticeList = noticeService.getNoticeList();	
		log.debug(TeamColor.LHN + "noticeList: " + noticeList + TeamColor.TEXT_RESET);
		
		
		// model에 데이터 세팅
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("userLevel", userLevel);
		model.addAttribute("accountId", accountId);

		return "notice/noticeList";
	}
	
	// 공지글 작성 폼
	@GetMapping("/loginCheck/addNotice")
	public String addNoticeForm(Model model) {
		return "notice/addNotice";
	}

	// 공지글 작성 액션
		@PostMapping("/loginCheck/addNotice")
		String addNotice(Model model,
				@RequestParam("noticeTitle") String noticeTitle,
				@RequestParam("noticeContent") String noticeContent, 
				HttpServletRequest request,
				HttpSession session) {
			
		log.debug(TeamColor.LHN + "게시글 작성" + TeamColor.TEXT_RESET);
		Notice notice = new Notice();
		noticeContent = noticeContent.replace("\r\n","<br>");
		log.debug(TeamColor.LHN + "자동 개행 적용" + noticeContent +  TeamColor.TEXT_RESET);
		
		// 입력 내용 notice 적용
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);	
		
		// 작성자 아이디 담기
		String accountId = (String) session.getAttribute("sessionId");
		notice.setAccountId(accountId);
		log.debug(TeamColor.LHN + "accountId" + accountId +  TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "notice" + notice +  TeamColor.TEXT_RESET);

		// notice 적용
		noticeService.addNotice(notice);
		
		// 공지 리스트로
		return "redirect:/loginCheck/noticeList";
	} 
		
		
		
	// 공지사항 상세보기
	
	@GetMapping("/loginCheck/noticeOne")
	public String NoticeOne(Model model, @RequestParam("noticeNo") int noticeNo) {
		log.debug(TeamColor.LHN + "게시글 상세보기: " + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "noticeNo: " + noticeNo + TeamColor.TEXT_RESET);
		// 객체 적용
		int noticeCount = noticeService.updateNoticeCount(noticeNo);
		Notice notice = noticeService.showNoticeOne(noticeNo);
		notice.setNoticeCount(noticeCount);
		model.addAttribute("notice", notice); 
		log.debug(TeamColor.LHN + "noticeCount: " + noticeCount + TeamColor.TEXT_RESET);
		return "notice/noticeOne";
	}
	


	// 공지글 수정 폼
	
	@GetMapping("/loginCheck/modifyNoticeForm") 
	public String updateNoticeOne(Model model, @RequestParam("noticeNo") int noticeNo) {
		log.debug(TeamColor.LHN + "공지글 수정 폼 " + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + noticeNo +  ": noticeNo " + TeamColor.TEXT_RESET);
		// 객체 적용
		Notice notice = noticeService.modifyNoticeForm(noticeNo);
		model.addAttribute("notice", notice); 
		return "notice/modifyNotice";
		}

	
	// 수정 액션
	@PostMapping("/loginCheck/modifyNotice")
	public String modifyList(Model model, @RequestParam("noticeNo") int noticeNo,
			@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContent") String noticeContent) {
		
		log.debug(TeamColor.LHN + "공지 수정 액션" + TeamColor.TEXT_RESET);

		// 받아온 값 notice에 세팅
		Notice notice = new Notice();
		notice.setNoticeNo(noticeNo);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		log.debug(TeamColor.LHN + "modifyNotice: " +notice +  TeamColor.TEXT_RESET);
		int modifyNotice = noticeService.modifyNotice(notice);
		// 디버깅
		log.debug(TeamColor.LHN + "수정완료"+ TeamColor.TEXT_RESET);
		
		// 파일 여부에 따른 추가/삭제 기능 추가 필요
		
		
		return "redirect:/loginCheck/noticeList";
	}
	
	// 공지글 삭제 액션
	@GetMapping("/loginCheck/removeNotice")
	public String deleteNotice(@RequestParam(name="noticeNo") int noticeNo) {
		log.debug(TeamColor.LHN + noticeNo +  ": noticeNo " + TeamColor.TEXT_RESET);
		
		int removeNotice = noticeService.removeNoticeOne(noticeNo);
		log.debug(TeamColor.LHN + removeNotice+ ": removeNotice " + TeamColor.TEXT_RESET);
		if(removeNotice!=0) {
			log.debug(TeamColor.LHN +" 삭제 성공 " + TeamColor.TEXT_RESET);
		}
			log.debug(TeamColor.LHN +" 삭제 실패 " + TeamColor.TEXT_RESET);
			
		
		return "redirect:/loginCheck/noticeList";
		
	}
	
}
