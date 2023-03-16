package com.tteonago.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Position {
	@NonNull
	@Column(name = "lng", precision = 10, scale = 6)
	private BigDecimal lng;
	
	@NonNull
	@Column(name = "lat", precision = 10, scale = 6)
	private BigDecimal lat;

	
	protected Position(){

    	}

   	public Position(BigDecimal lng,BigDecimal lat){
        	this.lng = lng;
        	this.lat = lat;
    	}
	//test
}
