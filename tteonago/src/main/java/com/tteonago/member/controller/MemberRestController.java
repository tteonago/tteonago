package com.tteonago.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tteonago.member.service.UserService;
import com.tteonago.member.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final UserService userService;
	@Value("${jwt.token.secret}")
	private String SecretKey;
	
	
	@PostMapping("/getToken")
	public ResponseEntity<String> showName(@CookieValue(value = "token", required = false) String token) {
		System.out.println("token-----" + token);
		
		if(token == null) {
			return ResponseEntity.ok().body(token); 
		}
		
		return ResponseEntity.ok().body(token);
	}
	
	@PostMapping("/getName")
	public ResponseEntity<String> getName(Authentication authientication) {
		
		if(authientication == null) {
			return ResponseEntity.ok().body(""); 
		}
		System.out.println("getName---------" + authientication.getName());
		
		String userName = authientication.getName();
		return ResponseEntity.ok().body(userName);
	}
	
	@PostMapping("/getTokenName")
	public ResponseEntity<String> getTokenName(@CookieValue(value = "token", required = false) String token) {
		System.out.println("gettokenname--------" + token);
		if(token == null) {
			return ResponseEntity.ok().body(token); 
		}
		
		String userName = JwtTokenUtil.getUserName(token, SecretKey);
		return ResponseEntity.ok().body(userName);
	}

}
