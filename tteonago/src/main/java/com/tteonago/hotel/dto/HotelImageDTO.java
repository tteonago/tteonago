package com.tteonago.hotel.dto;

import java.util.List;

import com.tteonago.hotel.entity.Position;

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
public class HotelImageDTO {
	private int imgId;
    private String hotelId;
    private String address;
}
