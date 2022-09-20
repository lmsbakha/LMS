package com.gd.lms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ReportSubmitMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ReportSubmitService {
	@Autowired
	// ReportSubmitMapper 객체 주입
	ReportSubmitMapper reportSubmitMapper;

	
}
