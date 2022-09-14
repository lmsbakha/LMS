package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
   @GetMapping("/index")
   public String index() {
      return "index";
   }
   
   @GetMapping("/test_park")
   public String test() {
	   return "test_park";
   } 
   
   @GetMapping("/test_park_so")
   public String test_park_so() {
	   return "test_park_so";
   }
}