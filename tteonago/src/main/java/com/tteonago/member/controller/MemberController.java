package com.tteonago.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.member.entity.WishlistDTO;
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
	
	@PostMapping("/failure")
    public String loginForm(Model model, HttpServletRequest request ) {
		model.addAttribute("error", (String) request.getAttribute("error"));
        return "pages/login";
    }
	
	@GetMapping("/wishlist")
	public String wishlist(Model model, Authentication authentication) {
		if(authentication == null) {
			return "pages/login"; 
		}
		
		List<Object[]> wishlist = userService.getwishtlist(authentication.getName());
        model.addAttribute("wishlist", wishlist);
		
		return "pages/wishlist";
	}
	
	//delete
	@GetMapping(value = "/showMe")
	public String showMe() {
		
		return "pages/wishlist";
	}
	
}
