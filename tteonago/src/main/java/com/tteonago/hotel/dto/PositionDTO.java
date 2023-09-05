package com.tteonago.hotel.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString
public class PositionDTO implements Serializable {
	private BigDecimal lng;
	
	private BigDecimal lat;
}
