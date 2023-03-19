package com.tteonago.hotel.dto;

import java.time.LocalDate;

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
public class PeriodDTO {
	private LocalDate checkIn;
	
	private LocalDate checkOut;
}
