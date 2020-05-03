package com.application.aled.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomHandler extends RuntimeException {

	public CustomHandler(String message) {
		super(message);
	}

}
