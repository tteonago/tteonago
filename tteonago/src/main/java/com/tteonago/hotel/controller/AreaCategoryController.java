package com.tteonago.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.service.AreaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class AreaCategoryController {
	
    private final AreaService areaService;

    @GetMapping("/category")
    public String sample(Model model)throws TteonagoException {
      
        List<AreaDTO> areaDTOs = areaService.getAllAreas();
        model.addAttribute("areas", areaDTOs);
      
        return "pages/index";
    }
}