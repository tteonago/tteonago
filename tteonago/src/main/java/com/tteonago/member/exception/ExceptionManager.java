package com.tteonago.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
	@ExceptionHandler(AppException.class)
	public ResponseEntity<?> AppExceptionHandler(AppException ae) {
		
		return ResponseEntity.status(ae.getErrorCode().getHttpStatus())
				.body(ae.getErrorCode().name() + " " + ae.getMessage() + "AppException exception handlder 발생");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeExceptionHandler(RuntimeException re) {
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(re.getMessage());
	}
}
