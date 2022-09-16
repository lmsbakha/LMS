package com.gd.lms.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Member;

@Mapper
public interface MemberMapper {

	// 회원가입 시 사용되는 메소드
	// 파라미터 : member 
	int insertMember(Member member);
	
	// memberEmail 중복 검사하기위해 memberEmail Cnt 받기
	// 파라미터 : emck
	int selectMemberEmailCnt(String emck);
}

