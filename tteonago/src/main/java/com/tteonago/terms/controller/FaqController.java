package com.tteonago.terms.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tteonago.terms.entity.Terms;
import com.tteonago.terms.service.TermsServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class FaqController {

	private final TermsServiceImpl termsService;
	
	@GetMapping("/faq")
	public String sendMessage() {
		return "pages/FAQpage";
	}
	
	@ResponseBody
	@GetMapping("/terms")
	public ResponseEntity<Object> terms() {
		Optional<Terms> terms=termsService.findTermsByLastDate();
		return terms.isPresent()
			? ResponseEntity.ok().body(terms.get())
			: ResponseEntity.badRequest().body("이용 약관이 존재하지 않습니다.");
	}
}
