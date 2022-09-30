package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.mapper.LectureRoomMapper;
import com.gd.lms.mapper.ManagerMapper;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.vo.Lecture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LectureService {
	// LectureMapper 객체 주입
	@Autowired
	private LectureMapper lectureMapper;
	
	// TeacherMapper 객체 주입
	@Autowired
	private TeacherMapper teacherMapper;
	
	// ManagerMapper 객체 주입
	@Autowired
	private ManagerMapper managerMapper;

	@Autowired
	private LectureRoomMapper lectureRoomMapper;
	
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
	
	// 강좌 리스트 가져오는 메소드
	// 파라미터 : X
	// 리턴값 : List<Map<String, Obejct>>
	public List<Map<String, Object>> getLectureDetailList(){
		// Mapper call
		List<Map<String, Object>> lectureDetailList = lectureMapper.selectLectureDetailList();
		// 디버깅
		log.debug(TeamColor.PSJ + lectureDetailList + "<-- lectureDetailList" + TeamColor.TEXT_RESET);
		
		return lectureDetailList;

	}
	
	// 강좌 상세 리스트 가져오는 메소드
	// 파라미터 : lectureName
	// 리턴값 :Map<String, Obejct>
	public Map<String, Object> getLectureOne(String lectureName){
		// Mapper call
		Map<String, Object> lectureOne = lectureMapper.selectLectureOne(lectureName);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureOne + "<-- lectureOne" + TeamColor.TEXT_RESET);
		
		return lectureOne;
		
	}
	
	// 강좌를 개설하기 위한 정보를 가져오는 메소드
	// 파라미터 : X
	// 리턴값 : Map<String, Object> 
	public Map<String, Object> getInfoForAddLecture(){
		// 리턴할 객체 생성
		Map<String, Object> returnInfoMap = new HashMap<>();
		
		// TeacherList 받아오기
		returnInfoMap.put("teacherList", teacherMapper.selectTeacherList());
		// ManagerList 받아오기
		returnInfoMap.put("managerList", managerMapper.selectManagerList());
		// lectureRoomList 받아오기
		returnInfoMap.put("lectureRoomList", lectureRoomMapper.selectLectureRoomList());
		
		return returnInfoMap;
	}
}
