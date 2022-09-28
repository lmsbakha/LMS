package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.OutRecord;


@Mapper
public interface OutRecordMapper {
	
	// 탈퇴 사유 
	int insertOutReasonByMember(OutRecord outRecord);
}
