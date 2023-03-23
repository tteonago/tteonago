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

	//http://localhost/detail?hotelId=10001
	@GetMapping("/detail")
	public String hotelDetail(@RequestParam String hotelId, @RequestParam("dates") String dates, Model model) {

	    Hotel hotel = hotelService.getHotelById(hotelId);
	    if(hotel == null) {
	    	throw new RuntimeException("hotel not found");
	    }
	    model.addAttribute("hotel", hotel);
	    model.addAttribute("dates", dates);

	    return "pages/tours-detail";
	}
}
