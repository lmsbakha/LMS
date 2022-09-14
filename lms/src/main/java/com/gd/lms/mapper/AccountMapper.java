package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Account;

@Mapper
public interface AccountMapper {
	Account selectAccount(String testId);
}
