package com.tteonago.reservation.controller;

import com.tteonago.exception.TteonagoException;
import com.tteonago.reservation.dto.ReviewDTO;
import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@Controller
class ReviewController {

    private final ReviewService reviewService;

    //리뷰 등록 컨트롤러 1
    @PostMapping(value = "/review/new")
    public String reviewNew(@Valid @RequestBody ReviewEnrollDTO reviewEnrollDTO, BindingResult bindingResult, Model model
            ) {
        /**
         bindingReseult란?
         Modelattribute를 이용해 매개변수를 bean에 binding할 때,발생한 오류정보를 받기 위해서 선언해야하는 어노테이션.
         매개변수 바인딩에 실패하면, 400오류 발생
         */
        if (bindingResult.hasErrors()) {
            return "마이페이지";
        }

        if (reviewEnrollDTO.getId() == null) {
            model.addAttribute("errorMessage", "작성한 리뷰가 없습니다.");
            return "리뷰작성페이지";
        }

        try {
            reviewService.saveReview(reviewEnrollDTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "리뷰 등록 중 오류 발생");
            return "주문목록";
        }

        return "redirect:/testReview";
    }

    //룸 id 받아서 리뷰들 조회
    @GetMapping("/{roomId}")
    public String findById(@PathVariable String roomId,Model model) throws TteonagoException {
        List<ReviewDTO> reviewDTOList = reviewService.getReviewByRoom(roomId);
        model.addAttribute("reviews",reviewDTOList);
        return "/";
    }
    @GetMapping("/review")
    public String test(){

        return "pages/reviewinputtest";
    }

}
