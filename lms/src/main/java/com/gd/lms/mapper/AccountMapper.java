package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;

@Mapper
public interface AccountMapper {
	// 로그인에 사용되는 메소드
	// 파라미터 : account (accountId, accountPw)
	// 리턴값 : account (accountId, accountLevel, accountState)
	Account selectLogin(Account account);
	
	// 계정 추가에 사용되는 메소드
	// 파라미터 : account
	int insertAccount(Account account);
	
	// accountId 중복 검사하기위해 accountId Cnt 받기
	// 파라미터 : idck
	int selectAccountIdCnt(String idck);
}
