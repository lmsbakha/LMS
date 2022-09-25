package com.gd.lms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ExamQuestionMapper;
import com.gd.lms.mapper.MultiplechoiceExampleMapper;
import com.gd.lms.mapper.MultiplechoiceMapper;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;
import com.gd.lms.vo.ExamQuestion;
import com.gd.lms.vo.ShortAnswerQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ExamQuestionSerivce {
	// ExamQuestionMapper 객체 주입
	@Autowired 
	private ExamQuestionMapper examQuestionMapper;
	
	// MultiplechoiceMapper 객체 주입
	@Autowired
	private MultiplechoiceMapper multiplechoiceMapper;
	
	// MultiplechoiceExampleMapper 객체 주입
	@Autowired
	private MultiplechoiceExampleMapper multiplechoiceExampleMapper;
	
	// ShortAnswerQuestionMapper 객체 주입
	@Autowired
	private ShortAnswerQuestionMapper shortanswerQuestionMapper;
	
	public List<Map<String, Object>> getExamByExamNo(int examNo){
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + examNo + "<-- examNo" + TeamColor.TEXT_RESET);
		
		// exam_question에서 examNo가 특정값인 리스트를 가져온다
		List<ExamQuestion> examQuestionsByExamNo = examQuestionMapper.selectExamQuestionByExamNo(examNo);
		// 디버깅
		log.debug(TeamColor.PSJ + examQuestionsByExamNo + "<-- examQuestionsByExamNo" + TeamColor.TEXT_RESET);
		
		// 리턴할 객체 생성
		List<Map<String, Object>> examOne = new ArrayList<>();
		// 객관식 주관식 나눠서 
		for(ExamQuestion examQuestion : examQuestionsByExamNo) {
			// add할 객체 생성
			Map<String, Object> map = new HashMap<>();
			// 문제 타입에 따라서 다른 Mapper를 call
			if(examQuestion.getQuestionType().equals("객관식")) {
				log.debug(TeamColor.PSJ + "----------- 객관식" + TeamColor.TEXT_RESET);
				Map<String, Object> selectMultiplechoiceOneMap =  multiplechoiceMapper.selectMultiplechoiceOne(examQuestion.getQuestionNo());
				// 객관식 문제와 정답 map에 담기
				map.put("examQuestionNo", examQuestion.getExamQuestionNo());	//1~10번 중 몇 번 문제인지
				map.put("questionNo", selectMultiplechoiceOneMap.get("questionNo"));
				map.put("questionType", "객관식");
				map.put("questionTitle", selectMultiplechoiceOneMap.get("questionTitle"));
				map.put("questionAnswer", selectMultiplechoiceOneMap.get("questionAnswer"));
				// 객관식 보기 담기
				map.put("multiplechoiceExampleList", multiplechoiceExampleMapper.selectMultiplechoiceExampleList(examQuestion.getQuestionNo()));
				// 디버깅
				log.debug(TeamColor.PSJ + map + "<-- map" + TeamColor.TEXT_RESET);
			
				// 리턴값 객체에 추가하기 
				examOne.add(map);
				// 디버깅
				log.debug(TeamColor.PSJ +"examOne add 성공" + TeamColor.TEXT_RESET);
			} else if(examQuestion.getQuestionType().equals("단답형")) {
				log.debug(TeamColor.PSJ + "----------- 단답형" + TeamColor.TEXT_RESET);
				ShortAnswerQuestion paramShortAnswerQuestion = shortanswerQuestionMapper.selectShortAnswerQuestionOne(examQuestion.getQuestionNo());
				// 단답형 문제 담기
				map.put("examQuestionNo", examQuestion.getExamQuestionNo());	//1~10번 중 몇 번 문제인지
				map.put("questionNo", paramShortAnswerQuestion.getQuestionNo());
				map.put("questionType", "단답형");
				map.put("questionTitle", paramShortAnswerQuestion.getQuestionTitle());
				map.put("questionAnswer", paramShortAnswerQuestion.getQuestionAnswer());
				// 디버깅
				log.debug(TeamColor.PSJ + map + "<-- map" + TeamColor.TEXT_RESET);
				
				// 리턴값 객체에 추가하기 
				examOne.add(map);
				// 디버깅
				log.debug(TeamColor.PSJ +"examOne add 성공" + TeamColor.TEXT_RESET);
			}
		}
		return examOne;
	}
}
