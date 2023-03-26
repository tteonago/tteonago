package com.tteonago.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.service.AreaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaController {
	
	private final AreaService areaService;
	
	@GetMapping("/map")
	public ResponseEntity<List<AreaDTO>> getAllAreas() throws TteonagoException {
		
		List<AreaDTO> areaDTOs = areaService.getAllAreas();
		
		return new ResponseEntity<>(areaDTOs, HttpStatus.OK);
	}
}