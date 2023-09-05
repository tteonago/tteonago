package com.tteonago.hotel.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.dto.HotelMapDTO;
import com.tteonago.hotel.service.AreaService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AreaController {
	
	private final AreaService areaService;

//	private final RedisTemplate<String, List<AreaDTO>> areaRedisTemplate;
//	private final RedisTemplate<String, Object> areaRedisTemplateV2;
	private final RedisTemplate<String, String> redisTemplate;

/*	@GetMapping("/category")
	public String home(Model model){
		List<AreaDTO> areaDTOs = areaService.getAllAreas();
		model.addAttribute("areas", areaDTOs);
		return "pages/index";
	}*/

//	@GetMapping("/category")
//	@Cacheable(value = "areas")
//	public String home(Model model) {
//		List<AreaDTO> areaDTOs = areaRedisTemplate.opsForValue().get("areas");
//
//		if (areaDTOs == null) {
//			areaDTOs = areaService.getAllAreas();
//			areaRedisTemplate.opsForValue().set("areas", areaDTOs);
//			areaRedisTemplate.expire("areas", 600, TimeUnit.SECONDS);
//		}
//
//		model.addAttribute("areas", areaDTOs);
//
//		return "pages/index";
//	}
	
//	@GetMapping("/category")
//	@Cacheable(value = "areas")
//	public String home(Model model) throws Exception {
//	    String key = "areas";
//	    Object areaDTOs = areaRedisTemplateV2.opsForValue().get(key);
//
//	    if (areaDTOs == null) {
//	        areaDTOs = areaService.getAllAreas();
//	        areaRedisTemplateV2.opsForValue().set(key, areaDTOs);
//	        areaRedisTemplateV2.expire(key, 600, TimeUnit.SECONDS);
//	    }
//
//	    model.addAttribute("areas", areaDTOs);
//
//	    return "pages/index";
//	}
	
//	@GetMapping("/category")
//	@Cacheable(value = "areas")
//	public String home(Model model) throws Exception {
//	    List<AreaDTO> areaDTOs;
//	    String cacheValue = redisTemplate.opsForValue().get("areas");
//
//	    if (cacheValue == null) {
//	        areaDTOs = areaService.getAllAreas();
//	        String serializedValue = new ObjectMapper().writeValueAsString(areaDTOs);
//	        redisTemplate.opsForValue().set("areas", serializedValue);
//	        redisTemplate.expire("areas", 600, TimeUnit.SECONDS);
//	    } else {
//	        areaDTOs = new ObjectMapper().readValue(cacheValue, new TypeReference<List<AreaDTO>>() {});
//	    }
//
//	    model.addAttribute("areas", areaDTOs);
//
//	    return "pages/index";
//	}
	
	@GetMapping("/category")
	@Cacheable(value = "areas")
	public String home(Model model) throws Exception {
	    List<AreaDTO> areaDTOs = getCachedAreas();

	    if (areaDTOs == null) {
	        areaDTOs = areaService.getAllAreas();
	        cacheAreas(areaDTOs);
	    }

	    model.addAttribute("areas", areaDTOs);

	    return "pages/index";
	}

	private List<AreaDTO> getCachedAreas() throws Exception {
	    String cacheValue = redisTemplate.opsForValue().get("areas");

	    if (cacheValue != null) {
	        return new ObjectMapper().readValue(cacheValue, new TypeReference<List<AreaDTO>>() {});
	    }

	    return null;
	}

	private void cacheAreas(List<AreaDTO> areaDTOs) throws Exception {
	    String serializedValue = new ObjectMapper().writeValueAsString(areaDTOs);
	    redisTemplate.opsForValue().set("areas", serializedValue, 600, TimeUnit.SECONDS);
	}
    
	@ApiOperation(	
		    value = "선택한 지역으로 이동",
		    notes = "해당 지역의 areaId를 조건으로 map.html 접근")
	@GetMapping("/map")
	public String map(@RequestParam String area, Model model)throws JsonProcessingException {
		AreaDTO areaDTO = areaService.getAreaById(area);
		List<HotelMapDTO> hotels = areaService.getHotelByArea(area);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(hotels);

		model.addAttribute("area", areaDTO);
		model.addAttribute("hotels", json);

		return "pages/map";
	}
	
}

	
	
	
	
	
	
	
	
	
	

