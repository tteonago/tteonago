package com.tteonago.hotel.dto;

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
public class HotelImageDTO {
	
	private int imgId;
	
    private String hotelId;
    
    private String address;
    
}
