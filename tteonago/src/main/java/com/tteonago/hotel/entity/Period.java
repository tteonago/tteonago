package com.tteonago.hotel.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
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

@Embeddable
public class Period {
	@NonNull
	@Column(name = "checkIn")
	private LocalDate checkIn;
	
	@NonNull
	@Column(name = "checkOut")
	private LocalDate checkOut;
}
