package com.tteonago.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.HotelService;

@Controller
public class DetailController {
	
	@Autowired
    private HotelService hotelService;

	
	@GetMapping("/{hotelId}")
	public String hotelDetail(@PathVariable String hotelId, Model model) {

	    Hotel hotel = hotelService.getHotelById(hotelId);
	    model.addAttribute("hotel", hotel);

	    return "pages/tours-detail";
//	    return "pages/test";
	}
	
	
	
	
	@GetMapping("/test22")
	public String test22() {
	   return "pages/tours-detail";
    }
	
	
	
}
