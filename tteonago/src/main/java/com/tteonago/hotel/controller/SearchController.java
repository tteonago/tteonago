package com.tteonago.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.HotelService;

@Controller
public class SearchController {

	@Autowired
	private HotelService hotelService;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping("/hotelsearch")
	public String getHotelSearch(@RequestParam(value = "destinaion") String destinaion,
			@RequestParam(value = "dates") String dates, @RequestParam(value = "hotel-grade") int hotelgrade,
			@RequestParam(value = "guests") int guests, Model model) {

		String aid = null;

		System.out.println(destinaion);

		if (destinaion.equals("서울")) {
			aid = "10";
		} else if (destinaion.equals("제주")) {
			aid = "20";
		} else if (destinaion.equals("부산")) {
			aid = "30";
		} else { // "대전"
			aid = "40";
		}

//		List<Hotel> hotellistentity = hotelService.findHotelsByAddressAndStarAndRoomSize(destinaion, hotelgrade, guests);

//		List<Hotel> hotellistentity = hotelService.findHotelsByAddressAndStar(destinaion, hotelgrade);

//		Hotel hotellistentity = hotelService.findByHotelId("10001");

		List<Hotel> hotellistentity = hotelService.gethotellist(aid, hotelgrade, guests);

//		List<HotelDTO> hotellist = Arrays.asList(mapper.map(hotellistentity, HotelDTO.class));

//		for (HotelDTO hotel : hotellist) {
//			System.out.println(hotel.getHotelInfo());
//		}
		
		List<HotelDTO> hotellist = new ArrayList<>();
		for(Hotel hotel : hotellistentity) {
		    HotelDTO hotelDTO = mapper.map(hotel, HotelDTO.class);
		    hotellist.add(hotelDTO);
		}
		
		for(int i=0; i<hotellist.size(); i++) {
			//System.out.println(hotellist.get(i).getHotelId());
			//System.out.println(hotellist.get(i).getImages());
			//System.out.println(hotellist.get(i).getStar());
			System.out.println(hotellist.get(i).getHotelPhone());
		}
	
		model.addAttribute("hotellist", hotellist);

		return "pages/tours-list.html";
	}
}