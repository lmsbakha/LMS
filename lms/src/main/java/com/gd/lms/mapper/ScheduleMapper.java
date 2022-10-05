package com.gd.lms.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Attendance;
import com.gd.lms.vo.LectureSubject;
import com.gd.lms.vo.Schedule;
import com.gd.lms.vo.ScheduleCalendar;

@Mapper
public interface ScheduleMapper {
	
	// lectureSubjectNo를 이용해 scheduleNo 받아오기
	int selectScheduleNoByLectureSubjectNo(Schedule schedule);
	
	// 강의 과목 리스트 받아오기
	List<LectureSubject> selectLectureSubjectList();
	
	// 강사 담당하고있는 강의명
	String selectLectureNameByTeacher(String teacher);
	
	// 학생 수강중인 강의명
	String selectLectureNameByStudent(String student);
	
	// 전체 시간표 리스트 받아오기
	List<ScheduleCalendar> selectScheduleList(Map<String,Object> map);
	
	// 학생 본인 시간표 리스트 받아오기
	List<ScheduleCalendar> selectScheduleListByStudent(Map<String,Object> map);
	
	// 강사 본인 시간표 리스트 받아오기
	List<ScheduleCalendar> selectScheduleListByTeacher(Map<String,Object> map);
	
	// 시간표 상세보기
	Map<String, Object> selectScheduleOne(int scheduleNo);
	
	// 시간표 강의 받아오기
	String selectLectureName(int lectureSubjectNo);
	
	// 시간표 일정 추가 하기
	int insertSchedule(Schedule schedule);
	
	// 시간표 일정 중복확인 하기
	List<Schedule> selectCheckScheduleList(Schedule schedule);
	
	// 시간표 일정 수정 하기
	int updateSchedule(Schedule schedule);
	
	// 시간표 일정 삭제 하기
	int deleteSchedule(int scheduleNo);
	
	// 출결 추가하기
	int insertAttendance(Attendance attendance);
	
	// 출결 삭제하기
	int deleteAttendance(int scheduleNo);
	
	// 해당강의 출석 학생리스트
	List<Integer> selectStudentEducationListByAttendance(String lectureName);
	
}
