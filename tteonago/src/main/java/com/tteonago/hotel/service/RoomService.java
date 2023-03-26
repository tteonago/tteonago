package com.tteonago.hotel.service;

import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	private final RoomRepository roomrepository;
	
	public Room getroomById(String roomId) {
		return roomrepository.findById(roomId).orElse(null);
	}

}
