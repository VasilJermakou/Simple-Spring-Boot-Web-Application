package com.vaer.springboot.thymeleafdemo.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	/* class fields */
	private static final long serialVersionUID = 1L;
	
	/* constructors */
	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
