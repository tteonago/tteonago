package com.tteonago.member.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.tteonago.member.entity.SocialDTO;

@Component
public class AuthenticationSocialSuccess implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SocialDTO socialDTO = (SocialDTO) authentication.getPrincipal();
		
		String encodedPw = socialDTO.getPassword();
		
		if(socialDTO.getRole().equals("social") && socialDTO.getPassword().equals("1111")) {
			System.out.println(socialDTO.getRole() + " " + socialDTO.getPassword());
			response.sendRedirect("/tteonago/checkSocial_S.html");
		}else {
			response.sendRedirect("/tteonago/index_S.html");
		}
	}
}
