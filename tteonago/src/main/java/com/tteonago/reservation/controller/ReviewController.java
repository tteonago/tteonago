package com.tteonago.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
class ReviewController {

    private final ReviewService reviewService;

    //리뷰 등록 컨트롤러
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