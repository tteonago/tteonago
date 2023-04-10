package com.tteonago.reservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tteonago.member.entity.Member;
import com.tteonago.member.exception.AppException;
import com.tteonago.member.repository.MemberRepository;
import com.tteonago.reservation.dto.ReviewEnrollDTO;
import com.tteonago.reservation.entity.Reservation;
import com.tteonago.reservation.entity.Review;
import com.tteonago.reservation.repository.ReservationRepository;
import com.tteonago.reservation.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewService {

	private final MemberRepository memberRepository;
	private final ReviewRepository reviewRepository;
	private final ReservationRepository reservationRepository;

	public int reviewing(ReviewEnrollDTO reviewEnrollDTO, int resIndex) {
		Reservation reservation = reservationRepository.findById(resIndex).orElseThrow(EntityNotFoundException::new);
		Review review = reviewRepository.save(reviewEnrollDTO.toEntity(reservation));

		return review.getRevIndex();
	}

	public HashMap<Member, Review> findReviewByHotelId(String hotelId) {
		List<Object[]> context = reviewRepository.findReviewByHotelId(hotelId);

		return context.stream().collect(Collectors.toMap(arr -> (Member) arr[1], arr -> (Review) arr[0],
				(oldValue, newValue) -> oldValue, HashMap::new));
	}

	public List<Integer> findReviewByResIndex(String username) {
		Member member = memberRepository.findByUsername(username).orElseThrow((AppException::new));

		return reviewRepository.findResIndexByUsername(member);
	}
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	   
	}

	public void deleteReviewById(int id) {
		reviewRepository.deleteById(id);
	}

}