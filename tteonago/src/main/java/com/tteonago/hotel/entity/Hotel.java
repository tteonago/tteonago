package com.tteonago.hotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Builder
@ToString
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
	private Integer profit;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> room;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelImage> images;
}
