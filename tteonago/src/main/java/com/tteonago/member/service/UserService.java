package com.tteonago.member.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Member;
import com.tteonago.member.exception.AppException;
import com.tteonago.member.exception.ErrorCode;
import com.tteonago.member.repository.MemberRepository;
import com.tteonago.member.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final MemberRepository memberRepository;
//	private final BCryptPasswordEncoder encoder;
	private final PasswordEncoder passwordEncoder;
	@Value("${jwt.token.secret}")
	private String SecretKey;
	private Long expireTimeMs = 1000 * 30l;


	public String join(String userName, String password, String role) {
		System.out.println(userName + " " + password);
		// 중복 check
		memberRepository.findByUsername(userName).ifPresent(user -> {
			throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + " 은/는 이미 존재하는 ID 입니다.");
		});
		
		//null
		if(userName == null || userName.length() == 0) {
			throw new AppException(ErrorCode.NULL, "정상적인 아이디가 아닙니다.");
		}
		
		// 저장
		Member member = Member.builder()
				.username(userName)
				.password(passwordEncoder.encode(password))
				.role(role)
				.name("홍길동")
				.email("test@naver.com")
				.point(0)
				.build();
		memberRepository.save(member);

		return "success";
	}
	
	public String login(String userName, String password) {
		// userName 없음
		Member selectedUser = memberRepository.findByUsername(userName)
				.orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + " 은/는 존재하지 않는 ID 입니다."));
		// password 틀림
		if(!passwordEncoder.matches(password, selectedUser.getPassword())) {
			throw new AppException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀렸습니다.");
		}
		//정상 로그인시 토큰 발행
		String token = JwtTokenUtil.createToken(selectedUser.getUsername(), SecretKey, expireTimeMs);
		
		return token;
	}
}
