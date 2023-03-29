package com.tteonago.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.dto.HotelMapDTO;
import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.entity.HotelImage;
import com.tteonago.hotel.repository.AreaRepository;
import com.tteonago.hotel.repository.HotelImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
	
	private final AreaRepository areaRepository;
	private final HotelImageRepository hotelImageRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<AreaDTO> getAllAreas() throws TteonagoException {
	    List<Area> areas = areaRepository.findAll();
	    return areas.stream()
	            .map(area -> modelMapper.map(area, AreaDTO.class))
	            .collect(Collectors.toList());
	}
	
	public AreaDTO getAreaById(String areaId) throws TteonagoException {
	    Area area = areaRepository.findById(areaId)
	        .orElseThrow(() -> new TteonagoException("Area not found"));
	    return modelMapper.map(area, AreaDTO.class);
	}
	
	public List<HotelMapDTO> getHotelByArea(String areaId) throws TteonagoException {
		Area area = areaRepository.findById(areaId)
		        .orElseThrow(() -> new TteonagoException("Area not found"));
		List<HotelImage> hotels = hotelImageRepository.findHotelAndImgByArea(area);
		
		return hotels.stream()
				.map(hotel -> modelMapper.map(hotel, HotelMapDTO.class))
				.collect(Collectors.toList());
	}
	
}