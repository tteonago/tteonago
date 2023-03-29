package com.tteonago.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	//호텔 리스트
	public List<HotelDTO> getHotelList(String areaId, int star, int roomSize) {
		List<Hotel> hotels = hotelRepository.findHotelsByAreaIdAndStarAndRoomSize(areaId, star, roomSize);
		return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
	}
	
	//호텔 detail
	public HotelDTO getHotelById(String id) { 
		Hotel hotel = hotelRepository.findById(id).orElse(null);		
		return modelMapper.map(hotel, HotelDTO.class); 
	}
	
}
