package com.tteonago.reservation.dto;

import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//리뷰 등록 DTO
@Data
@NoArgsConstructor
public class ReviewEnrollDTO {
    private Long id;
    @NotNull
    private Reservation reservation;

    @NotNull(message="별점을 입력하지 않았습니다.")
    private Double score;

    @NotBlank(message="리뷰 내용을 입력하세요.")
    private String context;

    @Builder
    public ReviewEnrollDTO(Double score, String context){
        this.score = score;
        this.context = context;
    }

    public Review toEntity(ReviewEnrollDTO dto) {
        Review entity = Review.builder()
                .reservation(dto.reservation)
                .score(dto.score)
                .context(dto.context)
                .build();

        return entity;
    }

    public ReviewEnrollDTO of(Review entity) {
        ReviewEnrollDTO dto = ReviewEnrollDTO.builder()
                .score(entity.getScore())
                .context(entity.getContext())
                .build();

        return dto;
    }
}
