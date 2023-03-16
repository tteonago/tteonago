package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@Column(name = "roomId")
	private String roomId;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="hotelId")
	private Hotel hotel;
	
	@NonNull
	@Column(name = "roomType")
	private String roomType;
	
	@NonNull
	@Column(name = "price")
	private Integer price;
	
	@NonNull
	@Column(name = "roomSize")
	private Integer roomSize;
}
