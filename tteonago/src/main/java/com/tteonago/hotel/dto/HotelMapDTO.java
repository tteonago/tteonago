package com.tteonago.hotel.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor

@Setter
@Getter
@ToString
@Builder
public class HotelMapDTO implements Serializable {
	private String hotelId;
	
	private String hotelName;
	
	private String hotelAddress;
	
	private String hotelPhone;
	
	private PositionDTO hotelPosition;
	
	private String address;
}
