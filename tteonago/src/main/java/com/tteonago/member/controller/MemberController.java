package com.tteonago.member.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.member.entity.Member;
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
	public String mypage(Authentication authentication, Model model) {
		if(authentication == null) {
			return "pages/login"; 
		}
		
		Member member = userService.findById(authentication.getName());
		model.addAttribute("member", member);
		
		return "pages/profile";
	}
	
	@PostMapping("/failure")
    public String loginForm(Model model, HttpServletRequest request ) {
		model.addAttribute("error", (String) request.getAttribute("error"));
        return "pages/login";
    }
	
	@GetMapping("/wishlist")
	public String wishlist(Model model, Authentication authentication) {
		if(authentication == null || authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")) == false) {
			return "pages/login"; 
		}
		
		List<Object[]> wishlist = userService.getwishtlist(authentication.getName());
        model.addAttribute("wishlist", wishlist);
		
		return "pages/wishlist";
	}
	
	@GetMapping(value = "/wishdelete")
	public String mypage(@RequestParam(value = "hotel") String hotel, Authentication authentication) {
		userService.deleteByHotelId(authentication.getName(), hotel);
		
		return "redirect:/wishlist";
	}
	
	//delete
	@GetMapping(value = "/showMe")
	public String showMe(Authentication authentication) {
		
		return "pages/mypage_S";
	}
	
}
