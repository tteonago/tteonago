package com.tteonago.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
public class AreaDTO {
	private String aId;
	private String aName;
	private Integer level;  
	private PositionDTO localPosition;
}
