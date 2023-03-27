package com.tteonago.member.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
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
	private ModelMapper modelMapper = new ModelMapper();
	@Value("${jwt.token.secret}")
	private String SecretKey;
	private Long expireTimeMs = 1000 * 30l;

	//회원가입 insert into member 
	public String join(String userName, String password, String name,String email,String role) {
		// 중복 check
		memberRepository.findByUsername(userName).ifPresent(user -> {
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
	public List<Object[]> getwishtlist(String username) throws AppException{
		Optional<Member> memberOp = memberRepository.findById(username);
		Member member = memberOp.orElseThrow(AppException::new);
		
		List<Object[]> wishlists = wishlistRepository.findByMember(member);
		
	    return wishlists;
	}
	
	//delete from wishlist where username = ? and hotel_id = ?
	@Transactional
	public void deleteByHotelId(String username, String hotelId) throws AppException{
		Member member = memberRepository.findById(username).orElseThrow((AppException::new));
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow((AppException::new));
		
		wishlistRepository.deleteByHotel(member, hotel);
	}
	
	public Member findById(String username) {
		Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Not Found User")
        );
		
		return member;
	}
	
	@Transactional
	public void updateSocialPassword(String username) {
		int check = memberRepository.updateMemberByUsername("ROLE_USER", username);
	}
	
	@Transactional
	public void insertWishlist(String username, String hotelId) {
		Optional<Member> memberOp = memberRepository.findById(username);
		Member member = memberOp.orElseThrow(AppException::new);
		
		Optional<Hotel> hotelOp =  hotelRepository.findById(hotelId);
		Hotel hotel = hotelOp.orElseThrow();
		
		Wishlist exist = wishlistRepository.findByMemberAndHotel(member, hotel);
		
		if(exist == null) {
			Wishlist wishlist = Wishlist.builder()
					.member(member)
					.hotel(hotel)
					.build();
			wishlistRepository.save(wishlist);
			return;
		}else {
			wishlistRepository.deleteByHotel(member, hotel);
		}
	}
	
}
