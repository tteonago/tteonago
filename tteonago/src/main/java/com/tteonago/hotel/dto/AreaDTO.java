package com.tteonago.hotel.dto;

import com.tteonago.hotel.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AreaDTO {
	private String aId;
	private String aName;
	private Integer level;
	private Position localPosition;
}
