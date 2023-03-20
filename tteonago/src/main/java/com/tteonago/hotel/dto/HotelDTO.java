package com.tteonago.hotel.dto;

import com.tteonago.hotel.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor

@Setter
@Getter
@ToString
@Builder
public class HotelDTO {
	
	private String hotelId;
	
	private String hotelName;
	
	private String address;
	
	private String hotelAddress;
	
	private String hotelPhone;
	
	private Position hotelPosition;
	
}
