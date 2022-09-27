package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Exam;

@Mapper
public interface ExamMapper {
	// 시험을 추가하는 메소드
	// 파라미터 : Exam
	// 리턴값: 추가 여부 int 
	int insertExam(Exam paramExam);

	// 선택된 lecture의 examList를 받아오는 메소드
	// 파라미터 : lectureName
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> selectExamListByLecture(String lectureName);
	
	// 학생 아이디에 따른 시험 목록 가져오기
	// 파라미터 : accountId
	// 리턴값 : List<Map<String, Object>>
	List<Map<String, Object>> selectExamListForStudentByAccountId(String accountId);

}
