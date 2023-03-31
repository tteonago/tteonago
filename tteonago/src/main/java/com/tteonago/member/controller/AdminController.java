package com.tteonago.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.service.AreaService;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.reservation.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final ReservationService reservationService;
    private final HotelRepository hotelRepository;  
    private final AreaService areaService;  
    private final HotelService hotelService;
    
    @GetMapping("/admin")
    public String admin(Model model) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();

        List<Object[]> admin = reservationService.findReservationAll();
        model.addAttribute("admin", admin);
        
        addJsonAttribute(model, "hoteldata", hotelRepository.findHotelInfo(), mapper);
        addJsonAttribute(model, "totprofit", areaService.getProfitByArea(), mapper);
        addJsonAttribute(model, "preference", hotelService.findWhish(), mapper);

        return "pages/admin";        
    }
    
    private void addJsonAttribute(Model model, String attributeName, List<Object[]> data, ObjectMapper mapper) throws JsonProcessingException {
        String json = mapper.writeValueAsString(data);
        model.addAttribute(attributeName, json);
    }
}