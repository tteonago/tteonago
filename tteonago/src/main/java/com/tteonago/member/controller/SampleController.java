package com.tteonago.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {

    @GetMapping("/home")
    public String sample() {
        return "pages/index_S";
    }

	@GetMapping("/showMe")
	public String showme() {
		System.out.println("showMe----");
		return "pages/showMe_S";
	}
	
	@GetMapping("/login")
	public String showme1() {
		return "pages/login";
	}
	
	@GetMapping("/social")
	public String social() {
		return "pages/checkSocial_S";
	}
	
    @GetMapping("/valid")
    public String valid() {
    	return "pages/valid_S";
    }
}
