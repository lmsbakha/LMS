package com.gd.lms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.ScheduleMapper;
import com.gd.lms.vo.Attendance;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Schedule;
import com.gd.lms.vo.ScheduleCalendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class ScheduleService {
	// ScheduleMapper 객체 주입
	@Autowired
	private ScheduleMapper scheduleMapper;

	// 시간표 리스트
	public Map<String, Object> getScheduleList(int year, int month, String accountId, int accountLevel) {

		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleList year : " + year + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList month : " + month + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList year : " + year + TeamColor.TEXT_RESET);

		Calendar cal = Calendar.getInstance(); // 오늘 날짜 ex) 2022.10.02

		// year, month 변수 데이터 변환
		if (year == -1) {
			year = cal.get(Calendar.YEAR); // 받아온 값이 null 이면 현재 년도 입력
		}
		if (month == -1) {
			month = cal.get(Calendar.MONTH) + 1; // 받아온 값이 null 이면 현대 달을 입력
		}
		if (month == 0) { // 0월은 작년 12월이랑 같다
			year--; // 현재 년수에서 -1
			month = 12; // 1월에서 작년 12월로 가기때문에 달은 12로 변경
		}
		if (month == 13) { // 13월은 다음년 1월이랑 같다
			year++; // 현재 년수에서 +1
			month = 1; // 13월은 없기때문에 12월에서 다시 1월로 변경
		}
		// 유효성 검사 날짜가 맞지 않는다면 현재 년월을 입력받는다.
		if (year <= 0 || month < 1 || month > 12) {
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1; // 자바 달력API는 1월을 0으로, 2월을 1로 설정하기 때문에 1을 더해준다
		}

		// 1일의 요일과 그달의 마지막날짜
		// 날짜를 1일로 바꾼다
		cal.set(year, month - 1, 1); // 달력API 는 1~12월이 아닌 0~11이기 때문에 -1해준다
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일을 알려둔다 1~7 일월화수목금토
		int lastDay = cal.getActualMaximum(Calendar.DATE); // 해당 달의 마지막 날짜

		// 시작시 필요한 공백 달력테이블 <td>의 갯수 구하기
		// startBlank
		int startBlank = dayOfWeek - 1;
		// endBlank
		int endBlank = 0;
		// endBlank가 생기는 경우
		if ((startBlank + lastDay) % 7 != 0) {
			endBlank = 7 - ((startBlank + lastDay) % 7);
		}
		// 달력의 전체 td갯수
		int totalBlank = startBlank + endBlank + lastDay; // 현재 월의 td갯수를 위해 더해준다

		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleList dayOfWeek : " + dayOfWeek + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList lastDay : " + lastDay + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList startBlank : " + startBlank + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList endBlank : " + endBlank + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "getScheduleList startBlank : " + totalBlank + TeamColor.TEXT_RESET);

		Map<String, Object> mapperMap = new HashMap<>();
		if (accountLevel >= 3) { // map담아서 보내주는데 레벨값에 따라 보내는 값이 다름
			mapperMap.put("year", year);
			mapperMap.put("month", month);
		} else {
			mapperMap.put("year", year);
			mapperMap.put("month", month);
			mapperMap.put("accountId", accountId);
		}
		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleList mapperMap : " + mapperMap + TeamColor.TEXT_RESET);

		// mapper로 모델값 추출하기
		String lectureName = "";
		List<ScheduleCalendar> scheduleList = new ArrayList<ScheduleCalendar>();
		if (accountLevel >= 3) {
			scheduleList = scheduleMapper.selectScheduleList(mapperMap);
		} else {
			if (accountLevel == 1) {
				scheduleList = scheduleMapper.selectScheduleListByStudent(mapperMap);
				lectureName = scheduleMapper.selectLectureNameByStudent(accountId);
			} else {
				scheduleList = scheduleMapper.selectScheduleListByTeacher(mapperMap);
				lectureName = scheduleMapper.selectLectureNameByTeacher(accountId);
			}
		}
		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleList ScheduleList : " + scheduleList + TeamColor.TEXT_RESET);

		// 강의 과목 리스트
		List<LectureSubject> lectureSubjectList = scheduleMapper.selectLectureSubjectList();
		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleList lectureSubjectList : " + lectureSubjectList + TeamColor.TEXT_RESET);

		Map<String, Object> map = new HashMap<>();
		map.put("scheduleList", scheduleList);
		map.put("lectureSubjectList", lectureSubjectList);
		map.put("lectureName", lectureName);
		map.put("year", year);
		map.put("month", month);
		map.put("lastDay", lastDay);
		map.put("startBlank", startBlank);
		map.put("endBlank", endBlank);
		map.put("totalBlank", totalBlank);

		return map;

	}

	// 시간표 상세보기
	public Map<String, Object> getScheduleOne(int scheduleNo) {

		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleOne scheduleNo : " + scheduleNo + TeamColor.TEXT_RESET);

		Map<String, Object> lsMap = new HashMap<>();
		lsMap = scheduleMapper.selectScheduleOne(scheduleNo);
		// 디버깅
		log.debug(TeamColor.PCW + "getScheduleOne lsMap : " + lsMap + TeamColor.TEXT_RESET);

		return lsMap;
	}

	// 시간표 추가하기
	public int addSchedule(Date scheduleStartDate, Date scheduleEndDate, int lectureSubjectNo) {

		// 디버깅
		log.debug(TeamColor.PCW + "addSchedule scheduleStartDate : " + scheduleStartDate + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "addSchedule scheduleStartDate : " + scheduleEndDate + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "addSchedule scheduleStartDate : " + lectureSubjectNo + TeamColor.TEXT_RESET);

		// 날짜끼리의 차이 구하기
		
		long diff = scheduleEndDate.getTime() - scheduleStartDate.getTime(); // 나열된 시간은 millisecond 즉 1/1000초를 나타냄 1970년
																				// 1월 1일 자정을 기준으로 함참고로 음수가 나타날 경우 1970년
																				// 이전을 의미
		// TimeUnit(시간데이터가 없으니 입력해야 쓸수 있다.)쓰는 방식이 이러니 왜 이거냐 물음X convert에서(diff를
		// MILLISECONDS로 들고 오겠다.) 다시 1분단위로으로 변환
		// 즉 CONVERT 함수는 데이터를 다른 유형으로 변환할 때 사용하는 함수
		long diffMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);

		// 분으로 계산되어서 나누어주기
		int diffDay = (int) (diffMinutes / (60 * 24));

		int row = 0; // 리턴할 변수생성

		for (int i = 0; i <= diffDay; i++) {

			Calendar cal = Calendar.getInstance(); // 캘린더 선언

			cal.setTime(scheduleStartDate); // Date날짜를 캘린더로 변환

			cal.add(Calendar.DATE, i); // 캘린더에 날짜를 i만큼 더해준다
			// 디버깅
			log.debug(TeamColor.PCW + "addSchedule cal : " + cal + TeamColor.TEXT_RESET);

			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 주말을 제외하기 위해 선언
			// 디버깅
			log.debug(TeamColor.PCW + "addSchedule dayOfWeek : " + dayOfWeek + TeamColor.TEXT_RESET);

			if (dayOfWeek != 1 && dayOfWeek != 7) { // 토 or 일 아니면
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 타입변환을 하기위해
				String scheduleDate = format.format(cal.getTime()); // String으로 타입 변환
				// 디버깅
				log.debug(TeamColor.PCW + "addSchedule scheduleDate : " + scheduleDate + TeamColor.TEXT_RESET);

				// 시간표 중복확인
				Schedule scheduleCheck = new Schedule();
				scheduleCheck.setScheduleDate(scheduleDate);
				scheduleCheck.setLectureSubjectNo(lectureSubjectNo);
				List<Schedule> check = scheduleMapper.selectCheckScheduleList(scheduleCheck);
				// 디버깅
				log.debug(TeamColor.PCW + "addSchedule check : " + check + TeamColor.TEXT_RESET);

				if (check.size() == 0) {
					Schedule schedule = new Schedule();
					schedule.setScheduleDate(scheduleDate);
					schedule.setLectureSubjectNo(lectureSubjectNo);
					row = scheduleMapper.insertSchedule(schedule);
					// 디버깅
					log.debug(TeamColor.PCW + "addSchedule row : " + row + TeamColor.TEXT_RESET);
					log.debug(TeamColor.PCW + "addSchedule schedule : " + schedule + TeamColor.TEXT_RESET);

					// 해당날짜에 출석입력하기 위해 강의명 받아오기
					String lectureName = scheduleMapper.selectLectureName(lectureSubjectNo);
					// 디버깅
					log.debug(TeamColor.PCW + "addSchedule lectureName : " + lectureName + TeamColor.TEXT_RESET);
					// 해당강의 출석 명단 뽑기
					List<Integer> studentAttendanceList = scheduleMapper
							.selectStudentEducationListByAttendance(lectureName);
					// 디버깅
					log.debug(TeamColor.PCW + "addSchedule studentAttendanceList : " + studentAttendanceList
							+ TeamColor.TEXT_RESET);
					// 출석입력
					int attendanceCheck = 0;
					for (int j = 0; j < studentAttendanceList.size(); j++) {
						Attendance attendance = new Attendance();
						attendance.setScheduleNo(schedule.getScheduleNo());
						attendance.setEducationNo(studentAttendanceList.get(j));
						scheduleMapper.insertAttendance(attendance);
						attendanceCheck++;
					}
					// 디버깅
					log.debug(
							TeamColor.PCW + "addSchedule attendanceCheck : " + attendanceCheck + TeamColor.TEXT_RESET);

					if (row == 1) {
						log.debug(TeamColor.PCW + "addSchedule 성공" + studentAttendanceList + TeamColor.TEXT_RESET);
					} else {
						log.debug(TeamColor.PCW + "addSchedule 실패" + studentAttendanceList + TeamColor.TEXT_RESET);
					}
				}
			}
		}
		return row;
	}

	// 시간표 수정
	public int modifySchedule(Schedule schedule) {
		
		// 디버깅
		log.debug(TeamColor.PCW + " modifySchedule scheduleNo : " + schedule + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + " modifySchedule scheduleNo : " + scheduleMapper.selectScheduleNoByLectureSubjectNo(schedule) + TeamColor.TEXT_RESET);
		schedule.setScheduleNo(scheduleMapper.selectScheduleNoByLectureSubjectNo(schedule)); 
		
		int row = scheduleMapper.updateSchedule(schedule);
		
		if(row == 1) {
			log.debug(TeamColor.PCW + " modifySchedule scheduleNo 수정 성공" + TeamColor.TEXT_RESET);
		} else {
			log.debug(TeamColor.PCW + " modifySchedule scheduleNo 수정 실패" + TeamColor.TEXT_RESET);
		}
		
		return row;
		
	}

}
