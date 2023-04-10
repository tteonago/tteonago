package com.tteonago.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController { // 리뷰 등록 컨트롤러

	private final ReviewService reviewService;

	@PostMapping(value = "/review/new")
	public String reviewNew(@ModelAttribute ReviewEnrollDTO reviewEnrollDTO, Model model) {
		try {
			reviewService.reviewing(reviewEnrollDTO, reviewEnrollDTO.getResIndex());
		} catch (Exception e) {
			model.addAttribute("errorMessage", "리뷰 등록 중 오류 발생");
			return "pages/profile";
		}
		return "redirect:/mypage";
	}
}
