package com.tteonago.hotel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String hotelDetail(@RequestParam String hotelId, @RequestParam("dates") String dates, @RequestParam String checkIn, @RequestParam String checkOut, Model model) {
	    Hotel hotel = hotelService.getHotelById(hotelId);
	    if(hotel == null) {
	    	throw new RuntimeException("hotel not found");
	    }

		HashMap<Member, Review> review = reviewService.findReviewByHotelId(hotelId);

		for(Member key : review.keySet()) {
			System.out.println(key.getUsername() + " 유저가 작성한 리뷰는 : " + review.get(key).getContext());
		}
		model.addAttribute("review",review);
	    model.addAttribute("hotel", hotel);
	    model.addAttribute("dates", dates);
	    model.addAttribute("checkIn", checkIn);
	    model.addAttribute("checkOut", checkOut);

	    return "pages/tours-detail";
	}
	
	@GetMapping("/mapdetail")
	public String hotelDetail(@RequestParam String hotelId, Model model) {
	    Hotel hotel = hotelService.getHotelById(hotelId);
	    if(hotel == null) {
	    	throw new RuntimeException("hotel not found");
	    }

		HashMap<Member, Review> review = reviewService.findReviewByHotelId(hotelId);

		for(Member key : review.keySet()) {
			System.out.println(key.getUsername() + " 유저가 작성한 리뷰는 : " + review.get(key).getContext());
		}
		
		
		String checkIn = LocalDate.now().toString();
		LocalDate checkOut = LocalDate.now();
		
		LocalDate twentyAfterLocalDate = checkOut.plusDays(1);
		
		String checkout = twentyAfterLocalDate.toString();
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //기존의 String 날짜 포멧 데이터 형식 지정
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //변경할 String 날짜 포멧 데이터 형식 지정
		
		LocalDate checkinDate = LocalDate.parse(checkIn, inputFormatter);
		LocalDate checkoutDate = LocalDate.parse(checkout, inputFormatter);
		
		String formattedCheckin = checkinDate.format(outputFormatter);
		String formattedCheckout = checkoutDate.format(outputFormatter);
		
		String dates = formattedCheckin + " - " + formattedCheckout;
		
		model.addAttribute("review",review);
	    model.addAttribute("hotel", hotel);
	    model.addAttribute("dates", dates);

	    return "pages/tours-detail";
	}
	
	
	@GetMapping("/test22")
	public String test22() {
	   return "pages/tours-detail";
    }	
	
}
