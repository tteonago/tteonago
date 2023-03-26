package com.tteonago.reservation.service;

import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.repository.RoomRepository;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.dto.ReservationDTO;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	
	private final RoomRepository roomRepository;
	
	private final HotelRepository hotelRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	//select * from reservation where username = ? 
	public HashMap<String, ReservationDTO> findReservationByUsername(Member member) {
		List<Object[]> reservations = reservationRepository.findAllResByMember(member);
		
		HashMap<String, ReservationDTO> hotelAndReserv = new HashMap<>();
		
		for(Object[] res : reservations) {
			hotelAndReserv.put((String)res[1], modelMapper.map(res[0], ReservationDTO.class));
		}

		return hotelAndReserv;
	}
	
   // 예약 insert
   public void addReservation(Reservation reservation) {
	   System.out.println(reservation.toString());
	   reservationRepository.save(reservation);
	}
   
   public void addProfit(String roomId, int totPrice) {
	   
       Room room = roomRepository.findById(roomId).orElse(null);
       Hotel hotel = hotelRepository.findById(room.getHotel().getHotelId()).orElse(null);
       hotel.setProfit(hotel.getProfit() + totPrice);
       hotelRepository.save(hotel);
   }

	public List<Object[]> findReservationAll(){

		List<Object[]> admin = reservationRepository.findAllReservation();

		return admin;
	}

}
