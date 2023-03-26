package com.tteonago.reservation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.service.AreaService;
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
		
		Period period = new Period(LocalDatein, LocalDateOut);
		reservation.setPeriod(period);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);
		
		reservation.setPayDate(parsedDateTime);

		Room room = new Room();
		room.setRoomId(roomid);
		reservation.setRoom(room);

		reservation.setTotPrice(totPrice);
		
		reservationservice.addReservation(reservation);
		reservationservice.addProfit(roomid, totPrice);
		
		return "redirect:/mypage";
	}

}