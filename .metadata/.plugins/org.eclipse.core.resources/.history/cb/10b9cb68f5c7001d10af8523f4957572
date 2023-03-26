package com.tteonago.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.service.HotelDetailServise;

@Controller
public class HotelDetailController {

	@Autowired
	private HotelDetailServise hotelDetailServise;
	
	@GetMapping("/detail")
	public String detail(@RequestParam String hotelId, Model model) throws TteonagoException {
		System.out.println(hotelId);
		
		List<RoomDTO> roomDTO = hotelDetailServise.getRoomByHotel(hotelId);
		
		model.addAttribute("hotelId", hotelId);
		model.addAttribute("rooms", roomDTO);
	    	
	    return "pages/test_S";
	}	
	
	
}
