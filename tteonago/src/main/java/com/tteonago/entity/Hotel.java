package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="hotel")
public class Hotel {
	@Id
	private String hotelId;
	
	@ManyToOne
	@JoinColumn(name="aId")
	private Area area;
	
	@NonNull
	@Column(name = "hotelName")
	private String hotelName;
	
	@NonNull
	@Column(name = "hotelAddress")
	private String hotelAddress;
	
	@NonNull
	@Column(name = "hotelPhone")
	private String hotelPhone;
	
	@NonNull
	@Column(name = "hotelInfo")
	private String hotelInfo;
	
	@Embedded 
	private Position hotelPosition;
	
	@NonNull
	@Column(name = "star")
	private Integer star;
	
	@NonNull
	@Column(name = "profit")
	private Integer profit ;
}
