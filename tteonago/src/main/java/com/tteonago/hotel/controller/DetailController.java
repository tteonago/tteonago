package com.tteonago.hotel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Review;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DetailController {

	private final HotelService hotelService;
	private final ReviewService reviewService;

	@GetMapping("/detail")
	public String hotelDetail(@RequestParam String hotelId, @RequestParam("dates") String dates,
			@RequestParam String checkIn, @RequestParam String checkOut, Model model) {

		HotelDTO hotel = getHotelByIdOrThrow(hotelId);
		addReviewAndHotelToModel(model, hotelId, hotel);

		model.addAttribute("dates", dates);
		model.addAttribute("checkIn", checkIn);
		model.addAttribute("checkOut", checkOut);

		return "pages/tours-detail";
	}

	@GetMapping("/mapdetail")
	public String hotelMapDetail(@RequestParam String hotelId, Model model) {
		HotelDTO hotel = getHotelByIdOrThrow(hotelId);
		addReviewAndHotelToModel(model, hotelId, hotel);

		String dates = generateDefaultDates();
		model.addAttribute("dates", dates);

		return "pages/tours-detail";
	}

	private HotelDTO getHotelByIdOrThrow(String hotelId) {
		HotelDTO hotel = hotelService.getHotelById(hotelId);
		if (hotel == null) {
			throw new RuntimeException("hotel not found");
		}
		return hotel;
	}

	private void addReviewAndHotelToModel(Model model, String hotelId, HotelDTO hotel) {
		HashMap<Member, Review> review = reviewService.findReviewByHotelId(hotelId);
		model.addAttribute("review", review);
		model.addAttribute("hotel", hotel);
	}

	private String generateDefaultDates() {
		LocalDate checkIn = LocalDate.now();
		LocalDate checkOut = checkIn.plusDays(1);

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedCheckin = checkIn.format(dateFormatter);
		String formattedCheckout = checkOut.format(dateFormatter);

		return formattedCheckin + " - " + formattedCheckout;
	}
	
}
