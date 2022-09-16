package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.SubjectMapper;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class SubjectService {
	// SubjectMapper 객체 주입
	@Autowired private SubjectMapper subjectMapper;
	
	// 전체 과목 리스트 가져오기 위한 메소드
	// 파라미터 : X
	// 리턴값: List<Subject>
	public List<Subject> getSubjectList(){
		//리턴값
		List<Subject> subjectList = subjectMapper.selectSujectList();
		log.debug(TeamColor.PSJ+ subjectList +"<-- subjectList"+ TeamColor.TEXT_RESET);
		return subjectList;
	}
}
