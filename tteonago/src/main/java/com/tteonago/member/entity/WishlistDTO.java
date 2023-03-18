package com.tteonago.member.entity;

import com.tteonago.hotel.entity.Hotel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class WishlistDTO {
	private Integer wishindex;
    private Hotel hotel;
    private Member member;
}
