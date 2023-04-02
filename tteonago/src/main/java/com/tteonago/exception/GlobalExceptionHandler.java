package com.tteonago.exception;

import java.time.format.DateTimeParseException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String DefaultException(Model model) {
		model.addAttribute("message", "알수없는 오류가 발생하였습니다");
		return "pages/error";
	}	
	 
	@ExceptionHandler(DateTimeParseException.class)
	public String handleDateTimeParseException(Model model) {
	     model.addAttribute("message", "유효하지 않은 날짜입니다");
	     return "pages/error";
	}
	
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public String handleException(Model model) {
        model.addAttribute("message", "요청 값이 유효하지 않습니다");
        return "pages/error";
    }
  
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(Model model) {
        model.addAttribute("message", "유효하지 않은 요청 입니다");
        return "pages/error";
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleHttpMessageNotReadableException() {
        return "redirect:/error/404";
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
    public String handleHttpClientBadRequestException() {
        return "redirect:/error/400";
    }


}