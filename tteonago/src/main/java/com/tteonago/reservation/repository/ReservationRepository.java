package com.tteonago.reservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Room;
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

	@Query("select r,m from Reservation r ,Member m where r.member = m.username")
	public List<Object[]> findAllReservation();
	
	@Query("select r from Reservation r where :date between r.period.checkIn and r.period.checkOut and r.room = :room")
	public List<Reservation> findReservationByDate(@Param("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate, @Param("room") Room room);
}
