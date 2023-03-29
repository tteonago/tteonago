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
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ReservationService reservationService;

    private final HotelRepository hotelRepository;
    
    private final AreaService areaService;
    
    private final HotelService hotelservice;
    
    @GetMapping("/admin")
    public String admin(Model model) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();

    	List<Object[]> admin = reservationService.findReservationAll();
        model.addAttribute("admin",admin);

        List<Object[]> hotels = hotelRepository.findHotelInfo();
        String json = mapper.writeValueAsString(hotels);
        model.addAttribute("hoteldata",json);

        List<Object[]> totprofit = areaService.getProfitByArea();
        String totprofitJson = mapper.writeValueAsString(totprofit);
        model.addAttribute("totprofit",totprofitJson);
        
        List<Object[]> preference = hotelservice.findWhish();
        String preferenceJson = mapper.writeValueAsString(preference);
        model.addAttribute("preference",preferenceJson);
        
        return "pages/admin";
    }   
}
