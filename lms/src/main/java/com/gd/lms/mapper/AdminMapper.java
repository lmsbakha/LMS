package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Admin;

@Mapper
public interface AdminMapper {
	
	// 행정 개인정보 상세보기
	Admin selectAdminOne(String accountId);
}
