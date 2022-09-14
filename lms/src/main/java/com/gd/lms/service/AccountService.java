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
	public Account getAccount() {
		//리턴
		Account account = accountMapper.selectAccount();
		System.out.println(account+"<-- account");
		log.debug(TeamColor.PSJ + account +TeamColor.TEXT_RESET);
		return account;
	};
}
