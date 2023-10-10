package com.session.demo.common.exceptions;

public class ServerErrorException extends GenericBusinessException{

	private static final long serialVersionUID = 1L;

	public ServerErrorException(ExceptionErrorDetail exceptionErrorDetail) {
		super(exceptionErrorDetail);

	}
}
