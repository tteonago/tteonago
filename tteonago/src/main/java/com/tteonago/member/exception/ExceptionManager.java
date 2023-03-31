package com.tteonago.member.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

 
@Slf4j
@RestControllerAdvice
public class ExceptionManager {
	@ExceptionHandler(AppException.class)
	public ResponseEntity<String> AppExceptionHandler(AppException ae) {
	    String errorMessage = ae.getMessage();
	    String html = "<script>alert('" + errorMessage + "'); history.back();</script>";
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.TEXT_HTML);
	    headers.add("Content-Type", "text/html; charset=UTF-8");
	    return new ResponseEntity<String>(html, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> runtimeExceptionHandler(RuntimeException re) {
    	log.info("---------runtimeExceptionHandler");
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(re.getMessage());
	}
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
    	log.info("---------handleMissingServletRequestParameterException");
        String errorMessage = ex.getParameterName() + " parameter is missing";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }
    
}
