package com.example.officialsapplication.exceptions;

public class RequestAlreadyAnsweredException extends RuntimeException {
	private String message;

	public RequestAlreadyAnsweredException(String message) {
		this.message = message;
	}

	public RequestAlreadyAnsweredException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}