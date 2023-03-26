package com.tteonago.member.entity;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialDTO extends User implements OAuth2User{
	private String userName;
	private String password;
	private String role;
	private String email;
	
	private Map<String, Object> props;
	
	public SocialDTO(String username, String password, String role, String email,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.userName = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.getProps();
	}

	@Override
	public String getName() {
		return this.userName;
	}
}
