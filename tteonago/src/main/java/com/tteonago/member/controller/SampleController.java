package com.tteonago.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tteonago.member.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@Controller
//@RequiredArgsConstructor
public class SampleController {
	//private final UserService userService;

	@GetMapping("/sample")
	public String sample() {
		return "pages/sample";
	}
	
    @GetMapping("/home")
    public String home() {
        return "pages/index_S";
    }

	@GetMapping("/showMe")
	public String showme() {
		System.out.println("showMe----");
		return "pages/showMe_S";
	}
	
	@GetMapping("/login")
	public String showme1() {
		return "pages/login";
	}
	
	@GetMapping("/social")
	public String social() {
		return "pages/checkSocial_S";
	}
	
    @GetMapping("/valid")
    public String valid() {
    	return "pages/valid_S";
    }
    
    @PostMapping(value = "/join")
	public String join(@RequestParam(value = "userName") String userName,
					   @RequestParam(value = "password") String password,
					   @RequestParam(value = "name") String name,
					   @RequestParam(value = "email") String email) {
    	
		//userService.join(userName, password, name, email,"ROLE_USER");
		
		return "pages/index_S";
	}
}
