package com.tteonago.hotel.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Position {
	@NonNull
	@Column(name = "lat", precision = 10, scale = 6)
	private BigDecimal lat;

	@NonNull
	@Column(name = "lng", precision = 10, scale = 6)
	private BigDecimal lng;
	
}
