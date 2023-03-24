package com.tteonago.hotel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Review;
import com.tteonago.reservation.service.ReviewService;

@Controller
public class DetailController {
	
	@Autowired
    private HotelService hotelService;
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/detail")
	public String hotelDetail(@RequestParam String hotelId, @RequestParam String checkIn, @RequestParam String checkOut, Model model) {
	    Hotel hotel = hotelService.getHotelById(hotelId);
	    if(hotel == null) {
	    	throw new RuntimeException("hotel not found");
	    }
	    
	    HashMap<Member, Review> review = reviewService.findReviewByHotelId(hotelId);
	    
	    model.addAttribute("hotel", hotel);
	    model.addAttribute("checkIn", checkIn);
	    model.addAttribute("checkOut", checkOut);
	    model.addAttribute("review", review);

	    return "pages/tours-detail";
	}
	
	
	@GetMapping("/test22")
	public String test22() {
	   return "pages/tours-detail";
    }
	
	
	
}
