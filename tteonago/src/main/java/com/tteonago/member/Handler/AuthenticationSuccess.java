package com.tteonago.member.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.tteonago.member.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

/*
 * spring security 로그인 성공시 행동입니다
 */
@RequiredArgsConstructor
@Component
public class AuthenticationSuccess implements AuthenticationSuccessHandler {
	@Value("${jwt.token.secret}")
	private String secretKey;
	private final Long expireTimeMs = 1000 * 3000L;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String token = JwtTokenUtil.createToken(authentication.getName(), secretKey, expireTimeMs);

		Cookie cookie = new Cookie("token", token);
		cookie.setPath("/");
		cookie.setMaxAge(3000);
		response.addCookie(cookie);
		
		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		if (savedRequest != null) {
			request.getSession().setAttribute("prevPage", savedRequest.getRedirectUrl());
		}

		// 로그인 성공 후 이전 페이지로 Redirect
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		if (prevPage != null) {
			response.sendRedirect(prevPage);
		} else {
			response.sendRedirect("/category"); // 이전 페이지 정보가 없을 경우 기본적으로 설정할 페이지
		}
	}
}
