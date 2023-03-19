package com.tteonago.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Hotel;

@Repository 
public interface HotelRepository extends JpaRepository<Hotel, String>{
//	List<Hotel> findByHotelAddressContainingAndStar(String address, int star);
//	List<Hotel> findByHotelAddressContainingAndStarAndRoomRoomSize(String address, Integer star, Integer roomSize);
	
//	@Query("SELECT h FROM Hotel h WHERE h.hotelAddress LIKE %:address% AND h.star = :star")
//	List<Hotel> findHotelsByAddressAndStar(@Param("address") String address, @Param("star") int star);
	
//	@Query(value = "SELECT * FROM hotel WHERE hotel_address LIKE %:address% AND star = :star", nativeQuery = true)
//	List<Hotel> findHotelsByAddressAndStar(@Param("address") String address, @Param("star") int star);
		
//	List<Hotel> findByHotelAddressContaining(String hotelAddress);
//	
//	Hotel findByHotelId(String hotelId); //이거는 정상적으로 불러와요 데이터 값이
	
//	@Query(value = "SELECT * FROM hotel h JOIN area a ON h.a_id = a.a_id JOIN room r ON h.hotel_id = r.hotel_id WHERE a.a_id = :aId AND h.star = :star AND r.room_size = :roomSize", nativeQuery = true)
//	List<Hotel> findHotelsByAreaIdAndStarAndRoomSize(@Param("aId") String aId, @Param("star") int star, @Param("roomSize") int roomSize);
	
	@Query(value = "SELECT DISTINCT h.* FROM hotel h JOIN area a ON h.a_id = a.a_id JOIN room r ON h.hotel_id = r.hotel_id WHERE a.a_id = :aId AND h.star = :star AND r.room_size = :roomSize", nativeQuery = true)
	List<Hotel> findHotelsByAreaIdAndStarAndRoomSize(@Param("aId") String aId, @Param("star") int star, @Param("roomSize") int roomSize);

	
}