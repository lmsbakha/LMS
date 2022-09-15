package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.mapper.MemberMapper;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	@Autowired private AccountMapper accountMapper;
	@Autowired private Account account;

	// 회원가입 시 계정 생성
	public int addMember(Member Paramember) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSY + Paramember + "<-- Paramember" + TeamColor.TEXT_RESET);
		
		// 계정 먼저 추가
		int addAccount= accountMapper.insertAccount(account);
		// Mapper에서 받아온 addAccount값 디버깅
		log.debug(TeamColor.PSY + addAccount + "<-- addAccount" + TeamColor.TEXT_RESET);
		
		int member = memberMapper.insertMember(Paramember);
		// Mapper에서 받아온 member값 디버깅
		log.debug(TeamColor.PSY + member + "<-- member" + TeamColor.TEXT_RESET);
		return member;
	}
	
	// 계정 수정하기
	// 계정 삭제하기
	// 로그인한 계정의 정보 읽기
}
