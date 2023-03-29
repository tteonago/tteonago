package com.tteonago.reservation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tteonago.hotel.entity.Room;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.dto.ReservationRequestDTO;
import com.tteonago.reservation.entity.Period;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.service.ReservationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {

	private final ReservationService reservationservice;

	@PostMapping("/addreservation")
	public String ReservationInsert(@RequestBody ReservationRequestDTO reservationRequest, Reservation reservation) {
		String roomid = reservationRequest.getRoomId();
	    String username = reservationRequest.getFirstname();
	    String checkin = reservationRequest.getCheckIn();
	    String checkout = reservationRequest.getCheckOut();
	    int totPrice = reservationRequest.getTotPrice();
	    
	    Member member = new Member();
        member.setUsername(username);
        reservation.setMember(member);
	    
        LocalDate LocalDatein = LocalDate.parse(checkin);
		LocalDate LocalDateOut = LocalDate.parse(checkout);
		
		reservation.setPeriod(new Period(LocalDatein, LocalDateOut));
		reservation.setPayDate(LocalDateTime.now());

		Room room = new Room();
		room.setRoomId(roomid);
		reservation.setRoom(room);

		reservation.setTotPrice(totPrice);
		
		reservationservice.addReservation(reservation);
		reservationservice.addProfit(roomid, totPrice);
		
		return "redirect:/mypage";
	}
	
	@GetMapping("/mypages")
	public String mypage() {
		return "redirect:/mypage";
	}

}