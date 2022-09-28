package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamSubmitMapper {
	// 답안 제출시 시험응시 이력 추가
	int insertExamSubmitCK(int educationNo, int examNo);
}
