package com.tteonago.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.HotelImage;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, String> {
	@Query("select hi from Hotel h join HotelImage hi on h.hotelId = hi.hotel and hi.address like '%1.jpg' where h.area = :area")
	List<HotelImage> findHotelAndImgByArea(@Param("area")Area area);
}
