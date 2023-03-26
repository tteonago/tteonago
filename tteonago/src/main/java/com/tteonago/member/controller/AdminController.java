package com.tteonago.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.reservation.service.ReservationService;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ReservationService reservationService;

    private final HotelRepository hotelRepository;

    @GetMapping("/admin")
    public String admin(Model model) throws JsonProcessingException {

        List<Object[]> admin = reservationService.findReservationAll();
        model.addAttribute("admin",admin);

        List<Object[]> hotels = hotelRepository.findHotelInfo();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hotels);
        model.addAttribute("hoteldata",json);

        return "pages/admin";
    }

}
