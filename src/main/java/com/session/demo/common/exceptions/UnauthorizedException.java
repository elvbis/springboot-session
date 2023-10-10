package com.session.demo.common.exceptions;

public class UnauthorizedException extends GenericErrorException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(ExceptionErrorDetail exceptionErrorDetail) {
		super(exceptionErrorDetail);

	}
}
