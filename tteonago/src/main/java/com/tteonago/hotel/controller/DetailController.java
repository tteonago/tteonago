package com.tteonago.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.HotelService;

@Controller
public class DetailController {
	
	@Autowired
    private HotelService hotelService;
	
	@GetMapping("/detail")
	public String hotelDetail(@RequestParam String hotelId, @RequestParam String checkIn, @RequestParam String checkOut, Model model) {
		Hotel hotel = hotelService.getHotelById(hotelId);
			if(hotel == null) {
				throw new RuntimeException("hotel not found");
			}
			model.addAttribute("hotel", hotel);
			model.addAttribute("checkIn", checkIn);
			model.addAttribute("checkOut", checkOut);
			return "pages/tours-detail";
		}
	
	
}
