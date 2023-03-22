package com.tteonago.reservation.dto;

import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import lombok.*;

import java.time.LocalDateTime;
//리뷰 조회 DTO
@Getter
public class ReviewDTO {

    private Reservation reservation;

    private Double score;

    private String context;

    private LocalDateTime date;

    @Builder
    public ReviewDTO(Reservation reservation,Double score,String context,LocalDateTime date){
        this.reservation = reservation;
        this.score = score;
        this.context = context;
        this.date = date;
    }

    public ReviewDTO(Review entity) {
        this.reservation = entity.getReservation();
        this.score = entity.getScore();
        this.context = entity.getContext();
        this.date = entity.getDate();
    }
}
