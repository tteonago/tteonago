package com.tteonago.hotel.service;

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
public class TestService {
	@Autowired
	private AreaRepository AreaDao;
	
	private ModelMapper mapper= new ModelMapper();
	
	public AreaDTO getArea(String aId) throws TteonagoException{
		Optional<Area> area = AreaDao.findById(aId);
		
		Area entity = area.orElseThrow(TteonagoException::new);
		
		return mapper.map(entity, AreaDTO.class);
	}
	
}
