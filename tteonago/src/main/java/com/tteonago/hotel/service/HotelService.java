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

//	 public List<Hotel> findHotelsByAddressAndStar(String address, Integer star) {
//	        return hotelRepository.findByHotelAddressContainingAndStar(address, star);
//	    }
//	
//	 public List<Hotel> findHotelsByAddressAndStarAndRoomSize(String address, Integer star, Integer roomSize) {
//		 	System.out.println(address);
//		 	System.out.println(star);
//		 	System.out.println(roomSize);
//	        return hotelRepository.findByHotelAddressContainingAndStarAndRoomRoomSize(address, star, roomSize);
//	   }	

//	public List<Hotel> findHotelsByAddressAndStar(String address, int star) {
//		System.out.println(address);
//	 	System.out.println(star);
//		return hotelRepository.findHotelsByAddressAndStar(address, star);
//	}
//	
//	public List<Hotel> findByHotelAddress(String address) {
//	    return hotelRepository.findByHotelAddressContaining(address);
//	}
//	
//	public Hotel findByHotelId(String id) {
//		return hotelRepository.findByHotelId(id);
//	}

	public List<Hotel> gethotellist(String areaId, int star, int roomSize) {
		List<Hotel> hotels = hotelRepository.findHotelsByAreaIdAndStarAndRoomSize(areaId, star, roomSize);
		System.out.println("hotels: " + hotels.get(0).getHotelId());
		return hotels;
	}

}
