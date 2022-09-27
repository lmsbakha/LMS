package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;
import com.gd.lms.vo.Manager;

@Mapper
public interface ManagerMapper {
		
	// 행정목록 리스트
	List<Manager> selectManagerList();
	
	// 행정 개인정보 상세보기
	Manager selectManagerOne(String accountId);
	
	// 행정 개인정보 수정하기
	int updateManager(Manager manager);
	
	// 행정 개인정보 행정테이블에서 삭제하기 (탈퇴)
	int deleteManager(String accountId);
	
	// 행정 개인정보 accountState 탈퇴로 수정하기 (탈퇴)
	int updateAccountStateManager(Account account);
	
}
