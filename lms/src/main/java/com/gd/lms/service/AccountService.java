package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.vo.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AccountService {
	@Autowired AccountMapper accountMapper;
	
	//test
	public Account getAccount(String testId) {
		//리턴
		System.out.println(testId+"<-- testId");
		Account account = accountMapper.selectAccount(testId);
		System.out.println(account+"<-- account");
		log.debug(TeamColor.PSJ + account +TeamColor.TEXT_RESET);
		return account;
	};
}
