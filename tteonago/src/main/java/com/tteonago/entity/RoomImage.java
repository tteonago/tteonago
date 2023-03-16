package com.tteonago.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="roomImage")
public class RoomImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imgId;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	@NonNull
	@Column(name = "address")
	private String address;
}
