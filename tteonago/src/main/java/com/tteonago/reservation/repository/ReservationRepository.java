package com.tteonago.reservation.repository;

import com.tteonago.hotel.entity.Room;
import com.tteonago.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("select r from Reservation r where r.room = :room")
    List<Reservation> findReservationByRoom(Room room);
}
