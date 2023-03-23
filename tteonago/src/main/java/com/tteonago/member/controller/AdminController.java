package com.tteonago.member.controller;

import com.tteonago.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/admin")
    public String admin(Model model){

        List<Object[]> admin = reservationService.findReservationAll();
        model.addAttribute("admin",admin);

        return "pages/admin";
    }

}
