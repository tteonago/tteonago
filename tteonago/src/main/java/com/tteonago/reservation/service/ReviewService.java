package com.tteonago.reservation.service;

import com.tteonago.exception.TteonagoException;
import com.tteonago.hotel.entity.Room;
import com.tteonago.hotel.repository.RoomRepository;
import com.tteonago.member.entity.Member;
import com.tteonago.member.exception.AppException;
import com.tteonago.member.repository.MemberRepository;
import com.tteonago.reservation.dto.ReviewDTO;
import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import com.tteonago.reservation.repository.ReservationRepository;
import com.tteonago.reservation.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    //리뷰 등록
    public int reviewing(ReviewEnrollDTO reviewEnrollDTO,int resIndex) {
        Reservation reservation = reservationRepository.findById(resIndex)
                .orElseThrow(EntityNotFoundException::new);
        Review review = reviewRepository.save(reviewEnrollDTO.toEntity(reservation));

        return review.getRevIndex();
    }

    //roomId에 따른 리뷰 조회
    @Transactional(readOnly = true)
    public List<ReviewDTO> getReviewByRoom(String roomId) throws TteonagoException{
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()->new TteonagoException("Room not found"));

        List<Reservation> reservations = reservationRepository.findReservationByRoom(room);
        List<ReviewDTO> reviews = new ArrayList<>();

        for (Reservation reserv : reservations ){
            Review rev = reviewRepository.findReviewByReservation(reserv);
            reviews.add(new ReviewDTO(rev));
        }
        return reviews;
    }
    public List<Integer> findReviewByResIndex(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow((AppException::new));

        List<Integer> resIndex = reviewRepository.findResIndexByUsername(member);

        for(Integer i : resIndex) {
            System.out.println(i);
        }

        return resIndex;
    }

}
