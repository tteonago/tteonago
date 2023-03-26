package com.tteonago.reservation.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Embeddable

@Setter
@Getter

@ToString
public class Period { // 03/24 LocalDateTime -> LocalDate 타입으로 변경
	@NonNull
	@Column(name = "checkIn")
	private LocalDate checkIn;
	
	@NonNull
	@Column(name = "checkOut")
	private LocalDate checkOut;
	
	protected Period(){

    	}

    	public Period(LocalDate checkIn,LocalDate checkOut){
        	this.checkIn = checkIn;
        	this.checkOut = checkOut;
    	}
}
