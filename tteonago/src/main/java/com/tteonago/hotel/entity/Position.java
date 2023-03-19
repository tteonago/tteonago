package com.tteonago.hotel.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString

@Embeddable
public class Position {
	@NonNull
	@Column(name = "lng", precision = 10, scale = 6)
	private BigDecimal lng;
	
	@NonNull
	@Column(name = "lat", precision = 10, scale = 6)
	private BigDecimal lat;
}
