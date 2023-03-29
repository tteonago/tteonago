package com.tteonago.hotel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	private final HotelService hotelService;

	@GetMapping("/hotelsearch")
	public String getHotelSearch(@RequestParam(value = "destination") String destination,
			@RequestParam(value = "dates") String dates, @RequestParam(value = "hotel-grade") int hotelgrade,
			@RequestParam(value = "guests") int guests, Model model) {

		Map<String, String> destinationMap = new HashMap<>();
		destinationMap.put("서울", "10");
		destinationMap.put("제주", "20");
		destinationMap.put("부산", "30");
		destinationMap.put("대전", "40");

		String aid = destinationMap.get(destination);

		List<HotelDTO> hotellist = hotelService.getHotelList(aid, hotelgrade, guests);

		String[] dateArr = dates.split(" - ");
		LocalDate checkinDate = LocalDate.parse(dateArr[0], DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate checkoutDate = LocalDate.parse(dateArr[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        long daysBetween = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
        long nights = daysBetween - 1;

		String Days = " " + nights + "박 / " + daysBetween + "일";

		model.addAttribute("hotellist", hotellist);
		model.addAttribute("hotelcount", hotellist.size());

		model.addAttribute("datein", checkinDate);
        model.addAttribute("dateout", checkoutDate);
		model.addAttribute("days", Days);

		model.addAttribute("dates", dates);
		model.addAttribute("destination", destination);
		model.addAttribute("guests", guests);
		model.addAttribute("star", hotelgrade);

		return "pages/tours-list";
	}
	
}