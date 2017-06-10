package com.trainingcenter.projectee.services.exceptions;

public class ExceptionService extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionService(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionService(Throwable cause) {
		super(cause);
	}
	
	public ExceptionService(String message) {
		super(message);
	}

}
