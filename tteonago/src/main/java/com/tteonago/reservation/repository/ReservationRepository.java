package com.tteonago.reservation.repository;

import java.util.List;

import com.tteonago.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	@Query("select r from Reservation r where r.member = :member")
	public List<Reservation> findReservationByMember(@Param("member") Member member);
	
	@Query("select res, h.hotelName from Room rm join Reservation res on rm.roomId = res.room join Hotel h on rm.hotel = h.hotelId where res.member = :member")
	public List<Object[]> findAllResByMember(@Param("member") Member member);

	@Query("select r from Reservation r where r.room = :room")
	public List<Reservation> findReservationByRoom(Room room);
}
