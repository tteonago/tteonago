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
public class HotelMapDTO {
	
private String hotelId;
	
	private String hotelName;
	
	private String hotelAddress;
	
	private String hotelPhone;
	
	private Position hotelPosition;
	
	private String address;

}
