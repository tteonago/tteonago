package com.tteonago;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.tteonago.hotel.controller.AreaCategoryController;

@SpringBootTest
class TteonagoApplicationTests {
	
	 @Autowired
	    private AreaCategoryController mapController;
	    
	    @Test
	    void testMap() {
//	        Model model = new org.springframework.ui.ConcurrentModel();
//	        String lat = "37.529359";
//	        String lng = "126.982102";
//	        
//	        //String result = mapController.map(model, lat, lng);
//	        
//	        assertThat(result).isEqualTo("pages/map");
//	        assertThat(model.getAttribute("lat")).isEqualTo(new BigDecimal(lat));
//	        assertThat(model.getAttribute("lng")).isEqualTo(new BigDecimal(lng));
//	        
//	        BigDecimal actualLat = (BigDecimal) model.getAttribute("lat");
//	        BigDecimal actualLng = (BigDecimal) model.getAttribute("lng");
//
//	        assertThat(actualLat).isEqualTo(new BigDecimal(lat));
//	        assertThat(actualLng).isEqualTo(new BigDecimal(lng));
	        
	    }

	    
}
