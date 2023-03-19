package com.tteonago.hotel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
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

@Entity
@Table(name="area")
public class Area {
	@Id
	private String aId; 
	
	@Embedded 
	private Position localPosition;
	
	@NonNull
	@Column(name = "level")
    private Integer level;  
	
	@NonNull
	@Column(name = "aName")
	private String aName;
	
	@OneToMany(mappedBy = "area")
	private List<Hotel> hotels;
}
