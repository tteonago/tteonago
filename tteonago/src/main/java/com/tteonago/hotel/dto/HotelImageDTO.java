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
public class HotelImageDTO {
	private int imgId;
	
    private String hotelId;
    
    private String address;
}
