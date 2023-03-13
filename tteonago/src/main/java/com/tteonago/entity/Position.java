package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Position {
	@NonNull
	@Column(name = "lng")
	private Double lng;
	
	@NonNull
	@Column(name = "lat")
	private Double lat;
	
}
