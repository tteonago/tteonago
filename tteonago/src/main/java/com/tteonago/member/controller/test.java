package com.tteonago.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
	
	@GetMapping("/test")
	public String welcome(Model model) {
		System.out.println("test 실행 ---------");
		
		return "test";
	}
	
}
