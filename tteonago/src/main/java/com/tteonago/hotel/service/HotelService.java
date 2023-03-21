package com.tteonago.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.repository.HotelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	//호텔 리스트
	public List<Hotel> gethotellist(String areaId, int star, int roomSize) {
		List<Hotel> hotels = hotelRepository.findHotelsByAreaIdAndStarAndRoomSize(areaId, star, roomSize);
		return hotels;
	}
	
	
	//호텔 detail
	public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElse(null);
    }
    
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
