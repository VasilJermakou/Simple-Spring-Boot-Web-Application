package com.vaer.springboot.thymeleafdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	/** this handler action when type incorrect value in browser*/
	@ExceptionHandler
	ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
		
		/** create response object*/
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		/** set response info*/
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		/** return response entity*/
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/** this handler action any other conditions*/
	@ExceptionHandler
	ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
		
		/** create response object*/
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		/** set response info*/
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		/** return response entity*/
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
