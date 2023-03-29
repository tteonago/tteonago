package com.tteonago.reservation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.service.RoomService;
import com.tteonago.member.entity.Member;
import com.tteonago.member.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Purchasecontroller {

	private final RoomService roomService;

	private final UserService memberService;

	@GetMapping("/purchase")
	public String purchase(@RequestParam(value = "roomId") String roomId, @RequestParam(value = "dates") String dates,
			Model model, Authentication authentication) {	
		if (authentication == null || authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")) == false) {
			return "pages/login";
		}

		Member member = memberService.findById(authentication.getName());

		String[] dateArr = dates.split(" - ");
		LocalDate checkinDate = LocalDate.parse(dateArr[0], DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate checkoutDate = LocalDate.parse(dateArr[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		long days = ChronoUnit.DAYS.between(checkinDate, checkoutDate);

		RoomDTO room = roomService.getRoomById(roomId);

		model.addAttribute("room", room);
		model.addAttribute("member", member);
		model.addAttribute("checkIn", checkinDate);
		model.addAttribute("checkOut", checkoutDate);
		model.addAttribute("days", days);

		return "pages/payment";
	}
}
