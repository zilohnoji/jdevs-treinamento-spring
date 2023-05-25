package com.donatoordep.jdevtreinamento.exceptions;

public class IdentificationNullException extends RuntimeException {
	private static final String ERROR = "Error: Identification null";
	private static final long serialVersionUID = 1L;

	public IdentificationNullException() {
		super(ERROR);
	}
}
