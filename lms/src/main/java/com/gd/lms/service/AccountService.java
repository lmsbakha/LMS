package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.vo.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AccountService {
	// AccountMapper 객체 주입
	@Autowired AccountMapper accountMapper;

	// 로그인에 사용되는 메소드
	// 파라미터 : account (accountId, accountPw)
	// 리턴값 : account (accountId, accountLevel, accountState)
	public Account getLogin(Account paramAccount) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramAccount + "<-- paramAccount" + TeamColor.TEXT_RESET);
		// Mapper call
		Account account = accountMapper.selectLogin(paramAccount);
		// Mapper에서 받아온 account(id, level)값 디버깅
		log.debug(TeamColor.PSJ + account + "<-- AccountService / getLogin / account" + TeamColor.TEXT_RESET);
		return account;
	}

	// 계정 추가에 사용되는 메소드
	// 파라미터 : account 
	public int addAccount(Account account, @RequestParam(value = "Account")Account paraAccount) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + paraAccount + "<-- paramAccount" + TeamColor.TEXT_RESET);
		// Mapper call
		int row = accountMapper.insertAccount(paraAccount);
		// Mapper에서 받아온 account 값 디버깅
		log.debug(TeamColor.PSY + account + "<-- account" + TeamColor.TEXT_RESET);
		return row;
	}
	
	// accountId 중복 체크
	public int AccountIdCheck(String idck) {
		// Mapper call
		// accountId 중복 검사하기위해 accountId Cnt 받기
		int count = accountMapper.selectAccountIdCnt(idck);
		// 디버깅
		log.debug(TeamColor.PCW + "<-- AccountService / AccountIdCheck / count" + TeamColor.TEXT_RESET);
		
		return count;
	}
}
