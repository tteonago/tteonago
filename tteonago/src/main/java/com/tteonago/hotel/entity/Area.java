package com.tteonago.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="area")
public class Area {
	
	@Id
	private String aId; 
	
	@NonNull
	@Column(name = "aName")
	private String aName;
	
	
	@NonNull
	@Column(name = "level")
    private Integer level;  
	
	@Embedded 
	private Position localPosition;
	
}
