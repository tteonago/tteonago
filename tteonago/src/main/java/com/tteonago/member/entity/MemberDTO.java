package com.tteonago.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MemberDTO {
	
	private String username;

	private String password;

	private String name;

	private String email;
	
	private String role;

	private Integer point;
}
