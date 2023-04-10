package com.tteonago.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.member.entity.Member;
import com.tteonago.reservation.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	@Modifying
	@Query("delete from Wishlist w where w.member = :member and w.hotel = :hotel")
	public void deleteByHotel(@Param("member") Member member, @Param("hotel") Hotel hotel);
	
	@Query("select w.hotel, w.member, h.address from Wishlist w, HotelImage h where w.hotel=h.hotel and substr(h.address , -5) = '1.jpg' and w.member = :member")
	public List<Object[]> findByMember(@Param("member") Member member);
		
	@Query("select w from Wishlist w where w.member = :member and w.hotel = :hotel")
	public Wishlist findByMemberAndHotel(@Param("member") Member member, @Param("hotel") Hotel hotel);
}
