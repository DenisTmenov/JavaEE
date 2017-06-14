package com.trainingcenter.projectEE.maven.dao.exceptions;

public class ExceptionDao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionDao(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionDao(Throwable cause) {
		super(cause);
	}
	
	public ExceptionDao(String message) {
		super(message);
	}

}
