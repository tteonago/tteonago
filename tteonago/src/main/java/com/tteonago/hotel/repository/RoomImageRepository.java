package com.tteonago.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.RoomImage;
@Repository
public interface RoomImageRepository extends JpaRepository<RoomImage, Integer>{
	
}
