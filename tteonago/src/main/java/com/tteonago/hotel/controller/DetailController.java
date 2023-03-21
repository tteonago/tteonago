package com.tteonago.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.HotelService;

@Controller
public class DetailController {
	@Autowired
    private HotelService hotelService;
	
	private ModelMapper mapper = new ModelMapper();
	
	@GetMapping("/{hotelId}")
	public String hotelDetail(@PathVariable String hotelId, Model model) {
	    // hotel 정보를 가져오는 코드
	    Hotel hotel = hotelService.getHotelById(hotelId);
	    model.addAttribute("hotel", hotel);

//	    return "pages/tours-detail";
	    return "pages/test";
	
//	@GetMapping("/{hotelId}")
//    public String getHotelDetail(Model model, @PathVariable("hotelId") String hotelId) {
//        Hotel hotel = hotelService.getHotelById(hotelId);
//        List<Object[]> rooms = hotelService.findDistinctRoomsByHotelId(hotelId);
//        model.addAttribute("hotel", hotel);
//        model.addAttribute("rooms", rooms);
//        return "/pages/test";
    }
	
}
