package com.tteonago.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.dto.HotelMapDTO;
import com.tteonago.hotel.service.AreaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AreaController {
	
	private final AreaService areaService;

	private final RedisTemplate<String, List<AreaDTO>> areaRedisTemplate;

/*	@GetMapping("/category")
	public String home(Model model){
		List<AreaDTO> areaDTOs = areaService.getAllAreas();
		model.addAttribute("areas", areaDTOs);
		return "pages/index";
	}*/

	@GetMapping("/category")
	@Cacheable(value = "areas")
	public String home(Model model) {
		List<AreaDTO> areaDTOs = areaRedisTemplate.opsForValue().get("areas");

		if (areaDTOs == null) {
			areaDTOs = areaService.getAllAreas();
			areaRedisTemplate.opsForValue().set("areas", areaDTOs);
		}

		model.addAttribute("areas", areaDTOs);

		return "pages/index";
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
