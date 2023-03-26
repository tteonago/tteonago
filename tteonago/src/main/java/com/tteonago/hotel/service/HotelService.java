package com.tteonago.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelService {
	
	private final HotelRepository hotelRepository;

	public List<Hotel> gethotellist(String areaId, int star, int roomSize) {
		List<Hotel> hotels = hotelRepository.findHotelsByAreaIdAndStarAndRoomSize(areaId, star, roomSize);
		return hotels;
	}
	
	public Hotel getHotelById(String id) { 
		return hotelRepository.findById(id).orElse(null); 
	}

}
