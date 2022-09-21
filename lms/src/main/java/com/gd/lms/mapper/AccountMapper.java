package com.gd.lms.mapper;

import java.util.*;

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
	// (학생, 강사, 행정) 멤버 아이디 찾기 - 이름과 이메일이 해당 아이디와 일치한다면 null 값이 아니라면
	String selectMemberAccountId(Map<String,Object> map);
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 아이디와 이름이 일치한다면 cnt 받기
	int selectMemberAccountPw(Map<String,Object> map);
	// (학생, 강사 ,행정) 멤버 비밀번호 변경해주기

	// 회원가입 메서드
	int insertMember(Member paramMember);

	// 회원 가입 시 account 테이블에 추가 해주기
	int insertAccount(Member paramMember);

	// 회원 가입 시 아이디 중복 체크 위해 같은 아이디가 있는지 Cnt 받기
	int selectAccountIdCnt(String idck);

	// 회원 가입시 이메일 중복 체크 위해 같은 이메일이 있는지 Cnt 받기 - student
	int selectStudentEmailCnt(String email);

	// 회원 가입시 이메일 중복 체크 위해 같은 이메일이 있는지 Cnt 받기 - teacher
	int selectTeacherEmailCnt(String email);

	// 회원 가입시 이메일 중복 체크 위해 같은 이메일이 있는지 Cnt 받기 - manager
	int selectManagerEmailCnt(String email);
}
