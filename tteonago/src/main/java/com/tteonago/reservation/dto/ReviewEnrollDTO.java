package com.tteonago.reservation.dto;

import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//리뷰 등록 DTO
@Data
@NoArgsConstructor
public class ReviewEnrollDTO {

    private Reservation reservation;
    @NotNull(message="별점을 입력하지 않았습니다.")
    private Double score;

    @NotBlank(message="리뷰 내용을 입력하세요.")
    private String context;

    public Review toEntity() {
        Review entity = Review.builder()
                .reservation(reservation)
                .score(score)
                .context(context)
                .build();

        return entity;

    }

}
