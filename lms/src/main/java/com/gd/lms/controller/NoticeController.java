package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Notice;
import com.gd.lms.vo.NoticeFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	// 공지 리스트 페이지
	@GetMapping("/loginCheck/noticeList")
	public String noticeList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		log.debug(TeamColor.LHN + "게시글 리스트 조회" + TeamColor.TEXT_RESET);
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
		//이후 model에 addAttribute사용하여 세팅
		
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
		return "notice/noticeList";
	}
	
	// 공지글 작성 폼
	@GetMapping("/loginCheck/addNotice")
	public String addNoticeForm(Model model) {
		return "notice/addNotice";
	}

	// 공지글 작성 액션
	@PostMapping("/loginCheck/addNotice")
	String addNotice(HttpServletRequest request,Notice notice,NoticeFile noticeFile) {
		//파일 저장 경로 설정
		String path = request.getServletContext().getRealPath("/WEB-INF/view/notice/noticeFile/");
		// 디버깅
		log.debug(TeamColor.LHN + "path: " + path + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "notice" + notice + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "noticeFile" + noticeFile + TeamColor.TEXT_RESET);
		
		int row = noticeService.addNotice(notice,noticeFile,path);
		log.debug(TeamColor.LHN + "row" + row + TeamColor.TEXT_RESET);
		//row가 0일 경우 입력 실패
		if(row==0) {
			log.debug(TeamColor.LHN + "입력 실패"  + TeamColor.TEXT_RESET);
			
		}
		// 입력 성공
		log.debug(TeamColor.LHN + "입력 성공"  + TeamColor.TEXT_RESET);
			
		
		
		// 공지 리스트로
		return "redirect:/loginCheck/noticeList";
	} 
	
	// 공지사항 상세보기
	
	@GetMapping("/loginCheck/noticeOne")
	public String NoticeOne(Model model, HttpSession session
			,@RequestParam(name="noticeNo") int noticeNo) {
		log.debug(TeamColor.LHN + "noticeNo" + noticeNo + TeamColor.TEXT_RESET);
		
		Map<String, Object> noticeOneReturnMap = noticeService.showNoticeOne(noticeNo);	//상세보기
		log.debug(TeamColor.LHN + "notice" + noticeOneReturnMap.get("notice") + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "noticeFileList" + noticeOneReturnMap.get("noticeFileList") + TeamColor.TEXT_RESET);
		//returnMap 안에 notice는 권한 비교를 위해 notice변수에 저장
		Notice notice = (Notice)noticeOneReturnMap.get("notice");
		Object row = noticeOneReturnMap.get("noticeFileList");
		model.addAttribute("notice", noticeOneReturnMap.get("notice"));
		if(row!=null) {
		model.addAttribute("noticeFileList", noticeOneReturnMap.get("noticeFileList"));
		}
		log.debug(TeamColor.LHN + "model" + model + TeamColor.TEXT_RESET);

		return "notice/noticeOne";
	}
	
	
	// 공지글 수정 폼
	
	@GetMapping("/loginCheck/modifyNoticeForm") 
	public String updateNoticeOne(Model model, @RequestParam("noticeNo") int noticeNo) {
		log.debug(TeamColor.LHN + "공지글 수정 폼 " + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + noticeNo +  ": noticeNo " + TeamColor.TEXT_RESET);
		// 객체 적용
		Map<String, Object> notice = noticeService.showNoticeOne(noticeNo);
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
			
		// 파일 있을 경우 함께 삭제
		
		return "redirect:/loginCheck/noticeList";
		
	}
	
}
