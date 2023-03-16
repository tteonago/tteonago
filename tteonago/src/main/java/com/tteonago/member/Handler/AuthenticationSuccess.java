package com.tteonago.member.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.tteonago.member.repository.MemberRepository;
import com.tteonago.member.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

/*
 * spring security 로그인 성공시 행동입니다
 */
@Component
@RequiredArgsConstructor
public class AuthenticationSuccess implements AuthenticationSuccessHandler {
	private final MemberRepository memberRepository;
	@Value("${jwt.token.secret}")
	private String SecretKey;
	private Long expireTimeMs = 1000 * 30l;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String token = JwtTokenUtil.createToken(authentication.getName(), SecretKey, expireTimeMs);

		Cookie cookie = new Cookie("token", token);
		cookie.setPath("/");
		cookie.setMaxAge(30);
		response.addCookie(cookie);

		response.sendRedirect("/home");
	}
}
