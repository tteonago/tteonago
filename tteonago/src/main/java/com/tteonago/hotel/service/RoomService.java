package com.tteonago.hotel.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.dto.RoomDTO;
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
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Room getroomById(String roomId) {
		return roomrepository.findById(roomId).orElse(null);
	}
	
	public List<Room> getRoomByHotelId(String hotelId) {
		Optional<Hotel> hotelOp = hotelRepository.findById(hotelId);
		Hotel hotel = hotelOp.orElseThrow();
		
		List<Room> roomList = roomrepository.findRoomByHotelId(hotel);
		
		return roomList;
	}

	public RoomDTO getRoomById(String roomId) {
		Room room = roomrepository.findById(roomId).orElse(null);
		return modelMapper.map(room, RoomDTO.class);
	}
	
}
