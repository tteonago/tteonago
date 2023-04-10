package com.tteonago.member.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tteonago.hotel.entity.Hotel;
import com.tteonago.hotel.repository.HotelRepository;
import com.tteonago.member.entity.Member;
import com.tteonago.member.exception.AppException;
import com.tteonago.member.exception.ErrorCode;
import com.tteonago.member.repository.MemberRepository;
import com.tteonago.member.repository.WishlistRepository;
import com.tteonago.reservation.entity.Wishlist;

import lombok.RequiredArgsConstructor;

/*
 * 회원가입, 로그인 service 단입니다
 */
@RequiredArgsConstructor
@Service
public class UserService {
	
	private final MemberRepository memberRepository;
	private final WishlistRepository wishlistRepository;
	private final HotelRepository hotelRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	//회원가입 insert into member 
	public String join(String userName, String password, String name, String email, String role) {
		// 중복 check
		memberRepository.findByUsername(userName)
				.ifPresent(user -> {
					throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + " 은/는 이미 존재하는 ID 입니다.");
				});
		
		//null
		if(userName == null || userName.length() == 0) {
			throw new AppException(ErrorCode.NULL, "정상적인 아이디가 아닙니다.");
		}
		
		// 정상 회원가입시 db저장
		Member member = Member.builder()
				.username(userName)
				.password(passwordEncoder.encode(password))
				.role(role)
				.name(name)
				.email(email)
				.point(0)
				.build();
		
		memberRepository.save(member);

		return "success";
	}
	
	//select * from wishlist where username = ? 
	public List<Object[]> getWishtlist(String username) throws AppException {
		return memberRepository.findById(username)
	            .map(wishlistRepository::findByMember)
	            .orElseThrow(AppException::new);
	}
	
	//delete from wishlist where username = ? and hotel_id = ?
	@Transactional
	public void deleteByHotelId(String username, String hotelId) throws AppException {
		Member member = memberRepository.findById(username).orElseThrow(AppException::new);
	    Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(AppException::new);
	    
		wishlistRepository.deleteByHotel(member, hotel);
	}
	
	public Member findById(String username) {
		return memberRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
	}
	
	@Transactional
	public void updateSocialPassword(String username) {
		memberRepository.updateMemberByUsername("ROLE_USER", username);
	}
	
	@Transactional
    public void insertWishlist(String username, String hotelId) {
        Member member = memberRepository.findById(username).orElseThrow(AppException::new);
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(AppException::new);

        Wishlist exist = wishlistRepository.findByMemberAndHotel(member, hotel);

        if (exist == null) {
            Wishlist wishlist = Wishlist.builder()
                    .member(member)
                    .hotel(hotel)
                    .build();
            wishlistRepository.save(wishlist);
        } else {
            wishlistRepository.deleteByHotel(member, hotel);
        }
    }
	
	public boolean findWishlist(String username, String hotelId) {
		Member member = memberRepository.findById(username).orElseThrow(AppException::new);
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(AppException::new);
		
        Wishlist exist = wishlistRepository.findByMemberAndHotel(member, hotel);
        
        if (exist == null) {
        	return false;
        }else {
        	return true;
        }
	}
}