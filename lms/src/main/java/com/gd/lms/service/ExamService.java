package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ExamMapper;
import com.gd.lms.mapper.ExamQuestionMapper;
import com.gd.lms.mapper.MultiplechoiceMapper;
import com.gd.lms.mapper.ShortAnswerQuestionMapper;
import com.gd.lms.vo.Exam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ExamService {
	// ExamMapper 객체 주입
	@Autowired
	private ExamMapper examMapper;

	// MultiplechoiceMapper 객체 주입
	@Autowired
	private MultiplechoiceMapper multiplechoiceMapper;

	//ExamQuestionMapper 객체 주입
	@Autowired
	private ExamQuestionMapper examQuestionMapper;

	// ShortAnswerQuestionMapper 객체 주입
	@Autowired
	private ShortAnswerQuestionMapper shortAnswerQuestionMapper;

	// lecture에 출제된 ExamList
	// 파라미터 : lectureName
	// 리턴값 : List<Map<String, Object>>
	public List<Map<String, Object>> getExamListByLecture(String lectureName) {
		//파라미터 디버깅
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// ExamMapper에서 examList 가져오기
		List<Map<String, Object>> examListByLecture = examMapper.selectExamListByLecture(lectureName);
		// 디버깅
		log.debug(TeamColor.PSJ + examListByLecture + "<-- examListByLecture" + TeamColor.TEXT_RESET);

		return examListByLecture;
	}

	// 시험을 출제하는 메소드 
	// 파라미터 : subjectName,examTitle,examContent,multipleCnt,shortAnswerCnt,examStartDate,examEndDate
	// 리턴값 : int
	public int addExam(Map<String, Object> paramMap) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<-- paramMap" + TeamColor.TEXT_RESET);

		// ExamMapper에 전송할 파라미터 생성
		Exam paramExam = new Exam();
		paramExam.setSubjectName((String) paramMap.get("subjectName"));
		paramExam.setExamTitle((String) paramMap.get("examTitle"));
		paramExam.setExamContent((String) paramMap.get("examContent"));
		paramExam.setExamStartDate((String) paramMap.get("examStartDate"));
		paramExam.setExamEndDate((String) paramMap.get("examEndDate"));
		// 디버깅
		log.debug(TeamColor.PSJ + paramExam + "<-- paramExam" + TeamColor.TEXT_RESET);

		// Exam 테이블에 추가 후 PK 값 받아오기
		int addExam = examMapper.insertExam(paramExam);
		if (addExam != 0) {
			log.debug(TeamColor.PSJ + "[Success] exam 테이블 inserExam 성공" + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PSJ + "[Fail] exam 테이블 inserExam 실패" + TeamColor.TEXT_RESET);
			return 0;
		}
		// insert 후에 저장된 examNo 값 가져오기
		int examNo = paramExam.getExamNo();
		// 디버깅
		log.debug(TeamColor.PSJ + examNo + "<-- examNo" + TeamColor.TEXT_RESET);
		
		//---------------------------------------------------------------------------객관식
		// multiplechoiceMapper로 전달할 파라미터 객체 생성
		Map<String, Object> paramMultiplechoiceRandom = new HashMap<>();
		paramMultiplechoiceRandom.put("subjectName", paramMap.get("subjectName"));
		paramMultiplechoiceRandom.put("multipleCnt", paramMap.get("multipleCnt"));
		// 디버깅
		log.debug(TeamColor.PSJ + paramMultiplechoiceRandom + "<-- paramRandom" + TeamColor.TEXT_RESET);
		
		// 객관식 문제 랜덤하게 multipleCnt 만큼 뽑아와서 List에 저장
		List<Map<String, Object>> multiplechoiceExamList = multiplechoiceMapper.selectMultiplechoiceListByRandom(paramMultiplechoiceRandom);
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceExamList + "<-- multiplechoiceExamList" + TeamColor.TEXT_RESET);

		//---------------------------------------------------------------------------단답형
		// ShortAnswerQuestionMapper로 전달할 파라미터 객체 생성
		Map<String, Object> paramShortAnswerQuestionRandom = new HashMap<>();
		paramShortAnswerQuestionRandom.put("subjectName", paramMap.get("subjectName"));
		paramShortAnswerQuestionRandom.put("shortAnswerCnt", paramMap.get("shortAnswerCnt"));
		// 디버깅
		log.debug(TeamColor.PSJ + paramShortAnswerQuestionRandom + "<-- paramRandom" + TeamColor.TEXT_RESET);
		
		// 단답형 문제 랜덤하게 뽑아서 리스트에 저장
		List<Map<String, Object>> shortAnswerQuestionExamList = shortAnswerQuestionMapper.getShortAnswerQuestionListByRandom(paramShortAnswerQuestionRandom);
		// 디버깅
		log.debug(TeamColor.PSJ + shortAnswerQuestionExamList + "<-- shortAnswerQuestionExamList" + TeamColor.TEXT_RESET);

		// 디버깅
		log.debug(TeamColor.PSJ +"------exam_question에 문제 추가 시작------" + TeamColor.TEXT_RESET);
		// 문제은행에서 뽑아온 객관식 문제 리스트를 exam_question table에 저장
		for (int i = 1; i <= (int) paramMap.get("multipleCnt"); i++) { //객관식 문제만큼 추가
			Map<String, Object> paramExamQuestionMap = new HashMap<>();
			paramExamQuestionMap.put("examNo", examNo);
			paramExamQuestionMap.put("examQuestionNo", i);
			paramExamQuestionMap.put("questionNo", multiplechoiceExamList.get(i - 1).get("questionNo"));
			paramExamQuestionMap.put("questionType", "객관식");
			examQuestionMapper.insertExamQuestion(paramExamQuestionMap);
			log.debug(TeamColor.PSJ + i + "문제 추가 완료" + TeamColor.TEXT_RESET);
		}
		// 문제은행에서 뽑아온 단답형 문제 리스트를 exam_question table에 저장
		int j = 0;
		for (int i = 1 + (int) paramMap.get("multipleCnt"); i <= 10; i++) { //단답형 문제만큼 추가
			Map<String, Object> paramExamQuestionMap = new HashMap<>();
			paramExamQuestionMap.put("examNo", examNo);
			paramExamQuestionMap.put("examQuestionNo", i);
			paramExamQuestionMap.put("questionNo", shortAnswerQuestionExamList.get(j++).get("questionNo"));
			log.debug(TeamColor.PSJ + j + "<-- j 인덱스" + TeamColor.TEXT_RESET);
			paramExamQuestionMap.put("questionType", "단답형");
			examQuestionMapper.insertExamQuestion(paramExamQuestionMap);
			log.debug(TeamColor.PSJ + i + "문제 추가 완료" + TeamColor.TEXT_RESET);
		}
		// 디버깅
		log.debug(TeamColor.PSJ +"------exam_question에 문제 추가 완료------" + TeamColor.TEXT_RESET);
		return 1;
	}

}
