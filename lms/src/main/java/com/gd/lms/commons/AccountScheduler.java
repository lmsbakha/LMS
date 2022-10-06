package com.gd.lms.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gd.lms.service.AccountService;
import com.gd.lms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountScheduler {
	@Autowired AccountService accountService;
	
	@Autowired
	private LectureService lectureService;

	@Scheduled(cron = "0 0 0 * * *")
	public void modifyAccountStateLastLogin() {

		int row = accountService.modifyAccountStateByMemberLastLogin();
		// 디버깅
		log.debug(row + "개의 계정이 휴면처리 되었습니다.");

	}

	@Scheduled(cron = "0 0 0 1 * *")
	public void modifyLectureState() {

		int row = accountService.modifyAccountStateByMemberLastLogin();
		// 디버깅
		log.debug(row + "개의 강의의 상태가 변경되었습니다");

	}
}
