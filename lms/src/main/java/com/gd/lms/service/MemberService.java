package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.gd.lms.mapper.MemberMapper;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	// 회원가입 시 계정 생성
	public Member addMember(Member member) {
		return memberMapper.insertMember(member);
	}
	
	
	public List addMemberform(Member member) {
		Map<String, Object> resultMap = new HashMap<>();
		List memberInfo = (List)memberMapper.insertMember(member);
		resultMap.put("memberInfo", memberInfo);
		return null;
	}
	
	
	// 중복검사
	/*
	public boolean IdCheck(Member member) {
		return memberMapper.IdCheck(member.setAccountId());
	}
	*/
	
	
	// 계정 수정하기
	// 계정 삭제하기
	// 로그인한 계정의 정보 읽기
}
