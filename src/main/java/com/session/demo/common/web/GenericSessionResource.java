package com.session.demo.common.web;

import java.util.ArrayList;
import java.util.List;

import com.session.demo.common.exceptions.ExceptionErrorDetail;
import com.session.demo.common.web.beans.ErrorInfo;
import org.springframework.web.bind.MissingRequestHeaderException;

import com.session.demo.common.exceptions.ExceptionDetail;
import com.session.demo.common.util.Util;

public class GenericSessionResource {

	protected final GenericOOBBResponse buildUnsuccessfulResponseWithExceptionDetail(ExceptionDetail exceptionDetail) {
		GenericOOBBResponse genericResponse = new GenericOOBBResponse();
		genericResponse.addError(exceptionDetail.getKey(), exceptionDetail.getDescription());
		genericResponse.setLastUpdate(Util.generateDate());
		genericResponse.setSuccess(false);
		return genericResponse;
	}

	protected final GenericOOBBResponse buildUnsuccessfulResponseWithExceptionDetail1(
			ExceptionErrorDetail exceptionErrorDetail) {
		GenericOOBBResponse genericResponse = new GenericOOBBResponse();
		genericResponse.setError(exceptionErrorDetail.getError());
		genericResponse.setLastUpdate(Util.generateDate());
		genericResponse.setSuccess(false);
		return genericResponse;
	}

	protected final GenericOOBBResponse buildUnsuccessfulResponseWithExceptionGeneral(Exception exceptionErrorDetail) {
		GenericOOBBResponse genericResponse = new GenericOOBBResponse();
		List<ErrorInfo> errores = new ArrayList<>();
		ErrorInfo error = new ErrorInfo();
		error.setCode("SIS001");
		error.setDescription("System Generic Exception.");
		errores.add(error);
		genericResponse.setError(errores);
		genericResponse.setLastUpdate(Util.generateDate());
		genericResponse.setSuccess(false);
		return genericResponse;
	}

	protected final GenericOOBBResponse buildUnsuccessfulResponseWithExceptionHeader(
			MissingRequestHeaderException exceptionErrorDetail) {
		GenericOOBBResponse genericResponse = new GenericOOBBResponse();
		List<ErrorInfo> errores = new ArrayList<>();
		ErrorInfo error = new ErrorInfo();
		error.setCode("1");
		error.setDescription(exceptionErrorDetail.getMessage());
		errores.add(error);
		genericResponse.setError(errores);
		genericResponse.setLastUpdate(Util.generateDate());
		genericResponse.setSuccess(false);
		return genericResponse;
	}

	

}
