package com.gd.lms.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gd.lms.service.AccountService;
import com.gd.lms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LectureScheduler {
	// LectureService 객체 주입
	@Autowired
	private LectureService lectureService;

	// 매일 정각마다 lectureState 변경하는 메소드
	// 오늘 날짜를 종강일과 개강일과 비교
	// 대기<-------(개강일)----------수강----------(종강일)--------->수료
	@Scheduled(cron = "0 0 0 * * *")
	public void modifyLectureState() {
		// service call
		int row = lectureService.modifyLectureState();
		// 디버깅
		log.debug(row + "개의 강의의 상태가 변경되었습니다");

	}
}
