package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;

@Mapper
public interface AccountMapper {
	// 계정 활성화 상태값 가져오는 메서드
	String selectAccountState(Account account);
	
	// 로그인 - 로그인 아이디와 비밀번호가 맞다면 해당 level값 출력해주는 메서드
	Account selectLogin(Account paramAccount);
	
	// 마지막 로그인 날짜 업데이트 해주는 메서드 
	int updateLastLoginDate(String accountId);
	
	// 회원가입 메서드
	int insertMember(Member paramMember);
	
	// 회원 가입 시 account 테이블에 추가 해주는 메서드
	int insertAccount(Member paramMember);
}
