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
public class MemberController {
	private final UserService userService;
	@Value("${jwt.token.secret}")
	private String SecretKey;
	
	@GetMapping("/home")
	public String helloworld() {
		return "pages/signup";
	}

	@PostMapping(value = "/join")
	public ModelAndView join(@RequestParam(value = "userName") String userName,
							 @RequestParam(value = "password") String password,
							 @RequestParam(value = "name") String name,
							 @RequestParam(value = "email") String email ){

		System.out.println("userName ="+userName+"password="+password+"name="+name+"email"+email);

		userService.join(userName, password,name,email, "ROLE_USER");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/index_S.html");
		//회원가입하고 나면 로그인으로 가야할지

		return mv;
	}
	
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

	/*
	 * @GetMapping("/valid") public ModelAndView valid() { ModelAndView mv = new
	 * ModelAndView(); mv.setViewName("valid");
	 * 
	 * return mv; }
	 */
	
//	@GetMapping("/showMe")
//	public ModelAndView showme() {
//		System.out.println("showme--------");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("pages/showMe_S");
//		
//		System.out.println("showme--------11");
//		return mv;
//	}
}
