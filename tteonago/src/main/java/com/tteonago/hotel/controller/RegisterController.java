package com.tteonago.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tteonago.hotel.dto.HotelRegisterDTO;

@Controller
public class RegisterController {
	
	@GetMapping(value = "/insert")
	public String insert() {
		return "pages/insert";
	}
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute HotelRegisterDTO HotelRegisterDTO) {
		System.out.println(HotelRegisterDTO);
		
		return "pages/insert";
	}
}
