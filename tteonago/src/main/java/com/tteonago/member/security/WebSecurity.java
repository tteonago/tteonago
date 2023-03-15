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
			.sessionManagement()
			//.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::changeSessionId)
//			.sessionFixation().none()
			.maximumSessions(1) //최대 세션 제한
			.maxSessionsPreventsLogin(false) //true: 나중에 접속한 유저 로그인 방지  / false: 먼저 접속한 유저 로그아웃
    		.sessionRegistry(sessionRegistry())
    		.expiredUrl("/loginWarning_S.html");
		    //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);   //jwt 사용하는 경우
    	
        httpSecurity
        		.csrf().disable()
        		.cors().disable()
                .authorizeRequests()
                //.antMatchers("/hello").hasRole("USER")
                .antMatchers("/index_S.html").permitAll()
                .antMatchers("/login_S.html").permitAll()
                .antMatchers("/header_S.html").permitAll()
                .antMatchers("/loginWarning_S.html").permitAll()
                .antMatchers("/checkSocial_S.html").permitAll()
                .antMatchers("/showMe_S.jsp").permitAll()
                .antMatchers("/getToken").permitAll()
                .antMatchers("/join").permitAll()
                .antMatchers("/getTokenName").permitAll()
                .antMatchers("/hello").permitAll()
                .antMatchers("/getName").permitAll()
                .antMatchers("/showMe").permitAll()
                .antMatchers("/showkakao").permitAll()
                .antMatchers("/kakaologout").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers(HttpMethod.GET, "/valid").authenticated()
                .anyRequest().authenticated()
              .and()
                .formLogin()
                .loginPage("/login_S.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/loginChain")	
                //.defaultSuccessUrl("/hello")
                .successHandler(authenticationSuccess)
              .and()
              	.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index_S.html")
                .invalidateHttpSession(true)
                //.deleteCookies("JSESSIONID")
                .deleteCookies("token");
//			  .and()
//                .build();
        
        httpSecurity.oauth2Login()
        		.loginPage("/login_S.html")
        		.successHandler(authenticationSocialSuccess);
        
        return httpSecurity.build();
    }
    
 // logout 후 login할 때 정상동작을 위함
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
