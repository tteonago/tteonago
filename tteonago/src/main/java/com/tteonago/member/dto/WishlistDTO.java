package com.tteonago.member.dto;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.member.entity.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WishlistDTO {
	private Integer wishindex;
	
    private Hotel hotel;
    
    private Member member;
}