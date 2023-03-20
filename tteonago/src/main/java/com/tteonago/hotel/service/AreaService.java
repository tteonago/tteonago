package com.tteonago.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.dto.HotelDTO;
import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.entity.Position;
import com.tteonago.hotel.repository.AreaRepository;
import com.tteonago.hotel.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
	
	private final AreaRepository areaRepository;
	private final HotelRepository hotelRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<AreaDTO> getAllAreas() throws TteonagoException {
	    List<Area> areas = areaRepository.findAll();
	    List<AreaDTO> areaDTOs = new ArrayList<>();
	    
	    for (Area area : areas) {
	        areaDTOs.add(modelMapper.map(area, AreaDTO.class));
	    }
	
	    return areaDTOs;
	}
	
	public AreaDTO getAreaById(String areaId) throws TteonagoException {
	    Area area = areaRepository.findById(areaId)
	        .orElseThrow(() -> new TteonagoException("Area not found"));
	    return modelMapper.map(area, AreaDTO.class);
	}
	
	public List<HotelDTO> getHotelByArea(String areaId) throws TteonagoException {
		Area area = areaRepository.findById(areaId)
		        .orElseThrow(() -> new TteonagoException("Area not found"));
		List<Object[]> hotelList = hotelRepository.findHotelAndImgByArea(area);
		
		List<HotelDTO> hotelDTOs = new ArrayList<>();
		
		for(Object[] o : hotelList) {
			HotelDTO hotelDTO = HotelDTO.builder()
					.hotelId((String) o[0])
					.hotelAddress((String) o[1])
					.hotelName((String) o[2])
					.hotelPhone((String) o[3])
					.hotelPosition((Position) o[4])
					.address((String) o[5])
					.build();
			hotelDTOs.add(hotelDTO);
		}
		
		return hotelDTOs;
	}
	
}