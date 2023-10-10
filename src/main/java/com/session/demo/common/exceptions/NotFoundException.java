package com.session.demo.common.exceptions;

public class NotFoundException extends GenericBusinessException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(ExceptionErrorDetail exceptionErrorDetail) {
		super(exceptionErrorDetail);

	}
}
