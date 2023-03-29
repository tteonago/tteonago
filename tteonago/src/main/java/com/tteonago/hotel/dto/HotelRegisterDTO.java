package com.tteonago.hotel.dto;

import java.util.List;

import com.tteonago.hotel.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor

@Setter
@Getter
@ToString
public class HotelRegisterDTO {
	
	private String hotelName;
	private String area;
	private String hotelAddress;
	private String hotelPhone;
	private String hotelInfo;
	private String lat;
	private String lng;
}
