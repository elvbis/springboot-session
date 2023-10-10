package com.session.demo.common.exceptions;

public class UnprocessableEntity extends GenericErrorException {

	private static final long serialVersionUID = 1L;
	
	public UnprocessableEntity(ExceptionErrorDetail exceptionErrorDetail) {
		super(exceptionErrorDetail);
	}
}
