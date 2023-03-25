package com.tteonago.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		for (Cookie c : cookie) {
	        if (c.getName().equals("JSESSIONID")) { // 삭제하려는 쿠키의 이름을 설정
	            c.setMaxAge(0); // 쿠키 만료 시간을 0으로 설정하여 즉시 삭제
	            c.setPath("/"); // 쿠키 경로 설정
	            response.addCookie(c); // 쿠키 삭제
	            break; // 해당 쿠키를 찾았으므로 더 이상 반복하지 않고 종료
	        }
	    }
		//new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return true;
	}
	
}
