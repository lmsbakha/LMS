package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.vo.Lecture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LectureService {
	// LectureMapper 객체 주입
	@Autowired
	private LectureMapper lectureMapper;

	/*
	 * lectureList 가져오는 메소드 파라미터 : accountId 리턴값: List<Lecture>
	 */
	public List<Lecture> getLectureListByAccoutId(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getLectureListByAccoutId Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// LectureMapper에서 lectureList 받아오기
		List<Lecture> lectureListByTeacher = lectureMapper.selectlectureListByTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureListByTeacher + "<-- lectureListByTeacher" + TeamColor.TEXT_RESET);
		return lectureListByTeacher;
	}
}
