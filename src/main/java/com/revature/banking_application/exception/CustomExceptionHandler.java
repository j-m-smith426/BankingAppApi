package com.revature.banking_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value = IllegalUserCredentials.class)
	public ResponseEntity<ErrorResponse> handler1(IllegalUserCredentials illegalUserCredentials){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = illegalUserCredentials.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
	
	@ExceptionHandler(value = InvalidAccountException.class)
	public ResponseEntity<ErrorResponse> handler1(InvalidAccountException invalidAccountException){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = invalidAccountException.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
	
	@ExceptionHandler(value = InvalidCustomer.class)
	public ResponseEntity<ErrorResponse> handler1(InvalidCustomer invalidCustomer){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = invalidCustomer.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
	
	@ExceptionHandler(value = InvalidTransaction.class)
	public ResponseEntity<ErrorResponse> handler1(InvalidTransaction invalidCustomer){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = invalidCustomer.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
}
