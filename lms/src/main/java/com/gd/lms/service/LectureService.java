package com.gd.lms.service;

import java.util.List;
import java.util.Map;

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

	// lectureList 가져오는 메소드 
	// 파라미터 : X 
	// 리턴값: List<Lecture>
	public List<Lecture> getLectureListByAccoutId() {
		// LectureMapper에서 lectureList 받아오기
		List<Lecture> lectureListByManager = lectureMapper.selectlectureListByManager();
		// 디버깅
		log.debug(TeamColor.PSJ + lectureListByManager + "<-- lectureListByManager" + TeamColor.TEXT_RESET);
		
		return lectureListByManager;
	}
	
	// lectureList 가져오는 메소드 
	// 파라미터 : accountId 
	// 리턴값: List<Lecture>
	public List<Lecture> getLectureListByAccoutId(String accountId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// LectureMapper에서 lectureList 받아오기
		List<Lecture> lectureListByTeacher = lectureMapper.selectlectureListByTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureListByTeacher + "<-- lectureListByTeacher" + TeamColor.TEXT_RESET);
		return lectureListByTeacher;
	}
	
	// 강좌 상세 리스트 가져오는 메소드
	// 파라미터 : X
	// 리턴값 : List<Map<String, Obejct>>
	public List<Map<String, Object>> getLectureDetailList(){
		// Mapper call
		List<Map<String, Object>> lectureDetailList = lectureMapper.selectLectureDetailList();
		// 디버깅
		log.debug(TeamColor.PSJ + lectureDetailList + "<-- lectureDetailList" + TeamColor.TEXT_RESET);
		
		return lectureDetailList;

	}
}
