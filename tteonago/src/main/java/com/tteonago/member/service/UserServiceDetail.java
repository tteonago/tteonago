package com.tteonago.member.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Member;
import com.tteonago.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceDetail implements UserDetailsService {
	
	@Value("${jwt.token.secret}")
	private String secretKey;
	
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Member userDetails = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
    	
    	return new User(
                userDetails.getUsername(),
                userDetails.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userDetails.getRole()))
        );
    }
}
