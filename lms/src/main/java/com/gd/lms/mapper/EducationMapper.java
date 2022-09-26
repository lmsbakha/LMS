package com.gd.lms.mapper;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Education;

@Mapper
public interface EducationMapper {

	// 계정 1 정보 조회
	// 파라미터 : accountId
	// 리턴값 : Education
	Education selectEducationInfo(String accountId);
	
}
