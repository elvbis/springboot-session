package com.session.demo.common.exceptions;

import java.util.List;

import com.session.demo.common.web.beans.ErrorInfo;


public class ExceptionImplement implements ExceptionErrorDetail{

	private List<ErrorInfo> error;

	public ExceptionImplement(List<ErrorInfo> error) {
		super();
		this.error = error;
	}

	public List<ErrorInfo> getError() {
		return error;
	}

	public void setError(List<ErrorInfo> error) {
		this.error = error;
	}
	
	@Override
	public String toMessageComplete() {
		// TODO Auto-generated method stub
		return null;
	}
}
