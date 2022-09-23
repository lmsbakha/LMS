package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.EducationMapper;
import com.gd.lms.vo.Education;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class EducationService {
	// EducationMapper 객체 주입
	@Autowired
	EducationMapper educationMapper;

	// 계정 1 정보 조회
	// 파라미터 : accountId
	// 리턴값 : Education
	public Education getEducationInfo(String accountId) {
		// 디버깅 영역구분
		log.debug(TeamColor.PSY + "\n\n@getEducationInfo Service" + TeamColor.TEXT_RESET);
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + accountId + "<-- accountId" + TeamColor.TEXT_RESET);
		
		// Mapper Call
		Education education = educationMapper.selectEducationInfo(accountId);
		// education값 디버깅
		log.debug(TeamColor.PSY + education + "<-- education" + TeamColor.TEXT_RESET);	
		
		return education;
	} // end getEducationInfo
}
