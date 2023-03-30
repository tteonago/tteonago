package com.tteonago.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.hotel.service.AreaService;
import com.tteonago.hotel.service.HotelService;
import com.tteonago.reservation.entity.Review;
import com.tteonago.reservation.service.ReservationService;
import com.tteonago.reservation.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ReservationService reservationService;

    private final HotelRepository hotelRepository;
    
    private final AreaService areaService;
    
    private final HotelService hotelservice;
    
    private final ReviewService reviewservice;
    
    @GetMapping("/admin")
    public String admin(Model model) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	List<Review> reviews = reviewservice.getAllReviews();
    	model.addAttribute("reviews", reviews);
    	
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
    @PostMapping("/reviews/{id}")
    public String deleteReview(@PathVariable("id") int id) {
        reviewservice.deleteReviewById(id);
        return "redirect:/admin";
    }
}
