package com.gd.lms.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceMapper {
	// 강사가 담당하는 클래스 학생들 출석부 가져오기
	// 파라미터 : Map<String, Object> map (accountId, lectureName)
	// 리턴값 : List<Map<String,Object>>
	List<Map<String, Object>> selectAttendanceListByTeacher(Map<String, Object> map);
}
