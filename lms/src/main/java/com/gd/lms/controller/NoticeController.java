package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.NoticeFileService;
import com.gd.lms.service.NoticeService;
import com.gd.lms.vo.Notice;
import com.gd.lms.vo.NoticeFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	NoticeFileService noticeFileService;
	
	// 공지 리스트 페이지
	@GetMapping("/loginCheck/noticeList")
	public String noticeList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		log.debug(TeamColor.PSY + "게시글 리스트 조회" + TeamColor.TEXT_RESET);
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
	String addNotice(Model model,
			@RequestParam("noticeTitle") String noticeTitle,
			@RequestParam("noticeContent") String noticeContent, 
			NoticeFile noticeFile,
			HttpSession session) {
		log.debug(TeamColor.PSY + "게시글 작성" + TeamColor.TEXT_RESET);

		// 입력 내용 notice 적용
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		// 작성자 아이디 담기
		String accountId = (String) session.getAttribute("sessionId");
		notice.setAccountId(accountId);
		log.debug(TeamColor.LHN + "accountId" + accountId +  TeamColor.TEXT_RESET);
		
		log.debug(TeamColor.LHN + "paramNotice" + notice +  TeamColor.TEXT_RESET);
		int addNotice = noticeService.addNotice(notice);
		if (addNotice != 0) {// 작성 성공
			log.debug(TeamColor.LHN + "게시글 등록 성공" + TeamColor.TEXT_RESET);
		} else {// 작성 실패
			log.debug(TeamColor.LHN + "게시글 등록 실패" + TeamColor.TEXT_RESET);
		}
		
		// 첨부파일 있을 경우 addNoticeFile 실행, 이미지 저장
		if(noticeFile!=null) {
			// 파일 담을 경로
			String path = session.getServletContext().getRealPath("/notice/noticeFile/"); 
			int row = noticeFileService.addNoticeFile(noticeFile, path);
			
			log.debug(TeamColor.LHN + "파일 첨부: " + row + TeamColor.TEXT_RESET);
			return "redirect:/loginCheck/getNoticeListByPage";
					
		}
		// 공지 리스트로
		return "redirect:/loginCheck/noticeList";
	} 
	
	// 파일 업로드 기능 - 추후 addNotice컨트롤러와 합칠 예정
	/* 
	@ResponseBody
	@RequestMapping(value ="/file_uploads", method=RequestMethod.POST, 
	                  produces = "application/json;charset=UTF-8")
	  public  Map<String, List<Map<String, String>>> file_uploads(MultipartFile nfile,MultipartHttpServletRequest  request)throws Exception{
		
		String uid=null;
		Map<String, String[]> paramMap1=request.getParameterMap();
		 Iterator keyData1 = paramMap1.keySet().iterator();	
	    while (keyData1.hasNext()) {
	        String key = ((String)keyData1.next());
	        String[] value = paramMap1.get(key);
	        log.debug(TeamColor.LHN + "key: " + key + "value: " + value[0].toString() );
	        if(key.equals("uid"))
	        {
	        	uid=value[0].toString().trim();
	        }
	    }    
		Map <String, MultipartFile > paramMap = request.getFileMap ();
		 Iterator<String> keyData = paramMap.keySet().iterator();
		 CommonData dto = new CommonData();
		 
		 Map<String, List<Map<String, String>>> result = new HashMap<>();
		 List<Map<String, String>> data_list = new ArrayList();
		 
	    while (keyData.hasNext()) {
	    	Map<String, String> data = new HashMap<>();
	        String key = ((String)keyData.next());
	        MultipartFile file = paramMap.get(key);
	        
	        file_upload_ex(dto, data, file,uid);  //return ResponseEntity.ok().body(result);
	        data_list.add(data);
	        dto.clear();
	    }
	    result.put("data", data_list);
	    return result;
	  }
	
	
	 */
	
	
	
	
	
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
			
		// 파일 있을 경우 함께 삭제
		
		return "redirect:/loginCheck/noticeList";
		
	}
	
}
