package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MultiplechoiceExampleMapper;
import com.gd.lms.vo.MultiplechoiceExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MultiplechoiceExampleService {
	// MultiplechoiceExampleMapper 객체 주입
	@Autowired
	private MultiplechoiceExampleMapper multiplechoiceExampleMapper;

	// 해당 문제의 보기 리스트 가져오기
	// 파라미터 : questionNo
	// 리턴값 : List<MultiplechoiceExample>
	public List<MultiplechoiceExample> getMultiplechoiceExampleListByQuestionNo(int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// Mapper에서 리스트 받아오기
		List<MultiplechoiceExample> MultiplechoiceListByQuestionNo = multiplechoiceExampleMapper.selectMultiplechoiceExampleList(questionNo);
		// 디버깅
		log.debug(TeamColor.PSJ + MultiplechoiceListByQuestionNo + "<-- MultiplechoiceListByQuestionNo" + TeamColor.TEXT_RESET);

		return MultiplechoiceListByQuestionNo;
	}

	// 보기 지문 수정하기
	// 파라미터 : multiplechoiceExample
	// 리턴값 : int
	public int modifyMultiplechoiceExample(MultiplechoiceExample multiplechoiceExample) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceExample + "<-- multiplechoiceExample" + TeamColor.TEXT_RESET);

		//Mapper call
		int row = multiplechoiceExampleMapper.updateMultiplechoiceExample(multiplechoiceExample);
		// 디버깅
		log.debug(TeamColor.PSJ + row + "<-- 보기 지문 수정 확인(1: 작동)" + TeamColor.TEXT_RESET);
		return row;
	}
}
