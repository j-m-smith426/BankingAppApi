package com.revature.banking_application.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	Date date;
	int code;
	String status;
	String message;
	
	public ErrorResponse() {
		this.date = new Date();
	}
	public ErrorResponse(HttpStatus status, String message) {
		this.date = new Date();
		this.code = status.value();
		this.status = status.name();
		this.message = message;
	}
	
	
}
