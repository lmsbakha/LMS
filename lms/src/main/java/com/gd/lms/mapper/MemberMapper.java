package com.gd.lms.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Member;

@Mapper
public interface MemberMapper {
	// 회원가입 시 계정 생성
		Member insertMember(Member member);
		
	// 회원가입 시 아이디 중복검사
	//	boolean IdCheck(Member member);
}
