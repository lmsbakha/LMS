package com.gd.lms.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.AccountService;
import com.gd.lms.vo.Account;

@Controller
public class IndexController {
	@Autowired AccountService accountService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/test")
   public String test(HttpSession session) {
	   //서비스 콜하기
		String testId = "aaaa";
	   Account account = accountService.getAccount(testId);
	   System.out.println(account+"<-- account");
	   session.setAttribute("account", account);
	   return "test";	//포워딩
   }
}