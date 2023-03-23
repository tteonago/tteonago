package com.tteonago.reservation.controller;

import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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

    //룸 id 받아서 리뷰들 조회
//    @GetMapping("/{roomId}")
//    public String findById(@PathVariable String roomId,Model model) throws TteonagoException {
//        List<ReviewDTO> reviewDTOList = reviewService.getReviewByRoom(roomId);
//        model.addAttribute("reviews",reviewDTOList);
//        return "/";
//    }

}