package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MemberFile;

@Mapper
public interface MemberFileMapper {
	
	// 파일 선택
	MemberFile selectMemberFile(String accountId);
	
	// 파일 입력
	int insertMemberFile(MemberFile memberFile);
	
	// 파일 삭제
	int deleteMemberFile(String accountId);
	
}
