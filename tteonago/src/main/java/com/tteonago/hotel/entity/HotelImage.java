package com.tteonago.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;
import lombok.ToString;

@Entity
@ToString
@Table(name="hotelImage")
public class HotelImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imgId;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="hotelId")
	private Hotel hotel;
	
	@NonNull
	@Column(name = "address")
	private String address;
}
