package com.tteonago.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TteonagoException extends Exception {
	public TteonagoException(String msg) {
		super(msg);
	}
}
