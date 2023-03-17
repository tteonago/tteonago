package com.tteonago.member.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tteonago.member.Handler.AuthenticationSocialSuccess;
import com.tteonago.member.Handler.AuthenticationSuccess;

import lombok.RequiredArgsConstructor;
/*
 * spring security 의 모든 제어를 관리합니다
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurity {
	private final AuthenticationSuccess authenticationSuccess;
	private final AuthenticationSocialSuccess authenticationSocialSuccess;

	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public SecurityFilterChain configure(final HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
			.sessionManagement()	//세션을 관리합니다
			.maximumSessions(1) //최대 세션 제한
			.maxSessionsPreventsLogin(false) //true: 나중에 접속한 유저 로그인 방지  / false: 먼저 접속한 유저 로그아웃
    		.sessionRegistry(sessionRegistry())
    		.expiredUrl("/loginWarning_S.html");	//세션 제한을 초과한 경우 --이 url 은 수정이 필요합니다. 반드시 확인요청 해주세요
		    //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);   //jwt 사용하는 경우
    	
        httpSecurity
        		.csrf().disable()
        		.cors().disable()
                .authorizeRequests()
                .antMatchers("/header_S.html").permitAll() //security 를 무조건 통과시킵니다
                .antMatchers("/home").permitAll()
                .antMatchers("/mypage").permitAll()
                .antMatchers("/social").permitAll()
                .antMatchers("/show").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/sample").permitAll()
                .antMatchers("/getToken").permitAll()
                .antMatchers("/join").permitAll()
                .antMatchers("/getTokenName").permitAll()
                .antMatchers("/getName").permitAll()
                .antMatchers("/showkakao").permitAll()
                .antMatchers("/kakaologout").permitAll()
                .antMatchers("/map").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers(HttpMethod.GET, "/valid").authenticated()
                .anyRequest().authenticated() //모든 요청을 제어합니다
              .and()
                .formLogin()	//spring security login 을 설정합니다
                .loginPage("/login")	//다음과 같은 로그인 페이지로 이동합니다
                .usernameParameter("username")	//form 태그의 username 파라미터를 명시합니다
                .passwordParameter("password")	//form 태그의 password 파라미터를 명시합니다
                .loginProcessingUrl("/loginChain")	//로그인 form 태그 action 을 명시합니다
                //.defaultSuccessUrl("/hello")
                .successHandler(authenticationSuccess)	//로그인 성공시 다음 행동을 지시합니다
              .and()
              	.logout()		//spring security logout 을 설정합니다
                .logoutUrl("/logout")	//로그아웃 url
                .logoutSuccessUrl("/home")	//로그아웃 성공시 다음으로 이동합니다
                .invalidateHttpSession(true)	//로그아웃시 세션을 종료합니다
                .deleteCookies("token");	//로그아웃시 다음의 토큰을 삭제합니다
        
        httpSecurity.oauth2Login()		//소셜로그인을 설정합니다
        		.loginPage("/login")	//다음과 같은 로그인 페이지로 이동합니다
        		.successHandler(authenticationSocialSuccess);	//소셜로그인 성공시 다음 행동을 지시합니다.
        
        return httpSecurity.build();
    }
    
 // logout 후 login할 때 정상동작을 위함
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
