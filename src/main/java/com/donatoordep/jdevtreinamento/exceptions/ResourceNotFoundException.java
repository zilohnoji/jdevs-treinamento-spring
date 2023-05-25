package com.donatoordep.jdevtreinamento.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final String ERROR = "Error: Resource not found";
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(ERROR);
	}
}
