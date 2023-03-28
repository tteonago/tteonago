package com.tteonago.hotel.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.repository.HotelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	public List<Object[]>findWhish(){
		List<Object[]> findTopWhish = hotelRepository.findWhish(PageRequest.of(0, 5));
		for (Object[] top : findTopWhish) {
			log.info("Service{}, {}",top[0],top[1]);
		}
		return findTopWhish;
	}
}
