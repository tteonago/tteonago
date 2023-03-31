package com.tteonago.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
public class AdminDTO {
	private String userName;
	
	private String passWord;
}