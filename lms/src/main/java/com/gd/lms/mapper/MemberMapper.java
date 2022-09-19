package com.gd.lms.mapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

	// 회원가입 시 사용되는 메소드
	// 파라미터 : member 
	int insertMember(String member);
	
	// memberEmail 중복 검사하기위해 memberEmail Cnt 받기
	// 파라미터 : emck
	int selectMemberEmailCnt(String emck);
}

