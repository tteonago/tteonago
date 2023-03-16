package com.tteonago.hotel.dto;

import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.Position;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelDTO {
	private String hotelId;
	private Area area;
	private String hotelName;
	private String hotelAddress;
	private String hotelPhone;
	private String hotelInfo;
	private Position hotelPosition;
	private Integer star;
	private Integer profit;
}
