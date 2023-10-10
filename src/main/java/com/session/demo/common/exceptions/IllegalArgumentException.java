package com.session.demo.common.exceptions;

public class IllegalArgumentException extends GenericErrorException {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentException(ExceptionErrorDetail exceptionErrorDetail) {
		super(exceptionErrorDetail);
	}
}
