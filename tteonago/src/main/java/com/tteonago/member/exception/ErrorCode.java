package com.tteonago.member.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	USERNAME_DUPLICATED(HttpStatus.CONFLICT, ""),
	NULL(HttpStatus.CONFLICT, ""),
	USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, ""),
	INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, ""),
	NO_VALIDATION(HttpStatus.UNAUTHORIZED, "");
	
	private HttpStatus httpStatus;
	
	private String message;
}