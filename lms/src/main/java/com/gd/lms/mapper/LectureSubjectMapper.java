package com.gd.lms.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LectureSubject;

@Mapper
public interface LectureSubjectMapper {
	// lecture와 관련된 subject 가져오기
	// 파라미터 : 강의명(lectureName)
	// 리턴값 : 강의 리스트(Map<String, Object>)
	List<Map<String, Object>> selectLectureSubjectList(String lectureName);
	
	/*
	 * 강사와 관련된 강의 리스트 정보 받아오기
	 * 파라미터 : 강사 아이디 accountId
	 * 리턴값 : 강사와 관련된 강의 정보 List<LectureSubject>
	 * lectureSubjectList.jsp
	 */
	List<LectureSubject> lectureSubjectInfoByTeacher(String accountId);
	
	/*
	 * 학생과 관련된 강의 리스트 정보 받아오기
	 * 파라미터 : 학생 아이디 accountId
	 * 리턴값 : 학생과 관련된 강의 정보 List<LectureSubject>
	 * lectureSubjectList.jsp
	 */
	List<LectureSubject> lectureSubjectInfoByStudent(String accountid);
}
