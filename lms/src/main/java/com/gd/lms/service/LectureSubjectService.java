package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureSubjectMapper;
import com.gd.lms.mapper.TeacherMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LectureSubjectService {
	// LectureSubjectMapper 객체 주입
	@Autowired
	private LectureSubjectMapper lectureSubjectMapper;
	


	// 강사가 강의하는 lecture 리스트 가져오기 위한 메소드
	// 파라미터 : 로그인한 강사 아이디(accountId)
	// 리턴값: List<Map<String, Object>>
	public List<Map<String, Object>> getLectureSubjectList(String lectureName) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + lectureName + "<-- lectureName" + TeamColor.TEXT_RESET);

		// 강의lecture와 관련된 subject 리스트 받아오기
		List<Map<String, Object>> lectureSubjectList = lectureSubjectMapper.selectLectureSubjectList(lectureName);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureSubjectList + "<-- lectureSubjectList" + TeamColor.TEXT_RESET);

		return lectureSubjectList;
	}
}
