package com.gd.lms.service;

import java.util.Map;

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
	// MemberMapper 객체 주입
	@Autowired
	private MemberMapper memberMapper;
	// AccountMapper 객체 주입
	@Autowired
	private AccountMapper accountMapper;

	public int addMember(Map<String, Object> paramMap) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + paramMap + "<--paramMap" + TeamColor.TEXT_RESET);

		// account 객체에 데이터 셋팅
		Account paramAccount = new Account();
		paramAccount.setAccountId((String) paramMap.get("accountId"));
		paramAccount.setAccountLevel((int) paramMap.get("accountLevel"));
		// 디버깅
		log.debug(TeamColor.PSJ + paramAccount + "<--paramAccount" + TeamColor.TEXT_RESET);

		// Member 객체에 데이터 셋팅
		Member paramMember = new Member();
		paramMember.setAccountId((String) paramMap.get("accountId"));
		paramMember.setMemberName((String) paramMap.get("memberName"));
		paramMember.setMemberGender((String) paramMap.get("memberGender"));
		paramMember.setMemberBirth((String) paramMap.get("memberBirth"));
		paramMember.setMemberEmail((String) paramMap.get("memberEmail"));
		paramMember.setMemberPhone((String) paramMap.get("memberPhone"));
		paramMember.setMemberAddress((String) paramMap.get("memberAddress"));
		paramMember.setMemberDetailAddress((String) paramMap.get("memberDetailAddress"));

		// Mapper call
		// Account table에 먼저 추가 --> Member table에 추가
		int addAccount = accountMapper.insertAccount(paramAccount);
		int addMember = 0;
		if (addAccount != 0) {
			log.debug(TeamColor.PSJ + "account 테이블에 회원 추가 성공" + TeamColor.TEXT_RESET);
			addMember = memberMapper.insertMember(paramMember);
			if (addMember != 0) {
				log.debug(TeamColor.PSJ + "Member 테이블에 회원 추가 성공" + TeamColor.TEXT_RESET);
			} else {
				log.debug(TeamColor.PSJ + "Member 테이블에 회원 추가 실패" + TeamColor.TEXT_RESET);
			}
		} else {
			log.debug(TeamColor.PSJ + "account 테이블에 회원 추가 실패" + TeamColor.TEXT_RESET);
		}
		return addMember;
	}
}
