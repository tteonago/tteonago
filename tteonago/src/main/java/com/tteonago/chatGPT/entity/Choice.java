package com.tteonago.chatGPT.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Choice implements Serializable {
	private String text;
	
	private Integer index;	
	
	@JsonProperty("finish_reason")
	private String finishReason;
}
