package com.tteonago.hotel.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{
	@Query(value = "SELECT DISTINCT h.* FROM hotel h JOIN area a ON h.a_id = a.a_id JOIN room r ON h.hotel_id = r.hotel_id WHERE a.a_id = :aId AND h.star = :star AND r.room_size = :roomSize", nativeQuery = true)
	List<Hotel> findHotelsByAreaIdAndStarAndRoomSize(@Param("aId") String aId, @Param("star") int star, @Param("roomSize") int roomSize);
	
	@Query("select h from Hotel h where h.area = :area")  
	List<Hotel> findHotelByArea(@Param("area") Area area);

	@Query("select h.hotelId,h.profit from Hotel h")
	List<Object[]> findHotelInfo();
	
	@Query("select max(h.hotelId) from Hotel h where h.area = :area")  
	String findMaxHotelIdByAId(@Param("area") Area area);
	
	@Query("select a.aName, SUM(h.profit) as totProfit from Hotel h join Area a on h.area = a.aId group by a.aId")
	List<Object[]> getProfitByArea();
	
	@Query("select h.hotelName as hotelName, count(w.hotel) as wishCount from Wishlist w join Hotel h on w.hotel = h.hotelId group by h.hotelName order by wishCount desc")
	List<Object[]> findWhish(PageRequest pageRequest);
}