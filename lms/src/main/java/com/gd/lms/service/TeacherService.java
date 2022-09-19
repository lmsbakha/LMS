package com.gd.lms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.TeacherMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;

	// 로그인한 아이디와 연관된 강사정보
	// 파라미터 : accoutnId
	// 리턴값 : Map<String, Object> teacherName, lectureName, lectureActive,
	// lectureStartDate, lectureEndDate 받아오기
	public Map<String, Object> getInfoAboutTeacher(String accountId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// Mapper call
		Map<String, Object> infoAboutTeacher = teacherMapper.selectInfoAboutTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + infoAboutTeacher + "<-- infoAboutTeacher" + TeamColor.TEXT_RESET);
		return infoAboutTeacher;
	};
}
