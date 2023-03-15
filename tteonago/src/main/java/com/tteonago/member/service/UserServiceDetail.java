package com.tteonago.member.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Member;
import com.tteonago.member.repository.MemberRepository;

@Service
public class UserServiceDetail implements UserDetailsService {
	@Value("${jwt.token.secret}")
	private String SecretKey;
	private Long expireTimeMs = 1000 * 30l;
	
	private PasswordEncoder passwordEncoder;
	@Autowired
    private MemberRepository merchantRepository;
	
	public UserServiceDetail() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Member userDetails=merchantRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Not Found User")
        );
    	
        return new org.springframework.security.core.userdetails.User(userDetails.getUsername(), userDetails.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(userDetails.getRole())));
    }
}
