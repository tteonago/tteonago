package com.tteonago.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
/*
 * 인터셉터가 무슨 행동을 할지 지시합니다.
 */
@Component
public class Interceptor implements HandlerInterceptor {
	//진입 직전 행동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookie = request.getCookies();
		
		if(cookie == null) {
			return true;
		}
		
		for(Cookie c : cookie) {
			if(c.getName().equals("token")) {
				return true;
			}
		}
		
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return true;
	}
}
