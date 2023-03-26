package com.tteonago.reservation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tteonago.hotel.entity.Room;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.dto.ReservationRequestDTO;
import com.tteonago.reservation.entity.Period;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationservice;

	@PostMapping("/addreservation")
	public String ReservationInsert(@RequestBody ReservationRequestDTO reservationRequest, Reservation reservation) {
		
		String roomid = reservationRequest.getRoomId();
	    String username = reservationRequest.getFirstname();
	    String checkin = reservationRequest.getCheckIn();
	    String checkout = reservationRequest.getCheckOut();
	    int totPrice = reservationRequest.getTotPrice();
	    
		//Reservation 엔티티에 Member 객체 값 세팅
		Member member = new Member(); 
		member.setUsername(username);
		reservation.setMember(member); 

		//Reservation 엔티티에 Period 객체 값 세팅
		LocalDate LocalDatein = LocalDate.parse(checkin);
		LocalDate LocalDateOut = LocalDate.parse(checkout);
		
		Period period = new Period(LocalDatein, LocalDateOut);
		reservation.setPeriod(period);
		
		//추후에 PayDate 타입의 LocalDateTime -> LocalDate 로 변경해야 할 수 도 있음 ==> ***수정안해도 될 듯 DB 정상 반영 됨
		//Reservation 엔티티에 PayDate 값 세팅
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);
		
		reservation.setPayDate(parsedDateTime);
		
		//Reservation 엔티티에 Room 객체 값 세팅
		Room room = new Room();
		room.setRoomId(roomid);
		reservation.setRoom(room);
		
		//Reservation 엔티티에 totPrice 값 세팅
		reservation.setTotPrice(totPrice);
		
		reservationservice.addReservation(reservation);
		reservationservice.addProfit(roomid, totPrice);
		
		return "pages/mypage";
	}

}