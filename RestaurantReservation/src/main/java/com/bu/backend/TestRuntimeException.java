package com.bu.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class TestRuntimeException extends RuntimeException {
	public String message = "TestRuntimeException";
	
	public TestRuntimeException(String message)
	{
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
