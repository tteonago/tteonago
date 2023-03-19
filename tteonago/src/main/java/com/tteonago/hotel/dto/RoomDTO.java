package com.tteonago.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
public class RoomDTO {
	private String roomId;
	
	private HotelDTO hotel;
	
	private String roomType;
	
	private Integer price;
	
	private Integer roomSize;
}
