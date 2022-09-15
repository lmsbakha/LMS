package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.MemberMapper;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;

	// 회원가입 시 계정 생성
	public int addMember(Member member) {
		return memberMapper.insertMember(member);
	}
	// 계정 수정하기
	// 계정 삭제하기
	// 로그인한 계정의 정보 읽기
}
