package com.tteonago;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tteonago.hotel.service.HotelService;

@SpringBootTest
class TteonagoApplicationTests {
    
	@Autowired
	private HotelService hotelservice;
	
	@Test
	void testMap() {
		hotelservice.findWhish();
		
	}

}
