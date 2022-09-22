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
import com.gd.lms.vo.ExamQuestion;
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

	// ExamQuestionMapper 객체 주입
	@Autowired
	private ExamQuestionMapper examQuestionMapper;

	// 객관식 문제 지문 수정하기
	// 파라미터 : Multiplechoice
	// 리턴값 : int
	public int modifyMultiplechoiceOne(Multiplechoice paramMultiplechoice) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoice + "<-- paramMultiplechoice" + TeamColor.TEXT_RESET);

		// Mapper call
		int row = multiplechoiceMapper.updateMultiplechoice(paramMultiplechoice);
		// 결과 디버깅
		if (row != 0) { // 수정에 성공하였을 때
			log.debug(TeamColor.PSJ + "[Success] modifyMultiplechoiceOne 성공 " + TeamColor.TEXT_RESET);
		} else { // 수정 실패했을 때
			log.debug(TeamColor.PSJ + "[Fail] modifyMultiplechoiceOne 실패 " + TeamColor.TEXT_RESET);
		}
		return row;
	}

	// 객관식 문제 및 해당 보기 삭제하기
	// 파라미터 :questionNo
	// 리턴값 : int
	public int removeMultiplechoiceOne(int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// 리턴 변수 선언
		int removeMultiplechoiceCk = 0;

		// exam_question에 multiplechoice 데이터가 포함되어 있으면 FK로 연결되어 있기 때문에 삭제가 안됨 --> exam_question테이블에 데이터가 들어가져있는 확인해야 한다
		int CountCk = examQuestionMapper.selectCountExamQuestion(questionNo);
		// 결과값 디버깅
		if (CountCk != 0) {
			// 디버깅
			log.debug(TeamColor.PSJ + "[Error] exam_question 테이블에 데이터가 있어서 삭제가 불가능합니다. " + TeamColor.TEXT_RESET);
			// 500으로 리턴해서 삭제 실패로 보내기
			return 500;
		}

		// 1. multiplechoiceExample에서 보기 삭제
		int removeMultiplechoiceExampleCk = multiplechoiceExampleMapper
				.deleteMultiplechoiceExampleByQuestionNo(questionNo);
		// 2. multiplechoice에서 문제 삭제
		if (removeMultiplechoiceExampleCk != 0) { // 보기 삭제에 성공했다면
			// 디버깅
			log.debug(TeamColor.PSJ + "[Success] 해당 객관식 문제 보기 삭제 성공" + TeamColor.TEXT_RESET);
			// 해당 객관식 문제 삭제
			removeMultiplechoiceCk = multiplechoiceMapper.deleteMultiplechoiceByQuestionNo(questionNo);
			// 결과 디버깅
			if (removeMultiplechoiceCk != 0) {
				log.debug(TeamColor.PSJ + "[Success] 객관식 문제 삭제 성공" + TeamColor.TEXT_RESET);
			} else {
				log.debug(TeamColor.PSJ + "[Fail] 객관식 문제 삭제 실패" + TeamColor.TEXT_RESET);
				return 0;
			}
		} else { // 객관식 보기 삭제에 실패했다면
			// 디버깅
			log.debug(TeamColor.PSJ + "[Fail] 해당 객관식 문제 보기 삭제 실패" + TeamColor.TEXT_RESET);
			return 0;
		}
		return removeMultiplechoiceCk;
	}

	// 객관식 문제 상세보기
	// 파라미터 : questionNo
	// 리턴값 : Map<String, Object>
	public Map<String, Object> getMultiplechoiceOne(int questionNo) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + questionNo + "<-- questionNo" + TeamColor.TEXT_RESET);

		// 리턴값을 담을 객체 생성
		Map<String, Object> multiplechoiceOne = new HashMap<>();
		// MultiplechoiceMapper에서 객관식 문제 정보 받아오기
		multiplechoiceOne.put("multiplechoiceQuestion", multiplechoiceMapper.selectMultiplechoiceOne(questionNo));
		log.debug(TeamColor.PSJ + "객관식 문제 정보 가져오기 성공" + TeamColor.TEXT_RESET);

		// MultiplechoiceExampleMapper에서 해당 객관식 문제의 보기 지문 받아오기
		multiplechoiceOne.put("multiplechoiceExample",
				multiplechoiceExampleMapper.selectMultiplechoiceExampleList(questionNo));
		log.debug(TeamColor.PSJ + "해당 객관식 문제의 보기 가져오기 성공" + TeamColor.TEXT_RESET);

		return multiplechoiceOne;

	}

	// 검색어와 관련된 객관식 문제 리스트 가져오기
	// 파라미터 : subjectName
	// 리턴값 : List<Multiplechoice>
	public List<Map<String, Object>> getMultipleChoiceList(String subjectName) {
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
		paramExampleList.add((String) paramMap.get("answer1")); // 인덱스 0
		paramExampleList.add((String) paramMap.get("answer2")); // 인덱스 1
		paramExampleList.add((String) paramMap.get("answer3")); // 인덱스 2
		paramExampleList.add((String) paramMap.get("answer4")); // 인덱스 3
		paramExampleList.add((String) paramMap.get("answer5")); // 인덱스 4

		// MultiplechoiceExampleMapper에 전송할 파라미터를 List로 셋팅
		List<MultiplechoiceExample> paramMultiplechoiceExampleList = new ArrayList<>();

		// 해당 문제의 1
		for (int i = 1; i <= 5; i++) {
			MultiplechoiceExample paramMultiplechoiceExample = new MultiplechoiceExample();
			paramMultiplechoiceExample.setQuestionNo(questionNo);
			paramMultiplechoiceExample.setMultiplechoiceExampleId(i + "");
			paramMultiplechoiceExample.setMultiplechoiceExampleContent(paramExampleList.get(i - 1));
			paramMultiplechoiceExampleList.add(i - 1, paramMultiplechoiceExample);
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
