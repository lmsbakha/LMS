package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.vo.Teacher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LectureService {
	@Autowired
	private LectureMapper lectureMapper;

	@Autowired
	private TeacherMapper teacherMapper;

	// 강사가 강의하는 lecture 리스트 가져오기 위한 메소드
	// 파라미터 : 로그인한 강사 아이디(accountId)
	// 리턴값: List<Map<String, Object>>
	public List<Map<String, Object>> getLectureListByTeacher(String accountId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// 계정 아이디로 teacherName 받아오기
		String teacherName = teacherMapper.selectTeacherNameByAccountId(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + teacherName + "<-- teacherName" + TeamColor.TEXT_RESET);
		
		// 강의lecture 리스트 받아오기
		List<Map<String, Object>> lectureListByTeacher = lectureMapper.selectLectureListByTeacher(teacherName);
		// 디버깅
		log.debug(TeamColor.PSJ + lectureListByTeacher + "<-- lectureListByTeacher" + TeamColor.TEXT_RESET);
		
		return lectureListByTeacher;
	}

}
