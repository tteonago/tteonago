package com.tteonago.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.service.AreaService;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.reservation.service.ReservationService;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ReservationService reservationService;

    private final HotelRepository hotelRepository;
    
    private final AreaService areaService;
    
    @GetMapping("/admin")
    public String admin(Model model) throws JsonProcessingException {

        List<Object[]> admin = reservationService.findReservationAll();
        model.addAttribute("admin",admin);

        List<Object[]> hotels = hotelRepository.findHotelInfo();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hotels);
        model.addAttribute("hoteldata",json);

        List<Object[]> totprofit = areaService.getProfitByArea();
        for (Object[] row : totprofit) {
			log.info("Area : {},Profit : {}",row[0],row[1]);
		}
        model.addAttribute("totprofit",totprofit);
        
        return "pages/admin";
    }


    
}
