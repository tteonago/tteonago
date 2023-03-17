package com.tteonago.member.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailure implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        String errorMessage;
        if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException){
            errorMessage="아이디 또는 비밀번호가 맞지 않습니다.";
        }else if (e instanceof UsernameNotFoundException){
            errorMessage="존재하지 않는 아이디 입니다.";
        }
        else{
            errorMessage="알 수 없는 이유가 발생했습니다. 관리자에게 문의하세요.";
        }
        httpServletRequest.setAttribute("error", errorMessage);
        httpServletRequest.getRequestDispatcher("/failure").forward(httpServletRequest, httpServletResponse);
    }

}
