package com.tteonago.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString
public class AreaDTO implements Serializable {
	private String aId;
	
	private String aName;
	
	private Integer level;
	
	private PositionDTO localPosition;
}
