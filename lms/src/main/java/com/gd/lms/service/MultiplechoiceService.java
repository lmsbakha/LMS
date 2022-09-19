package com.gd.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MultiplechoiceExampleMapper;
import com.gd.lms.mapper.MultiplechoiceMapper;
import com.gd.lms.vo.Multiplechoice;
import com.gd.lms.vo.MultiplechoiceExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MultiplechoiceService {
	// MultiplechoiceMapper 객체 주입
	@Autowired
	private MultiplechoiceMapper multiplechoiceMapper;
	// MultiplechoiceExampleMapper 객체 주입
	@Autowired
	private MultiplechoiceExampleMapper multiplechoiceExampleMapper;
	
	// 검색어와 관련된 객관식 문제 리스트 가져오기
	// 파라미터 : subjectName 
	// 리턴값 : List<Multiplechoice>
	public List<Map<String, Object>> getMultipleChoiceList(String subjectName){
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + subjectName + "<-- subjectName" + TeamColor.TEXT_RESET);
		// MultiplechoiceMapper call으로 전체 객관식 문제 리스트 가져오기
		List<Map<String, Object>> multiplechoiceList = multiplechoiceMapper.selectMultiplechoiceList(subjectName);
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceList + "<-- multiplechoiceList" + TeamColor.TEXT_RESET);
		return multiplechoiceList;
	}
	
	// 객관식 문제 추가하기
	// 로직 : 객관식 문제 추가 후 multiplechoiceNo을 전송받아서 해당 객관식 문제의 보기들을 추가
	// 파라미터 : Map<String, Object>
	// 리턴값 : 정상적으로 문제와 보기가 추가되었는지 확인할 int
	public int addMultipleChoiceAndExample(Map<String, Object> paramMap) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// MultiplechoiceMapper에 전송할 파라미터 셋팅
		Multiplechoice paramMultiplechoice = new Multiplechoice();
		paramMultiplechoice.setSubjectName((String) paramMap.get("subjectName"));
		paramMultiplechoice.setQuestionTitle((String) paramMap.get("questionTitle"));
		paramMultiplechoice.setQuestionAnswer((String) paramMap.get("questionAnswer"));
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoice + "<-- paramMultiplechoice" + TeamColor.TEXT_RESET);

		// MultiplechoiceMapper call
		int addMultiplechoice = multiplechoiceMapper.insertMultiplechoice(paramMultiplechoice);

		// DB에 insert하고 전송받은 Pk값을 지역변수로 저장
		int questionNo = paramMultiplechoice.getQuestionNo();
		// 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// 전송받은 보기 지문을 list 생성 후 넣기
		List<String> paramExampleList = new ArrayList<>();
		paramExampleList.add((String) paramMap.get("answer1"));	//인덱스 0
		paramExampleList.add((String) paramMap.get("answer2"));	//인덱스 1
		paramExampleList.add((String) paramMap.get("answer3"));	//인덱스 2
		paramExampleList.add((String) paramMap.get("answer4"));	//인덱스 3
		paramExampleList.add((String) paramMap.get("answer5"));	//인덱스 4
		
		// MultiplechoiceExampleMapper에 전송할 파라미터를 List로 셋팅
		List<MultiplechoiceExample> paramMultiplechoiceExampleList = new ArrayList<>();
		
		// 해당 문제의 1
		for (int i = 1; i <= 5; i++) {
			MultiplechoiceExample paramMultiplechoiceExample = new MultiplechoiceExample();
			paramMultiplechoiceExample.setQuestionNo(questionNo);
			paramMultiplechoiceExample.setMultiplechoiceExampleId(i+"");
			paramMultiplechoiceExample.setMultiplechoiceExampleContent(paramExampleList.get(i-1));
			paramMultiplechoiceExampleList.add(i-1, paramMultiplechoiceExample);
		}

		// MultiplechoiceMapper 정상적으로 작동했는지 확인
		if (addMultiplechoice != 0) {
			log.debug(TeamColor.PSJ + "[Success] 정상적으로 객관식 문제가 추가되었습니다. " + TeamColor.TEXT_RESET);
			// MultiplechoiceExampleMapper에서 해당 문제의 보기들 추가
			for (MultiplechoiceExample me : paramMultiplechoiceExampleList) {
				multiplechoiceExampleMapper.insertMultiplechoiceExample(me);
				log.debug(TeamColor.PSJ + "[Success] insertMultiplechoiceExample" + TeamColor.TEXT_RESET);
			}
		} else {
			log.debug(TeamColor.PSJ + "[Fail] 객관식 문제을 추가 실패하였습니다." + TeamColor.TEXT_RESET);
		}
		return addMultiplechoice;
	}
}
