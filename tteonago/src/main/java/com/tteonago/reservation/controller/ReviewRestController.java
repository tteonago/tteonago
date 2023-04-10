package com.tteonago.reservation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tteonago.member.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReviewRestController {
	
	private final UserService userService;
	
	@PostMapping(value = "/heart")
	public void heart(@RequestParam(value = "hotelId") String hotelId, Authentication authentication) {
		userService.insertWishlist(authentication.getName(), hotelId);
	}
}
