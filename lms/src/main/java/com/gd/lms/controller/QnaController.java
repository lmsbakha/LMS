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
import com.gd.lms.service.QnaService;
import com.gd.lms.vo.QnaAnswer;
import com.gd.lms.vo.QnaQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QnaController {
	@Autowired QnaService qnaService;
	
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
		// 어차피 답변은 상세보기에서만 노출될 것이기 때문에 질문 제목만 불러옴
		List<QnaQuestion> qnaQuestionList = qnaService.getQnaQuestionList();	
		log.debug(TeamColor.LHN + "qnaQuestionList: " + qnaQuestionList + TeamColor.TEXT_RESET);
		
		// model에 데이터 세팅
		model.addAttribute("qnaList", qnaQuestionList);
		model.addAttribute("userLevel", userLevel);
		model.addAttribute("accountId", accountId);

		return "qna/qnaList";
	}
	
	// 질문 상세보기
	@GetMapping("/loginCheck/qnaOne")
	public String QnaOne(Model model, @RequestParam("qnaNo") int qnaNo, HttpServletRequest request) {
		log.debug(TeamColor.LHN + "qna 상세보기" + TeamColor.TEXT_RESET);
		
		// 대기중일 경우 질문만 노출, 답변완료 상태일 경우 답변까지 노출
		boolean state = qnaService.qnaState(qnaNo);
		log.debug(TeamColor.LHN + "답변여부" + state + TeamColor.TEXT_RESET);
		
		QnaQuestion qnaQuestion = qnaService.showQnaQuestionOne(qnaNo);
		log.debug(TeamColor.LHN + "질문: " + qnaQuestion + TeamColor.TEXT_RESET);
		
		if(state==true) { 	// 답변 있을 경우
			log.debug(TeamColor.LHN + "답변 있음" + TeamColor.TEXT_RESET);

			QnaAnswer qnaAnswer = qnaService.showQnaAnswerOne(qnaNo);
			log.debug(TeamColor.LHN + "답변: " + qnaAnswer + TeamColor.TEXT_RESET);	
			
			// model에 담기
			model.addAttribute("qnaAnswer", qnaAnswer);
		}else {				//답변 없을 경우
			log.debug(TeamColor.LHN + "답변 없음" + TeamColor.TEXT_RESET);
		}
		
		HttpSession session = request.getSession();
		int userLevel = (int) session.getAttribute("sessionLevel");
		log.debug(TeamColor.LHN + "userLevel: " + userLevel + TeamColor.TEXT_RESET);
		
		// model에 담기
		model.addAttribute("qnaQuestion", qnaQuestion);
		model.addAttribute("userLevel", userLevel);
		return "qna/qnaOne";
	}
	
	/////////////////////////////////////////////////////
	
	
	// 질문 작성 폼
	@GetMapping("/loginCheck/addQnaQuestion")
	public String addQnaQuestionForm() {
		return "qna/addQnaQuestion";
	}
	
	
	// 질문 작성 액션
	@PostMapping("/loginCheck/addQnaQuestion")
	String addQnaQuestion(Model model,
			@RequestParam("qnaQuestionTitle") String qnaQuestionTitle,
			@RequestParam("qnaQuestionContent") String qnaQuestionContent, 
			HttpSession session, HttpServletRequest request) {
			
		log.debug(TeamColor.LHN + "문의글 작성" + TeamColor.TEXT_RESET);
		QnaQuestion qnaQuestion = new QnaQuestion();
		qnaQuestionContent = qnaQuestionContent.replace("\r\n","<br>");
		log.debug(TeamColor.LHN + "자동 개행 적용" + qnaQuestionContent +  TeamColor.TEXT_RESET);
		
		// 입력 내용 qnaQuestion 적용
		qnaQuestion.setQnaQuestionTitle(qnaQuestionTitle);
		qnaQuestion.setQnaQuestionContent(qnaQuestionContent);	
		
		// 작성자 아이디 담기
		String accountId = (String) session.getAttribute("sessionId");
		qnaQuestion.setAccountId(accountId);
		log.debug(TeamColor.LHN + "accountId: " + accountId +  TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion +  TeamColor.TEXT_RESET);


		// qnaQuestion 적용
		qnaService.addQnaQuestion(qnaQuestion);
		
		// 공지 리스트로
		return "redirect:/loginCheck/QnAList";
	} 
	
	// 질문 수정 폼 => 답변 완료 시 수정 불가, 삭제만 가능
	@GetMapping("/loginCheck/modifyQnaQuestionForm")
	public String modifyQnaQuestionForm(Model model, @RequestParam("qnaNo") int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "질문 수정 폼" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestionNo: " + qnaQuestionNo +  TeamColor.TEXT_RESET);
		
		QnaQuestion qnaQuestion = qnaService.modifyQnaQuestionForm(qnaQuestionNo);
		model.addAttribute("qnaQuestion", qnaQuestion);
		return "qna/modifyQnaQuestion";
	}
	
	// 질문 수정 액션
	@PostMapping("/loginCheck/modifyQnaQuestion")
	public String modifyQnaQuestion(Model model, QnaQuestion qnaQuestion, @RequestParam("qnaQuestionNo") int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "질문 수정 액션" + TeamColor.TEXT_RESET);

		log.debug(TeamColor.LHN + "qnaQuestionNo: " + qnaQuestion.getQnaQuestionNo() + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestionTitle: " + qnaQuestion.getQnaQuestionTitle() + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestionContent: " + qnaQuestion.getQnaQuestionContent() + TeamColor.TEXT_RESET);
		// 본문 자동개행 
		String qnaQuestionContent = qnaQuestion.getQnaQuestionContent().replace("\r\n","<br>");
		log.debug(TeamColor.LHN + "qnaAnswerContent 자동 개행 적용: " + qnaQuestionContent +  TeamColor.TEXT_RESET);
		// qnaQuestion에 담기
		qnaQuestion.setQnaQuestionContent(qnaQuestionContent);
		
		// 쿼리 실행
		qnaService.modifyQnaQuestion(qnaQuestion);
		log.debug(TeamColor.LHN + "수정완료" + TeamColor.TEXT_RESET);
		
		return "redirect:/loginCheck/QnAList";
	}
	
	// 질문 삭제 액션
	@GetMapping("/loginCheck/removeQnaQuestion")
	public String deleteQnaQuestion(@RequestParam(name="qnaNo") int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "질문 삭제 액션" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + qnaQuestionNo +  ": qnaQuestionNo " + TeamColor.TEXT_RESET);
		String qnaQuestionState = qnaService.showQnaQuestionState(qnaQuestionNo);
		log.debug(TeamColor.LHN + qnaQuestionState +  ": qnaState " + TeamColor.TEXT_RESET);
		
		int removeQnaQuestion = qnaService.removeQnaQuestion(qnaQuestionNo);
		log.debug(TeamColor.LHN + removeQnaQuestion+ ": removeQnaQuestion " + TeamColor.TEXT_RESET);
		// 답변 있을 경우 답변 삭제
		if(qnaQuestionState.equals("답변완료")) {
			int removeQnaAnswer	 = 	qnaService.removeQnaAnswer(qnaQuestionNo);
			if(removeQnaAnswer!=0) {
				log.debug(TeamColor.LHN +" 답변 삭제 성공 " + TeamColor.TEXT_RESET);
			}else {
				log.debug(TeamColor.LHN +" 답변 삭제 실패 " + TeamColor.TEXT_RESET);
			}
		}
		
		if(removeQnaQuestion!=0) {
			log.debug(TeamColor.LHN +" 질문 삭제 성공 " + TeamColor.TEXT_RESET);
		}else {
			log.debug(TeamColor.LHN +" 질문 삭제 실패 " + TeamColor.TEXT_RESET);
		}	
		
		return "redirect:/loginCheck/QnAList";
	}
	
	
	/////////////////////////////////////////////////////
	
	
	// 답변 작성 폼		=> X 질문글 상세보기 페이지 하단에 답변 작성/제출 폼 같이 두기로.
	
	// 답변 작성 액션
	@PostMapping("/loginCheck/addQnaAnswer")
	String addQnaAnswer(Model model,
			QnaAnswer qnaAnswer, 
			HttpServletRequest request,
			HttpSession session) {
			
		log.debug(TeamColor.LHN + "답변글 작성" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaAnswer: " + qnaAnswer +  TeamColor.TEXT_RESET);
		
		// 답변제목
		String qnaAnswerTitle = qnaAnswer.getQnaAnswerTitle();
		log.debug(TeamColor.LHN + "qnaAnswerTitle: " + qnaAnswerTitle +  TeamColor.TEXT_RESET);
		
		// 게시글 번호
		String url = request.getHeader("referer");
		int qnaNo = Integer.parseInt(url.substring(45));
		log.debug(TeamColor.LHN + "qnaNo: " + qnaNo +  TeamColor.TEXT_RESET);
		
		// 본문 자동개행 
		String qnaAnswerContent = qnaAnswer.getQnaAnswerContent().replace("\r\n","<br>");
		log.debug(TeamColor.LHN + "qnaAnswerContent 자동 개행 적용: " + qnaAnswerContent +  TeamColor.TEXT_RESET);
		
		qnaAnswer.setQnaAnswerNo(qnaNo);
		qnaAnswer.setQnaAnswerTitle(qnaAnswerTitle);
		qnaAnswer.setQnaAnswerContent(qnaAnswerContent);
		log.debug(TeamColor.LHN + "qnaAnswer: " + qnaAnswer +  TeamColor.TEXT_RESET);
		
		// 계정 레벨 호출=> 접근 권한 설정에 필요
		int userLevel = (int) session.getAttribute("sessionLevel");
		log.debug(TeamColor.LHN + "userLevel: " + userLevel + TeamColor.TEXT_RESET);
		
		// 작성자 아이디 불러와서 담기
		String accountId = (String) session.getAttribute("sessionId");
		qnaAnswer.setAccountId(accountId);
		log.debug(TeamColor.LHN + "accountId: " + accountId +  TeamColor.TEXT_RESET);

		
		// qnaService 적용
		qnaService.addQnaAnswer(qnaAnswer);
		
		// model에 담기
		model.addAttribute("userLevel", userLevel);
		
		// 공지 리스트로
		return "redirect:/loginCheck/QnAList";
	} 
	
	// 답변 수정 폼(질문 내용이 같이 출력되어야 함)
	@GetMapping("/loginCheck/modifyQnaAnswerForm")
	public String modifyQnaAnswerForm(Model model, @RequestParam("qnaNo") int qnaQuestionNo) {
		log.debug(TeamColor.LHN + "질문 수정 폼" + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaQuestionNo: " + qnaQuestionNo +  TeamColor.TEXT_RESET);
		
		// 질문 내용 불러와서 담기
		QnaQuestion qnaQuestion = qnaService.modifyQnaQuestionForm(qnaQuestionNo);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion +  TeamColor.TEXT_RESET);
		
		// 답변 내용 불러와서 담기
		QnaAnswer qnaAnswer = qnaService.modifyQnaAnswerForm(qnaQuestionNo);
		log.debug(TeamColor.LHN + "qnaQuestion: " + qnaQuestion +  TeamColor.TEXT_RESET);
		
		model.addAttribute("qnaQuestion", qnaQuestion);
		model.addAttribute("qnaAnswer", qnaAnswer);
		return "qna/modifyQnaAnswer";
	}
	
	// 답변 수정 액션
	@PostMapping("/loginCheck/modifyQnaAnswer")
	public String modifyQnaAnswer(Model model, QnaAnswer qnaAnswer, @RequestParam("qnaAnswerNo") int qnaAnswerNo) {
		log.debug(TeamColor.LHN + "질문 수정 액션" + TeamColor.TEXT_RESET);

		log.debug(TeamColor.LHN + "qnaAnswerNo: " + qnaAnswer.getQnaAnswerNo() + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaAnswerTitle: " + qnaAnswer.getQnaAnswerTitle() + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "qnaAnswerContent: " + qnaAnswer.getQnaAnswerContent() + TeamColor.TEXT_RESET);
		
		// 본문 자동개행 
		String qnaAnswerContent = qnaAnswer.getQnaAnswerContent().replace("\r\n","<br>");
		log.debug(TeamColor.LHN + "qnaAnswerContent 자동 개행 적용: " + qnaAnswerContent +  TeamColor.TEXT_RESET);
		
		// qnaQuestion에 담기
		qnaAnswer.setQnaAnswerContent(qnaAnswerContent);
		
		// 쿼리 실행
		qnaService.modifyQnaAnswer(qnaAnswer);
		log.debug(TeamColor.LHN + "수정완료" + TeamColor.TEXT_RESET);
		
		return "redirect:/loginCheck/QnAList";
	}
	
	// 답변 삭제 액션
	@GetMapping("/loginCheck/removeQnaAnswer")
	public String deleteQnaAnswer(@RequestParam (name="qnaNo") int qnaAnswerNo) {
		log.debug(TeamColor.LHN + "답변 삭제" + TeamColor.TEXT_RESET);
		
		int removeQnaAnswer = qnaService.removeQnaAnswer(qnaAnswerNo);
		log.debug(TeamColor.LHN + "removeQnaAnswer: " + removeQnaAnswer + TeamColor.TEXT_RESET);
		
		if(removeQnaAnswer!=0) {
			log.debug(TeamColor.LHN +" 삭제 성공 " + TeamColor.TEXT_RESET);
		}else {
			log.debug(TeamColor.LHN +" 삭제 실패 " + TeamColor.TEXT_RESET);
		}
		
		return "redirect:/loginCheck/QnAList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
