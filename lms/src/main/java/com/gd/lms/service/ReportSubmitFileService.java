package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ReportSubmitFileService {


	// 학생이 제출한 과제 리스트 조회 메소드
	// 파라미터 : accountId
	// 리턴값 : List<Map<String,Object>>
	List<Map<String,Object>> getReportListById(String accountId){
		
		// 리턴값 받아오는 객체 생성
		
		
		return null;
	}
}
