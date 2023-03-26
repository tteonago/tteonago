package com.tteonago.reservation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.service.AreaService;
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
	public String purchase(@RequestParam(value = "roomId") String roomId, @RequestParam(value = "dates") String dates, Model model, Authentication authentication) {
		if (authentication == null || authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")) == false) {
			return "pages/login";
		}
		
		Member member = null;
		
		if (authentication != null) {
			member = memberService.findById(authentication.getName());	 
	    }
		
		String[] dateArr = dates.split(" - ");
		String checkin = dateArr[0];
		String checkout = dateArr[1];
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //기존의 String 날짜 포멧 데이터 형식 지정
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //변경할 String 날짜 포멧 데이터 형식 지정
		
		LocalDate checkinDate = LocalDate.parse(checkin, inputFormatter);
		LocalDate checkoutDate = LocalDate.parse(checkout, inputFormatter);
		
		String formattedCheckin = checkinDate.format(outputFormatter);
		String formattedCheckout = checkoutDate.format(outputFormatter);		
		
		LocalDate LocalDatein = LocalDate.parse(formattedCheckin);
		LocalDate LocalDateOut = LocalDate.parse(formattedCheckout);
		
		long daysBetween = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
	
		long nights = daysBetween;
		
		long Days = nights;
		
		Room room = roomService.getroomById(roomId);
		
		model.addAttribute("room", room);
		model.addAttribute("member", member);
		model.addAttribute("checkIn", LocalDatein);
		model.addAttribute("checkOut", LocalDateOut);
		model.addAttribute("days", Days);
		
		return "pages/payment";
	}
}
