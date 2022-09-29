package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.QnaService;
import com.gd.lms.vo.QnaQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QnaController {
	@Autowired QnaService qnaService;
	
	// 답변은 질문글 아래에 달리는 답글 형식으로 할지 아니면 댓글처럼 달아둘지?
	// 리스트에서는 답변 여부만 확인, 답변 내용은 상세보기 들어가서 확인하도록
	// 질문 리스트 조회
	@GetMapping("/loginCheck/QnAList")
	public String qnaList(HttpServletRequest request, Model model) {
		log.debug(TeamColor.LHN + "질문게시판 리스트 조회" + TeamColor.TEXT_RESET);	
		
		// userId에 대한 level 가져오기=> model에 담아 view 단에서 접근 권한 설정에 사용
		HttpSession session = request.getSession();
		log.debug(TeamColor.LHN + "session: " + session + TeamColor.TEXT_RESET);	
		
		String accountId = (String)session.getAttribute("sessionId");	
		log.debug(TeamColor.LHN + "accountId: " + accountId + TeamColor.TEXT_RESET);
			
		int userLevel = (int) session.getAttribute("sessionLevel");
		log.debug(TeamColor.LHN + "userLevel: " + userLevel + TeamColor.TEXT_RESET);

		// 리스트 불러오기
		// 어차피 답변은 상세보기에서만 노출될 것이기 때문에 질문만 불러옴
		List<QnaQuestion> qnaList = qnaService.getQnaList();	
		log.debug(TeamColor.LHN + "qnaList: " + qnaList + TeamColor.TEXT_RESET);
			
		// model에 데이터 세팅
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("userLevel", userLevel);
		model.addAttribute("accountId", accountId);

		return "qna/qnaList";
		
	}
	
	// 질문 상세보기
	
	
	/////////////////////////////////////////////////////
	
	
	// 질문 작성 폼
	
	
	// 질문 작성 액션
	
	
	// 질문 수정 폼
	
	
	// 질문 수정 액션
	
	
	// 질문 삭제 액션
	
	
	/////////////////////////////////////////////////////
	
	
	// 답변 작성 폼
	
	
	// 답변 작성 액션
	
	
	// 답변 수정 폼
	
	
	// 답변 수정 액션
	
	
	// 답변 삭제 액션
}
