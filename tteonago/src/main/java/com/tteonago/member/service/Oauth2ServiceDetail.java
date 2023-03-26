package com.tteonago.member.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
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
/*
 * 카카오 소셜로그인을 제어합니다
 */
@RequiredArgsConstructor
@Service
public class Oauth2ServiceDetail extends DefaultOAuth2UserService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	//카카오 이메일을 기반으로 회원 정보를 카카오에 요청합니다
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		String clientName = clientRegistration.getClientName();

		OAuth2User oAuth2User = super.loadUser(userRequest);
		Map<String, Object> paramMap = oAuth2User.getAttributes();

		String email = getKakaoEmail(paramMap);

		return generateDTO(email, paramMap);
	}
	
	//최초 소셜 로그인인지 아닌지 판별합니다
	private SocialDTO generateDTO(String email, Map<String, Object> params) {
		
		Optional<Member> result = memberRepository.findByEmail(email);
		//최초 소셜 로그인 -- builder 패턴은 수정이 필요합니다. 반드시 확인요청 해주세요.
		if(result.isEmpty()) {
			Member member = Member.builder()
					.username(email)
					.password(passwordEncoder.encode("1111"))
					.name(email)
					.point(0)
					.email(email)
					.role("ROLE_SOCIAL")
					.build();
			
			memberRepository.save(member);		
			
			SocialDTO socialDTO = new SocialDTO(email, "1111", "ROLE_SOCIAL", email, Arrays.asList(new SimpleGrantedAuthority("ROLE_SOCIAL")));
			socialDTO.setProps(params);
			
			return socialDTO;
		//최초 소셜 로그인이 아님	
		}else {
			Member member = result.get();
			List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(member.getRole()));
			
			SocialDTO socialDTO = new SocialDTO(
					member.getUsername(),
					member.getPassword(),
					member.getRole(),
					member.getEmail(),
					authorities);
			
			return socialDTO;
		}
	}
	
	//카카오 소셜 로그인 관련 핵심인 이메일을 요청합니다.
	private String getKakaoEmail(Map<String, Object> paramMap) {
		Object value = paramMap.get("kakao_account");
		LinkedHashMap accountMap = (LinkedHashMap) value;

		String email = (String) accountMap.get("email");

		return email;
	}
}
