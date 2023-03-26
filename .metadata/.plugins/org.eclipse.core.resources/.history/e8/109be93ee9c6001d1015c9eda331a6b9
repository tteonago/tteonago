package com.tteonago.hotel.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.service.AreaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AreaController {

	private final AreaService areaService;

//	@GetMapping("/map")
//	public ModelAndView map(@RequestParam String area, Model model) throws TteonagoException {
//		AreaDTO areaDTO = areaService.getAreaById(area);
//		List<Hotel> hotels = areaService.getHotelByArea(area);
//
//		for (Hotel h : hotels) {
//			System.out.println(h);
//		}
//
//		model.addAttribute("area", areaDTO);
//		model.addAttribute("hotels", hotels);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("pages/map");
//
//		return mv;
//	}
}