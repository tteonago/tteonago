package com.tteonago.reservation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//리뷰 등록 DTO
@NoArgsConstructor

@Setter
@Getter
@ToString
public class ReviewEnrollDTO {
    private int resIndex;
    
    @NotNull(message="별점을 입력하지 않았습니다.")
    private Double score;

    @NotBlank(message="리뷰 내용을 입력하세요.")
    private String context;

    public Review toEntity(Reservation reservation) {
        Review entity = Review.builder()
                .reservation(reservation)
                .score(score)
                .context(context)
                .build();

        return entity;
    }
}
