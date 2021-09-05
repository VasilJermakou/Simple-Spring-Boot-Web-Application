package com.vaer.springboot.thymeleafdemo.exception;

public class EmployeeErrorResponse {
	
	/* class fields */
	private int status;
	private String message;
	private long timeStamp;
	
	/* constructors */
	public EmployeeErrorResponse() {}

	public EmployeeErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	/* object methods */
	@Override
	public String toString() {
		return "EmployeeErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	/* getters and setters */
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
