package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="area")
public class Area {
	
	@Id
	private String aId; 
	
	@NonNull
	@Column(name = "lng")
	private Double lng;
	
	@NonNull
	@Column(name = "lat")
	private Double lat;
	
	@NonNull
	@Column(name = "level")
    private Integer level;  
	
	@NonNull
	@Column(name = "aName")
	private String aName;
}
