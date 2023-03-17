package com.tteonago.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.member.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final UserService userService;

	@GetMapping("/home")
	public String home() {
		return "pages/index";
	}

	@GetMapping("/signup")
	public String sample() {
		return "pages/signup";
	}

	@PostMapping(value = "/join")
	public String join(@RequestParam(value = "username") String userName,
							 @RequestParam(value = "password") String password,
							 @RequestParam(value = "name") String name,
							 @RequestParam(value = "email") String email ){

		System.out.println("userName ="+userName+"password="+password+"name="+name+"email"+email);

		userService.join(userName, password,name,email, "ROLE_USER");

		return "pages/index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "pages/login";
	}
	
	@GetMapping(value = "/mypage")
	public String mypage() {
		return "pages/mypage";
	}
	
}
