package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.AccountService;

@Controller
public class IndexController {
	@Autowired AccountService accountService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}