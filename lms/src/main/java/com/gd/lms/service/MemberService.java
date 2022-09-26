package com.gd.lms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.EducationMapper;
import com.gd.lms.mapper.StudentMapper;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.vo.Education;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MemberService {
	// StudentMapper 객체 주입
	@Autowired 
	private StudentMapper studentMapper;
	
	// TeacherMapper 객체 주입
	@Autowired
	private TeacherMapper teacherMapper;
	
	// 학생 정보 가져오기
	// 파라미터 : loginId
	// 리턴 값 : educationNo, studentName
	public Map<String, Object> getStudenetInfo(String loginId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + loginId +"<-- loginId" + TeamColor.TEXT_RESET);
		
		//Mapper call
		Map<String, Object> studentInfo = studentMapper.selectStudentInfo(loginId);
		// 디버깅
		log.debug(TeamColor.PSJ + studentInfo +"<-- studentInfo" + TeamColor.TEXT_RESET);
		
		return studentInfo;
	}
	
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
