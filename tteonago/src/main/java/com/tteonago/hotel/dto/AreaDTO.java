package com.tteonago.hotel.dto;

import com.tteonago.hotel.entity.Position;

import lombok.Data;
import lombok.ToString;

@Data

@ToString
public class AreaDTO {
	private String aId;
	private String aName;
	private int level;
	private Position localPosition;
}
