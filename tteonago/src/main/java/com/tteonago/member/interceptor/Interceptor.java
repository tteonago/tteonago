package com.tteonago.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookie = request.getCookies();
		
		if(cookie == null) {
			return true;
		}
		
		for(Cookie c : cookie) {
			if(c.getName().equals("token")) {
				System.out.println("intercepter 111111: " + SecurityContextHolder.getContext().getAuthentication().getName());
				return true;
			}
		}
		
		System.out.println("intercepter 2222222" );
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return true;
	}
}
