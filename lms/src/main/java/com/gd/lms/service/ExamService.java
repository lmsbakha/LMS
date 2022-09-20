package com.gd.lms.service;

import java.util.ArrayList;
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

	/*
	 * 시험을 출제하는 메소드 파라미터 : subjectName,
	 * examTitle,examContent,multipleCnt,shortAnswerCnt,examStartDate,examEndDate
	 * 리턴값 : int
	 */
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

		// 객관식 문제 랜덤하게 multipleCnt 만큼 뽑아와서 List에 저장
		Map<String, Object> paramRandom = new HashMap<>();
		paramRandom.put("subjectName", paramMap.get("subjectName"));
		paramRandom.put("multipleCnt", paramMap.get("multipleCnt"));

		List<Map<String, Object>> multiplechoiceExamList = multiplechoiceMapper.selectMultiplechoiceListByRandom(paramRandom);
		// 디버깅
		log.debug(TeamColor.PSJ + multiplechoiceExamList + "<-- multiplechoiceExamList" + TeamColor.TEXT_RESET);

		// 단답형 문제 랜덤하게 뽑아서 리스트에 저장

		// exam_question table에 저장
		for (int i = 1; i <= (int) paramMap.get("multipleCnt"); i++) { //객관식 문제만큼 추가
			Map<String, Object> paramExamQuestionMap = new HashMap<>();
			paramExamQuestionMap.put("examNo", examNo);
			paramExamQuestionMap.put("examQuestionNo", i);
			paramExamQuestionMap.put("questionNo", multiplechoiceExamList.get(i - 1).get("questionNo"));
			examQuestionMapper.insertExamQuestion(paramExamQuestionMap);
			log.debug(TeamColor.PSJ + i + "문제 추가 완료" + TeamColor.TEXT_RESET);
		}
		return 1;
	}

}
