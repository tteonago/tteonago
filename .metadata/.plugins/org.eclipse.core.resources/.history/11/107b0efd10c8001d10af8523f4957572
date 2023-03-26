package com.tteonago.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.repository.RoomRepository;

@Service
public class HotelDetailServise {

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<RoomDTO> getRoomByHotel(String hotelId) throws TteonagoException {
		Hotel hotel = hotelRepository.findById(hotelId)
				 .orElseThrow(() -> new TteonagoException("Hotel not found"));
		List<Room> rooms = roomRepository.findRoomByHotel(hotel);
		
		return rooms.stream()
				.map(room -> modelMapper.map(room, RoomDTO.class))
				.collect(Collectors.toList());
		
	}
	
	
}
