package com.tteonago.chatGPT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {

	@GetMapping("/faq")
	public String sendMessage() {
		return "pages/faq";
	}
}
