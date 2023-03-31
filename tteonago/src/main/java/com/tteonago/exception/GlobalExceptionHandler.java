package com.tteonago.exception;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TteonagoException.class)
    public String handleTteonagoException(TteonagoException e, Model model) {
        model.addAttribute("message", "잘못된 지역 요청입니다.");
    	return "pages/error";
    }
    
    //메소드에 전달된 인수가 잘못되었거나 부적절한 경우에 발생하는 예외
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", "잘못된 호텔요청 입니다.");
        return "pages/error";
    }
    
    //날짜 에러
    @ExceptionHandler({DateTimeParseException.class})
    public String handleDateTimeParseException(Exception e, Model model) {
        model.addAttribute("message", "잘못된 날짜 데이터입니다.");
        return "pages/error";
    }
    
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException e, Model model) {
        model.addAttribute("message", "필수 요청 파라미터가 누락되었습니다.");
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        return "pages/error";
    }
}