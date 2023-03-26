package com.tteonago.chatGPT.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tteonago.chatGPT.entity.BotRequest;
import com.tteonago.chatGPT.entity.ChatGptResponse;
import com.tteonago.chatGPT.service.BotServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ChatRestController {
	private final BotServiceImpl botService;
	
	@PostMapping("/send")
	public ChatGptResponse sendMessage(@RequestParam("message") String message) {
	    BotRequest botRequest = new BotRequest();
	    botRequest.setMessage(message);
	    return botService.askQuestion(botRequest);
	}
}
