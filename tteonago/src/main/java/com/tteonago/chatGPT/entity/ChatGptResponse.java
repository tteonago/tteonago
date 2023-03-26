package com.tteonago.chatGPT.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ChatGptResponse implements Serializable{
	private String id;
	private String object;
	private LocalDate created;
	private String model;
	private List<Choice> choices; 
}
