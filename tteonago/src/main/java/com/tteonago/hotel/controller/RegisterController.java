package com.tteonago.hotel.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tteonago.hotel.dto.HotelRegisterDTO;
import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RegisterController {
	
	private final HotelService hotelService;
	
	@GetMapping(value = "/insert")
	public String insert() {
		return "pages/insert";
	}
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute HotelRegisterDTO hotelRegisterDTO, @ModelAttribute RoomDTO roomDTO , @RequestParam("hotelfiles[]") MultipartFile[] hotelfiles, @RequestParam("roomfiles[]") MultipartFile[] roomfiles) throws IOException {
		String filePath = "C:\\Users\\sh725\\OneDrive\\문서\\tteonago\\tteonago\\src\\main\\resources\\static\\images\\";
		
		//insert Hotel, hotelImage, room, roomImage
		hotelService.insertHotel(hotelRegisterDTO, roomDTO, hotelfiles, roomfiles);
		
		for(MultipartFile m : hotelfiles) {
			String fileName = m.getOriginalFilename();
			File file = new File(filePath + fileName);
			m.transferTo(file);
		}
		
		for(MultipartFile m : roomfiles) {
			String fileName = m.getOriginalFilename();
			File file = new File(filePath + fileName);
			m.transferTo(file);
		}
		
		return "pages/index";
	}
}
