package com.tteonago.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.dto.AreaDTO;
import com.tteonago.hotel.entity.Area;
import com.tteonago.hotel.repository.AreaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AreaService {
	@Autowired
	private AreaRepository areaRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<AreaDTO> getAllAreas() throws TteonagoException {
	    List<Area> areas = areaRepository.findAll();
	    List<AreaDTO> areaDTOs = new ArrayList<>();
	    for (Area area : areas) {
	        areaDTOs.add(modelMapper.map(area, AreaDTO.class));
	    }
	    return areaDTOs;
	}
	
}
