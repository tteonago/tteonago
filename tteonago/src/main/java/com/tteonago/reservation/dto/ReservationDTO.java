package com.tteonago.reservation.dto;

import java.time.LocalDateTime;

import com.tteonago.hotel.entity.Room;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Period;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString
public class ReservationDTO {
	private Integer resIndex;
	
	private Room room;
	
	private Member member;
	
	private Period period;
	
	private LocalDateTime payDate;
	
	private Integer totPrice;
	
	private String roomType;
}
