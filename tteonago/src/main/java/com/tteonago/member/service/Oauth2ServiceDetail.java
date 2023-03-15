package com.tteonago.member.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.tteonago.member.entity.Member;
import com.tteonago.member.entity.SocialDTO;
import com.tteonago.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Oauth2ServiceDetail extends DefaultOAuth2UserService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		System.out.println("oauth2--------" + userRequest);

		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		String clientName = clientRegistration.getClientName();

		System.out.println("oauth2--------" + clientName);

		OAuth2User oAuth2User = super.loadUser(userRequest);
		Map<String, Object> paramMap = oAuth2User.getAttributes();

		String email = getKakaoEmail(paramMap);

		System.out.println("oauth2--------" + email);
		return generateDTO(email, paramMap);
	}
	
	private SocialDTO generateDTO(String email, Map<String, Object> params) {
		
		Optional<Member> result = memberRepository.findByEmail(email);
		
		if(result.isEmpty()) {
			System.out.println("oauth2 email empty--------------");
			Member member = Member.builder()
					.username(email)
					.password(passwordEncoder.encode("1111"))
					.email(email)
					.role("social")
					.build();
			
			memberRepository.save(member);		
			
			SocialDTO socialDTO = new SocialDTO(email, "1111", "social", email, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
			socialDTO.setProps(params);
			
			return socialDTO;
		}else {
			Member member = result.get();
			
			SocialDTO socialDTO = new SocialDTO(
					member.getUsername(),
					member.getPassword(),
					member.getRole(),
					member.getEmail(),
					Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
			
			return socialDTO;
		}
	}

	private String getKakaoEmail(Map<String, Object> paramMap) {
		Object value = paramMap.get("kakao_account");
		System.out.println("kakaoemail-----" + value);
		LinkedHashMap accountMap = (LinkedHashMap) value;

		String email = (String) accountMap.get("email");

		return email;
	}
}
