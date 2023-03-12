package com.tteonago.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int revIndex;
	
	@NonNull
	@OneToOne
	@JoinColumn(name="resIndex")
	private Reservation reservation;
	
	@NonNull
	@Column(name = "score")
	private Double score;
	
	@NonNull
	@Column(name = "context")
	private String context;
	
	@NonNull
	@Column(name = "date")
	private LocalDateTime date;

}
