package com.tteonago.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.service.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping
	public ResponseEntity<List<AreaDTO>> getAllAreas() throws TteonagoException {
		List<AreaDTO> areaDTOs = areaService.getAllAreas();
		return new ResponseEntity<>(areaDTOs, HttpStatus.OK);
	}
	
}
