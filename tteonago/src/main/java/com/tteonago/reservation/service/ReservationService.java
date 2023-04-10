package com.tteonago.reservation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

	public HashMap<String, ReservationDTO> findReservationByUsername(Member member) {
		List<Object[]> reservations = reservationRepository.findAllResByMember(member);

		return reservations.stream().collect(Collectors.toMap(res -> (String) res[1],
				res -> modelMapper.map(res[0], ReservationDTO.class), (oldValue, newValue) -> oldValue, HashMap::new));
	}

	public void addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	public void addProfit(String roomId, int totPrice) {
		hotelRepository
				.findById(roomRepository.findById(roomId).map(Room::getHotel).map(Hotel::getHotelId).orElse(null))
				.ifPresent(hotel -> {
					hotel.setProfit(hotel.getProfit() + totPrice);
					hotelRepository.save(hotel);
				});
	}

	public List<Object[]> findReservationAll() {
		return reservationRepository.findAllReservation();
	}
	
	public List<Integer> findReservationDate(String checkIn, String checkOut, List<Room> roomList) {
		LocalDate checkInParse = LocalDate.parse(checkIn);
		LocalDate checkOutParse = LocalDate.parse(checkOut);
		
		List<Integer> available = new ArrayList<>();
		
		for(Room r : roomList) {
			List<Reservation> resIn =  reservationRepository.findReservationByDate(checkInParse, r);
			List<Reservation> resOut =  reservationRepository.findReservationByDate(checkOutParse, r);
			available.add(resIn.size() + resOut.size());
		}
		return available;
	}

}
