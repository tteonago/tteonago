package com.tteonago.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

	@Query("select w.hotel, w.member, h.address from Wishlist w, HotelImage h where w.hotel=h.hotel and substr(h.address , -5) = '1.jpg' and w.member = :member")
	public List<Object[]> findByMember(@Param("member") Member member);

}
