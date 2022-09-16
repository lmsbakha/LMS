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
		paramMultiplechoice.setMultiplechoiceQuestion((String) paramMap.get("multiplechoiceQuestion"));
		paramMultiplechoice.setMultiplechoiceAnswer((String) paramMap.get("multiplechoiceAnswer"));
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoice + "<-- paramMultiplechoice" + TeamColor.TEXT_RESET);

		// MultiplechoiceMapper call
		int addMultiplechoice = multiplechoiceMapper.insertMultiplechoice(paramMultiplechoice);

		// DB에 insert하고 전송받은 Pk값을 지역변수로 저장
		int multiplechioceNo = paramMultiplechoice.getMultiplechoiceNo();
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechioceNo + "<-- multiplechioceNo" + TeamColor.TEXT_RESET);

		// 보기 지문 list에서 넣기
		List<String> paramExampleList = new ArrayList<>();
		paramExampleList.add((String) paramMap.get("answer1"));	//인덱스 0
		paramExampleList.add((String) paramMap.get("answer2"));	//인덱스 1
		paramExampleList.add((String) paramMap.get("answer3"));	//인덱스 2
		paramExampleList.add((String) paramMap.get("answer4"));	//인덱스 3
		paramExampleList.add((String) paramMap.get("answer5"));	//인덱스 4
		
		// MultiplechoiceExampleMapper에 전송할 파라미터를 List로 셋팅
		List<MultiplechoiceExample> paramMultiplechoiceExampleList = new ArrayList<>();
		
		// 해당 문제의 1번 보기
		for (int i = 1; i <= 5; i++) {
			MultiplechoiceExample paramMultiplechoiceExample = new MultiplechoiceExample();
			paramMultiplechoiceExample.setMultiplechoiceNo(multiplechioceNo);
			paramMultiplechoiceExample.setMultiplechoiceExampleId(i+"");
			paramMultiplechoiceExample.setMultiplechoiceExampleContent(paramExampleList.get(i-1));
			paramMultiplechoiceExampleList.add(i-1, paramMultiplechoiceExample);
		}
		
/*
		MultiplechoiceExample paramMultiplechoiceExample = new MultiplechoiceExample();
		paramMultiplechoiceExample.setMultiplechoiceNo(multiplechioceNo);
		paramMultiplechoiceExample.setMultiplechoiceExampleId("1");
		paramMultiplechoiceExample.setMultiplechoiceExampleContent((String) paramMap.get("answer1"));
		paramList.add(0, paramMultiplechoiceExample1);
		// 해당 문제의 2번 보기
		MultiplechoiceExample paramMultiplechoiceExample2 = new MultiplechoiceExample();
		paramMultiplechoiceExample2.setMultiplechoiceNo(multiplechioceNo);
		paramMultiplechoiceExample2.setMultiplechoiceExampleId("2");
		paramMultiplechoiceExample2.setMultiplechoiceExampleContent((String) paramMap.get("answer2"));
		paramList.add(1, paramMultiplechoiceExample2);
		// 해당 문제의 3번 보기
		MultiplechoiceExample paramMultiplechoiceExample3 = new MultiplechoiceExample();
		paramMultiplechoiceExample3.setMultiplechoiceNo(multiplechioceNo);
		paramMultiplechoiceExample3.setMultiplechoiceExampleId("3");
		paramMultiplechoiceExample3.setMultiplechoiceExampleContent((String) paramMap.get("answer3"));
		paramList.add(2, paramMultiplechoiceExample3);
		// 해당 문제의 4번 보기
		MultiplechoiceExample paramMultiplechoiceExample4 = new MultiplechoiceExample();
		paramMultiplechoiceExample4.setMultiplechoiceNo(multiplechioceNo);
		paramMultiplechoiceExample4.setMultiplechoiceExampleId("4");
		paramMultiplechoiceExample4.setMultiplechoiceExampleContent((String) paramMap.get("answer4"));
		paramList.add(3, paramMultiplechoiceExample4);
		// 해당 문제의 5번 보기
		MultiplechoiceExample paramMultiplechoiceExample5 = new MultiplechoiceExample();
		paramMultiplechoiceExample5.setMultiplechoiceNo(multiplechioceNo);
		paramMultiplechoiceExample5.setMultiplechoiceExampleId("5");
		paramMultiplechoiceExample5.setMultiplechoiceExampleContent((String) paramMap.get("answer5"));
		paramList.add(4, paramMultiplechoiceExample5);
		
		// MultiplechoiceExampleMapper에 정상적으로 insert가 되었는지 확인할 변수
		int addMultiplechoiceExample = 0;
*/
		

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
