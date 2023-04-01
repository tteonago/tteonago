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
		model.addAttribute("message", "오류");
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
    
    //메소드에 전달된 인수가 잘못되었거나 부적절한 경우에 발생하는 예외
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    public String handleException(Model model) {
        model.addAttribute("message", "잘못된 요청 입니다.");
        return "pages/error";
    }

    //날짜 에러
    @ExceptionHandler({DateTimeParseException.class})
    public String handleDateTimeParseException(Model model) {
        model.addAttribute("message", "잘못된 날짜 데이터입니다.");
        return "pages/error";
    }
    
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException e, Model model) {
        model.addAttribute("message", "필수 요청 파라미터가 누락되었습니다.");
        return "pages/error";
    }
}