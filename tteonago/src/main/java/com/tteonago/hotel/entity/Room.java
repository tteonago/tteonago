package com.tteonago.hotel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
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
	
	@OneToMany(mappedBy = "room")
	private List<RoomImage> images;
}
