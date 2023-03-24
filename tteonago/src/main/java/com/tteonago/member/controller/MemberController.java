package com.tteonago.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.member.entity.Member;
import com.tteonago.member.service.UserService;
import com.tteonago.reservation.dto.ReservationDTO;
import com.tteonago.reservation.service.ReservationService;
import com.tteonago.reservation.service.ReviewService;

import org.springframework.security.core.userdetails.User;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final UserService userService;
	private final ReservationService reservationService;
	private final ReviewService reviewService;

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
			@RequestParam(value = "password") String password, @RequestParam(value = "name") String name,
			@RequestParam(value = "email") String email) {

		userService.join(userName, password, name, email, "ROLE_USER");

		return "pages/index";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "pages/login";
	}

	@GetMapping(value = "/mypage")
	public String mypage(Authentication authentication, Model model) {
		if (authentication == null) {
			return "pages/login";
		}

		Member member = userService.findById(authentication.getName());
		model.addAttribute("member", member);
		
		HashMap<String, ReservationDTO> reservationDTOs = reservationService.findReservationByUsername(member);
		model.addAttribute("reservation", reservationDTOs);
		
		List<Integer> resIndex = reviewService.findReviewByResIndex(authentication.getName());
		model.addAttribute("resIndex", resIndex);

		return "pages/profile";
	}

	@PostMapping("/failure")
	public String loginForm(Model model, HttpServletRequest request) {
		model.addAttribute("error", (String) request.getAttribute("error"));
		return "pages/login";
	}

	@GetMapping("/wishlist")
	public String wishlist(Model model, Authentication authentication) {
		if (authentication == null || authentication.getAuthorities().stream()
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

	@GetMapping(value = "/changeRole")
	public String password() {
		return "pages/socialAuth";
	}

	@GetMapping(value = "/authNum")
	public String authNum(@RequestParam(value = "authnum") String authnum, Authentication authentication, Model model) {
		if (Integer.parseInt(authnum) != 56) {
			model.addAttribute("error", "인증번호가 틀렸습니다.");

			return "pages/socialAuth";
		}

		userService.updateSocialPassword(authentication.getName());

		authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;

			List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
			for (int i = 0; i < authorities.size(); i++) {
				GrantedAuthority authority = authorities.get(i);
				if (authority.getAuthority().equals("ROLE_SOCIAL")) {
					authorities.set(i, new SimpleGrantedAuthority("ROLE_USER"));
				}
			}
			UserDetails modifiedUserDetails = new User(userDetails.getUsername(), userDetails.getPassword(),
					authorities);

			Authentication newAuthentication = new UsernamePasswordAuthenticationToken(modifiedUserDetails,
					authentication.getCredentials(), modifiedUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(newAuthentication);
		}

		return "redirect:/mypage";
	}
	
	@GetMapping(value = "/createAdmin")
	public String createAdmin() {
		
		
		return null;
	}

}
