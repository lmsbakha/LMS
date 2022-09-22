package com.gd.lms.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AccountService {
	// AccountMapper 객체 주입
	@Autowired AccountMapper accountMapper;
	
	// accountState 활성화값
	public String getAccountState(Account account) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService getAccountState" +TeamColor.TEXT_RESET);
		
		return accountMapper.selectAccountState(account);
	}
	
	// 로그인
	public Account getLogin(Account paramAccount) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService getLogin paramAccount" + paramAccount + TeamColor.TEXT_RESET);
		
		// 로그인 정보 대입해서 맞다면 로그인 아이디와 해당 level, state 가지고오기
		Account account = accountMapper.selectLogin(paramAccount);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService getLogin account" + account + TeamColor.TEXT_RESET);
		// 마지막 로그인 날짜 업데이트 해주기
		int row = accountMapper.updateLastLoginDate(paramAccount.getAccountId());
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService getLogin row" + row + TeamColor.TEXT_RESET);
		
		return account;
	}
	
	// (학생, 강사, 행정) 멤버 아이디 찾기
	public String searchMemberAccountId(Map<String, Object> map) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService searchMemberAccountId "+ map + TeamColor.TEXT_RESET);
		String accountId = accountMapper.selectMemberAccountId(map);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService searchMemberAccountId accountId "+ accountId + TeamColor.TEXT_RESET);
		
		if(accountId == null) {
			return "false";
		} 
		
		return accountId;
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기
	public int searchMemberAccountPw(Map<String, Object> map) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService searchMemberAccountPw map : "+ map + TeamColor.TEXT_RESET);
		int cnt = accountMapper.selectMemberAccountPw(map);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService searchMemberAccountPw cnt : "+ cnt + TeamColor.TEXT_RESET);
		
		return cnt;
	}
	
	// (학생, 강사, 행정) 멤버 비밀번호 변경
	public int modifySearchMemberAccountPw(Account account) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService modifySearchMemberAccountPw "+ account + TeamColor.TEXT_RESET);
		
		return accountMapper.updateSearchMemberAccountPw(account);
	}
	
	// 회원가입
	public void addMember(Member paramMember) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService addMember" +TeamColor.TEXT_RESET);
		
		// 레벨 변수 선언
		String level = "";
		if("manager".equals(paramMember.getMemberCheck())) { // memberCheck 매니저인지
			level = "3";
		} else if("teacher".equals(paramMember.getMemberCheck())) { // memberCheck 강사인지
			level = "2";
		} else { // memberCheck 학생
			level = "1";
		}
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService addMember level :" + level +TeamColor.TEXT_RESET);
		// Member level 부여
		paramMember.setAccountLevel(level);
		
		// account 테이블 insert
		accountMapper.insertAccount(paramMember);
		// member 테이블 insert
		accountMapper.insertMember(paramMember);
	}
	
	// 아이디 중복체크
	public int accountIdCheck(String idck) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService accountIdCheck" +TeamColor.TEXT_RESET);
		
		// 해당 아이디 있는지 값 체크하고 일치한다면 Cnt 받아오기
		int cnt = accountMapper.selectAccountIdCnt(idck);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService accountIdCheck cnt : " + cnt + TeamColor.TEXT_RESET);
		
		return cnt;
		
	}
	
	// 이메일 중복체크 - student
	public int studentEmailCheck(String email) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck - student" +TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck email : "+ email +TeamColor.TEXT_RESET);
		
		// 해당 이메일 있는지 값 체크하고 일치한다면 Cnt 받아오기
		int cnt = accountMapper.selectStudentEmailCnt(email);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService studentEmailCheck cnt : "+ cnt + TeamColor.TEXT_RESET);
		
		return cnt;
	}
	
	// 이메일 중복체크 - teacher
	public int teacherEmailCheck(String email) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck - teacher" +TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck email : "+ email +TeamColor.TEXT_RESET);
		
		// 해당 이메일 있는지 값 체크하고 일치한다면 Cnt 받아오기
		int cnt = accountMapper.selectTeacherEmailCnt(email);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService teacherEmailCheck cnt : "+ cnt + TeamColor.TEXT_RESET);
		
		return cnt;
	}
	
	// 이메일 중복체크 - manager
	public int managerEmailCheck(String email) {
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck -manager" +TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "AccountService memberEmailCheck email : "+ email +TeamColor.TEXT_RESET);
		
		// 해당 이메일 있는지 값 체크하고 일치한다면 Cnt 받아오기
		int cnt = accountMapper.selectManagerEmailCnt(email);
		// 디버깅
		log.debug(TeamColor.PCW + "AccountService managerEmailCheck cnt : "+ cnt + TeamColor.TEXT_RESET);
		
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
}
