package com.tteonago.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomrepository;
	
	public Room getroomById(String roomId) {
		return roomrepository.findById(roomId).orElse(null);
	}

}
