package com.gd.lms.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AdminMapper;
import com.gd.lms.mapper.ManagerMapper;
import com.gd.lms.mapper.MemberFileMapper;
import com.gd.lms.mapper.StudentMapper;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Admin;
import com.gd.lms.vo.Manager;
import com.gd.lms.vo.MemberFile;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.Teacher;

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
	
	// ManagerMapper 객체 주입
	@Autowired
	private ManagerMapper managerMapper;
	
	// AdminMapper 객체 주입
	@Autowired
	private AdminMapper adminMapper;
	
	// MemberFileMapper 객체 주입
	@Autowired 
	private MemberFileMapper memberFileMapper;
	
	// 학생 정보 가져오기
	// 파라미터 : loginId
	// 리턴 값 : educationNo, studentName
	public Map<String, Object> getStudenetInfo(String loginId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + loginId + "<-- loginId" + TeamColor.TEXT_RESET);

		// Mapper call
		Map<String, Object> studentInfo = studentMapper.selectStudentInfo(loginId);
		// 디버깅
		log.debug(TeamColor.PSJ + studentInfo + "<-- studentInfo" + TeamColor.TEXT_RESET);

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

	// 학생 목록
	public List<Student> getStudentList() {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList" + TeamColor.TEXT_RESET);

		List<Student> studentList = studentMapper.selectStudentList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList studentList : " + studentList + TeamColor.TEXT_RESET);

		return studentList;
	}
	
	// 강사 목록
	public List<Teacher> getTeacherList() {
		
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getManagerList" + TeamColor.TEXT_RESET);
		
		List<Teacher> teacherList = teacherMapper.selectTeacherList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList teacherList : " + teacherList + TeamColor.TEXT_RESET);
		
		return teacherList;
		
	}
	
	// 행정 목록
	public List<Manager> getManagerList() {
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getTeacherList" + TeamColor.TEXT_RESET);
		
		List<Manager> managerList = managerMapper.selectManagerList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList teacherList : " + managerList + TeamColor.TEXT_RESET);
		
		return managerList;
	}

	// 멤버 개인정보 상세보기
	public Map<String, Object> getMemberOne(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne account : " + account + TeamColor.TEXT_RESET);

		// accountId 받아오기
		String accountId = account.getAccountId();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne accountId : " + accountId + TeamColor.TEXT_RESET);
		// accountLevel 받아오기
		int accountLevel = account.getAccountLevel();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne accountLevel : " + accountLevel + TeamColor.TEXT_RESET);

		Map<String, Object> memberMap = new HashMap<>();

		if(accountLevel == 1) {
			Student member = studentMapper.selectStudentOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne student member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else if(accountLevel == 2) {
			Teacher member = teacherMapper.selectTeacherOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne teacher member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else if(accountLevel == 3) {
			Manager member = managerMapper.selectManagerOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne manager member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else {
			Admin member = adminMapper.selectAdminOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne admin member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		}

		// 멤버 사진파일 MemberFile

		MemberFile memberFile = memberFileMapper.selectMemberFile(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne memberFile : " + memberFile + TeamColor.TEXT_RESET);
		memberMap.put("memberFile", memberFile);

		return memberMap;
	}
	
	
	
	
	

}
