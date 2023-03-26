package com.tteonago.reservation.repository;

//import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.entity.Room;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

    @Query("select rv from Review rv where rv.reservation = :reservation")
    Review findReviewByReservation(@Param("reservation") Reservation reservation);

    @Query("select rs.resIndex from Reservation rs , Review rv where rs.resIndex = rv.reservation and rs.member = :member")
    List<Integer> findResIndexByUsername(@Param("member") Member member);

    @Query("select rw, rn.member from Review rw , Reservation rn, Room rm, Hotel h where rw.reservation = rn.resIndex and rn.room = rm.roomId and rm.hotel = h.hotelId and h.hotelId = :hotelId")
    List<Object[]> findReviewByHotelId(@Param("hotelId") String hotelId);

//    @Query("select rv from Reservation r join Review rv on r.resIndex = rv.reservation.resIndex where r.room = :room")
//    List<Review> findReservationAndReviewByRoom(@Param("room") Room room);
}
