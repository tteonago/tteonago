package com.tteonago.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	private final RoomRepository roomrepository;
	private final HotelRepository hotelRepository;
	
	public Room getroomById(String roomId) {
		return roomrepository.findById(roomId).orElse(null);
	}
	
	public List<Room> getRoomByHotelId(String hotelId) {
		Optional<Hotel> hotelOp = hotelRepository.findById(hotelId);
		Hotel hotel = hotelOp.orElseThrow();
		
		List<Room> roomList = roomrepository.findRoomByHotelId(hotel);
		
		return roomList;
	}

}
