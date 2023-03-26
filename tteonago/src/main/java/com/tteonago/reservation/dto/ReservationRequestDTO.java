package com.tteonago.reservation.dto;

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
public class ReservationRequestDTO {
	 private String roomId;
	 private String firstname;
	 private String checkIn;
	 private String checkOut;
	 private int totPrice;
}
