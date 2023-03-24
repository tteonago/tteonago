package com.tteonago.reservation.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
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

	@Builder
	public Review(Reservation reservation,Double score,String context){
		this.reservation = reservation;
		this.score = score;
		this.context = context;
		this.date = LocalDateTime.now();
	}
}