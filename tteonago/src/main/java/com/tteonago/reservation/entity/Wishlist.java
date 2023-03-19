package com.tteonago.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.member.entity.Member;

import lombok.NonNull;

@Entity
@Table(name="wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishindex")
	private int wishindex;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="username")
	private Member member;
	
	@NonNull
	//@OneToMany
	@ManyToOne
	@JoinColumn(name="hotelId")
	private Hotel hotel;
}
