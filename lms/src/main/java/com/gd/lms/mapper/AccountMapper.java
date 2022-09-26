package com.gd.lms.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;
import com.gd.lms.vo.Manager;
import com.gd.lms.vo.Member;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.Teacher;

@Mapper
public interface AccountMapper {
	// 계정 활성화 상태값 가져기오기
	String selectAccountState(Account account);
	
	// 계정 활성화 상태값 수정 - 휴면 -> 활성화 
	int updateAccountStateByMember(Account account);
	
	// 계정 마지막 로그인날짜로부터 90일동안 로그인안했다면 활성화 상태값 수정 - 활성화 -> 휴면
	int updateAccountStateByMemberLastLogin();
	
	// 로그인 - 로그인 아이디와 비밀번호가 맞다면 해당 level값 출력해주는 메서드
	Account selectLogin(Account paramAccount);
	
	// 마지막 로그인 날짜 업데이트 해주기
	int updateLastLoginDate(String accountId);
	
	// 로그인시 해당 레벨 받기
	int selectMemberLevelByAccountId(String accountId);
	
	// (학생, 강사, 행정) 멤버 아이디 찾기 - 이름과 이메일이 해당 아이디와 일치한다면 null 값이 아니라면
	String selectMemberAccountId(Map<String,Object> map);
	
	// (학생, 강사, 행정) 멤버 비밀번호 찾기 아이디와 이름이 일치한다면 cnt 받기
	int selectMemberAccountPw(Map<String,Object> map);
	
	// (학생, 강사 ,행정) 멤버 비밀번호 변경해주기 - 비밀번호 찾기를 통해 변경해주는 경우
	int updateSearchMemberAccountPw(Account account);
	
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
	
	// 회원가입 학생 승인대기리스트
	List<Student> selectWaitStudentList();
	
	// 회원가입 강사 승인대기리스트
	List<Teacher> selectWaitTeacherList();
	
	// 회원가입 행정 승인 대기리스트
	List<Manager> selectWaitManagerList();
	
	// 회원가입 승인 - 행정 & 총관리자만 가능
	int updateApproveWaitMemberList(String accountId);
	
	// 회원가입 거절 - 행정 & 총관리자만 가능
	int updateDeniedWaitMemberList(String accountId);
	
}
