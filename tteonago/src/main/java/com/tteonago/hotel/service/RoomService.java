package com.tteonago.hotel.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
	
	private final RoomRepository roomrepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public RoomDTO getRoomById(String roomId) {
		Room room = roomrepository.findById(roomId).orElse(null);
		return modelMapper.map(room, RoomDTO.class);
	}
	
}
