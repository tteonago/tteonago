package com.tteonago.hotel.dto;

import java.util.List;

import com.tteonago.hotel.entity.Position;
import com.tteonago.hotel.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString
public class HotelDTO {
	private String hotelId;
	
	private AreaDTO area;
	
	private String hotelName;
	
	private String hotelAddress;
	
	private String hotelPhone;
	
	private String hotelInfo;
	
	private Position hotelPosition;
	
	private Integer star;
	
	private Integer profit;
	
	private List<RoomDTO> room;
	
	private List<HotelImageDTO> images;
}
