package com.tteonago.chatGPT.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@ToString
public class ChatGptRequest implements Serializable {
	private String model;
	
	private String prompt;
	
	@JsonProperty("max_tokens")
	private Integer maxTokens;
	
	private Double temperature;
	
	@JsonProperty("top_p")
	private Double topP;
}
