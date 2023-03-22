package com.tteonago.reservation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.tteonago.hotel.entity.Room;
import com.tteonago.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@ToString
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resIndex")
	private Integer resIndex;
	
	@NonNull
	@OneToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="username")
	private Member member;
	
	@Embedded 
	private Period period;
	
	@NonNull
	@Column(name = "payDate")
	private LocalDateTime payDate;
	
	@NonNull
	@Column(name = "totPrice")
	private Integer totPrice;
}
