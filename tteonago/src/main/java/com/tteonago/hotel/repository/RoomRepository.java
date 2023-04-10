package com.tteonago.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
	@Query("select r from Room r join Hotel h on r.hotel = h.hotelId where r.hotel=:hotelId")
	List<Room> findRoomByHotel(@Param("hotelId")Hotel hotelId);
	
	@Query("select r from Room r where r.hotel = :hotel")
	List<Room> findRoomByHotelId(@Param("hotel")Hotel hotel);
}
