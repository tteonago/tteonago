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
	
	//로그인  no usage??? -> successHandler 에서 잡아주는것 같음 -> 이 코드는 확인이 필요합니다. 반드시 확인요청 해주세요
//	public String login(String userName, String password) {
//		//없는 아이디 입력
//		Member selectedUser = memberRepository.findByUsername(userName)
//				.orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + " 은/는 존재하지 않는 ID 입니다."));
//		//틀린 비밀번호 입력
//		if(!passwordEncoder.matches(password, selectedUser.getPassword())) {
//			throw new AppException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀렸습니다.");
//		}
//		//정상 로그인시 토큰 발행
//		String token = JwtTokenUtil.createToken(selectedUser.getUsername(), SecretKey, expireTimeMs);
//		
//		return token;
//	}
}
