package com.tteonago.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.service.TestService;

@RestController
public class TestController {
	//localhost/test?aId=10
	@Autowired
	private TestService service;
	
	@GetMapping("test")
	public AreaDTO getArea(String aId)throws TteonagoException{
		
		return service.getArea(aId);
	}
	@ExceptionHandler
	public String notHandler (TteonagoException e) {
		e.printStackTrace();
		return "정보 미존재";
	}
	
	
}
