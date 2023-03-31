package com.tteonago.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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