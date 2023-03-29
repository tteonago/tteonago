package com.tteonago.hotel.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tteonago.hotel.dto.HotelRegisterDTO;
import com.tteonago.hotel.dto.RoomDTO;
import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.HotelImage;
import com.tteonago.hotel.entity.Position;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.entity.RoomImage;
import com.tteonago.hotel.repository.AreaRepository;
import com.tteonago.hotel.repository.HotelImageRepository;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.repository.RoomImageRepository;
import com.tteonago.hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {
	
	private final HotelRepository hotelRepository;
	private final AreaRepository areaRepository;
	private final HotelImageRepository hotelImageRepository;
	private final RoomRepository roomRepository;
	private final RoomImageRepository roomImageRepository;

	public List<Hotel> gethotellist(String areaId, int star, int roomSize) {
		List<Hotel> hotels = hotelRepository.findHotelsByAreaIdAndStarAndRoomSize(areaId, star, roomSize);
		return hotels;
	}
	
	public Hotel getHotelById(String id) { 
		return hotelRepository.findById(id).orElse(null); 
	}
	
	public void insertHotel(HotelRegisterDTO hotelRegisterDTO, RoomDTO roomDTO, MultipartFile[] hotelfiles, MultipartFile[] roomfiles) {
		Optional<Area> areaOp = areaRepository.findById(hotelRegisterDTO.getArea());
		Area area = areaOp.orElseThrow();
		
		//hotelId
		int newHotelId = Integer.parseInt(hotelRepository.findMaxHotelIdByAId(area)) + 1;
		
		//insert hotel
		BigDecimal lat =  new BigDecimal(hotelRegisterDTO.getLat());
		BigDecimal lng =  new BigDecimal(hotelRegisterDTO.getLng());
		
		Hotel hotel = Hotel.builder()
				.hotelId(String.valueOf(newHotelId))
				.area(area)
				.hotelName(hotelRegisterDTO.getHotelName())
				.hotelAddress(hotelRegisterDTO.getHotelAddress())
				.hotelPhone(hotelRegisterDTO.getHotelPhone())
				.hotelInfo(hotelRegisterDTO.getHotelInfo())
				.profit(0)
				.hotelPosition(new Position(lat, lng))
				.star(5)
				.build();
		hotelRepository.save(hotel);
		
		//insert room
		Room room = Room.builder()
				.roomId(String.valueOf(newHotelId) + "a")
				.hotel(hotelRepository.findById(String.valueOf(newHotelId)).orElseThrow())
				.roomType(roomDTO.getRoomType())
				.price(roomDTO.getPrice())
				.roomSize(roomDTO.getRoomSize())
				.build();
		roomRepository.save(room);
		
		//insert hotelImage
		for(MultipartFile m : hotelfiles) {
			HotelImage hotelImage = HotelImage.builder()
					.hotel(hotelRepository.findById(String.valueOf(newHotelId)).orElseThrow())
					.address("images/" + m.getOriginalFilename())
					.build();
			hotelImageRepository.save(hotelImage);
		}
		
		//insert roomImage ->수정해야함
		for(MultipartFile m : roomfiles) {
			RoomImage roomImage = RoomImage.builder()
					.room(roomRepository.findById(String.valueOf(newHotelId) + "a").orElseThrow())
					.address("images/" + m.getOriginalFilename())
					.build();
			roomImageRepository.save(roomImage);
		}
	}
	public List<Object[]>findWhish(){
		List<Object[]> findTopWhish = hotelRepository.findWhish(PageRequest.of(0, 5));
		for (Object[] top : findTopWhish) {
			log.info("Service{}, {}",top[0],top[1]);
		}
		return findTopWhish;
	}
}
