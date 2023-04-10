package com.tteonago.member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor

@Getter
public class AppException extends RuntimeException {
	private ErrorCode errorCode;
	private String message;
}