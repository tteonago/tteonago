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
public class RoomImageDTO {
	
	private int imgId;
	
    private String roomId;
    
    private String address;
    
}
