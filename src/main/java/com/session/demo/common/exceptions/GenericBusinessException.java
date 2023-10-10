package com.session.demo.common.exceptions;

public class GenericBusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private ExceptionErrorDetail exceptionErrorDetail;

	public GenericBusinessException(ExceptionErrorDetail exceptionErrorDetail) {
		super();
		this.exceptionErrorDetail = exceptionErrorDetail;
	}

	public GenericBusinessException(Throwable cause) {
		super(cause);
	}

	public GenericBusinessException(String message, Throwable cause, ExceptionErrorDetail exceptionErrorDetail) {
		this.exceptionErrorDetail = exceptionErrorDetail;
	}

	public GenericBusinessException(String message, ExceptionErrorDetail exceptionErrorDetail) {
		super(message);
		this.exceptionErrorDetail = exceptionErrorDetail;
	}

	public GenericBusinessException(Throwable cause, ExceptionErrorDetail exceptionErrorDetail) {
		super(cause);
		this.exceptionErrorDetail = exceptionErrorDetail;
	}


	public GenericBusinessException(String message) {
		super(message);
	}


	public ExceptionErrorDetail getExceptionErrorDetail() {
		return exceptionErrorDetail;
	}

	public void setExceptionErrorDetail(ExceptionErrorDetail exceptionErrorDetail) {
		this.exceptionErrorDetail = exceptionErrorDetail;
	}
	
	public GenericBusinessException(ExceptionErrorDetail exceptionErrorDetail,  String... values) {
		this.exceptionErrorDetail = this.getCustomDetail(exceptionErrorDetail);
	}
	
	private ExceptionErrorDetail getCustomDetail(ExceptionErrorDetail exErrorDetail) {
		return new ExceptionImplement(exErrorDetail.getError());
	}

}
