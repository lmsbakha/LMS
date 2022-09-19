package com.gd.lms.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureSubjectMapper {
	// lecture와 관련된 subject 가져오기
	// 파라미터 : 강의명(lectureName)
	// 리턴값 : 강의 리스트(Map<String, Object>)
	List<Map<String, Object>> selectLectureSubjectList(String lectureName);
}
