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

/*
 * 회원가입, 로그인 service 단입니다
 */

@RequiredArgsConstructor
@Service
public class UserService {
	private final MemberRepository memberRepository;
	//private final BCryptPasswordEncoder encoder;
	private final PasswordEncoder passwordEncoder;
	@Value("${jwt.token.secret}")
	private String SecretKey;
	private Long expireTimeMs = 1000 * 30l;

	//회원가입
	public String join(String userName, String password, String name,String email,String role) {
		// 중복 check
		memberRepository.findByUsername(userName).ifPresent(user -> {
			throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + " 은/는 이미 존재하는 ID 입니다.");
		});
		
		//null
		if(userName == null || userName.length() == 0) {
			throw new AppException(ErrorCode.NULL, "정상적인 아이디가 아닙니다.");
		}
		
		// 정상 회원가입시 db저장 --builder 코드는 수정이 필요합니다. 반드시 확인요청하세요
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
	//로그인
	public String login(String userName, String password) {
		//없는 아이디 입력
		Member selectedUser = memberRepository.findByUsername(userName)
				.orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + " 은/는 존재하지 않는 ID 입니다."));
		//틀린 비밀번호 입력
		if(!passwordEncoder.matches(password, selectedUser.getPassword())) {
			throw new AppException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀렸습니다.");
		}
		//정상 로그인시 토큰 발행
		String token = JwtTokenUtil.createToken(selectedUser.getUsername(), SecretKey, expireTimeMs);
		
		return token;
	}
}
