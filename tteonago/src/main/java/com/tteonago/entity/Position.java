package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Position {
	@NonNull
	@Column(name = "lng")
	private Double lng;
	
	@NonNull
	@Column(name = "lat")
	private Double lat;
	protected Position(){

    	}

   	public Position(Double lng,Double lat){
        	this.lng = lng;
        	this.lat = lat;
    	}
	
}
