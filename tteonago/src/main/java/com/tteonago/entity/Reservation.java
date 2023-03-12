package com.tteonago.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resIndex")
	private int resIndex;
	
	@NonNull
	@OneToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="username")
	private Member member;
	
	@NonNull
	@Column(name = "checkIn")
	private LocalDateTime checkIn;
	
	@NonNull
	@Column(name = "checkOut")
	private LocalDateTime checkOut;
	
	@NonNull
	@Column(name = "payDate")
	private LocalDateTime payDate;
	
	@NonNull
	@Column(name = "totPrice")
	private Integer totPirce;
}
