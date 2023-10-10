package com.session.demo.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.session.demo.common.exceptions.IllegalArgumentException;
import com.session.demo.common.exceptions.ServerErrorException;

import com.session.demo.common.exceptions.SessionDataException;
import com.session.demo.common.exceptions.UnauthorizedException;
import com.session.demo.common.exceptions.NotFoundException;
import com.session.demo.common.exceptions.UnprocessableEntity;



public class GenericResources extends GenericSessionResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericResources.class);

	@ExceptionHandler(value = SessionDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public GenericOOBBResponse genericApplicationError(SessionDataException exception) {
		LOGGER.error("Generic Bad Request.", exception);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(exception.getExceptionErrorDetail());
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public GenericOOBBResponse genericApplicationError1(IllegalArgumentException exception) {
		LOGGER.error("Generic Bad Request.", exception);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(exception.getExceptionErrorDetail());
	}

	@ExceptionHandler(value = MissingRequestHeaderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public GenericOOBBResponse genericApplicationError1(MissingRequestHeaderException exception) {
		LOGGER.error("Generic Bad Request.", exception);
		
		System.err.println("aksjdhakjsd");
		return super.buildUnsuccessfulResponseWithExceptionHeader(exception);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GenericOOBBResponse genericApplicationError1(Exception exception) {
		LOGGER.error("Generic Bad Request.", exception);
		return super.buildUnsuccessfulResponseWithExceptionGeneral(exception);
	}
	
	@ExceptionHandler(value = ServerErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GenericOOBBResponse internalServerError(ServerErrorException serverErrorException) {
		LOGGER.error("Uncontrolled Server Error: " + serverErrorException.toString(), serverErrorException);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(serverErrorException.getExceptionErrorDetail());
	}

	@ExceptionHandler(value = NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public GenericOOBBResponse noFoundError(NotFoundException notFoundException) {
		LOGGER.error("Not Found: " + notFoundException.toString(), notFoundException);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(notFoundException.getExceptionErrorDetail());
	}

	@ExceptionHandler(value = UnprocessableEntity.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public GenericOOBBResponse unprocessableEntity(UnprocessableEntity exception) {
		LOGGER.error("Unprocessable Entity: " + exception);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(exception.getExceptionErrorDetail());
	}
	
	@ExceptionHandler(value = UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public GenericOOBBResponse noAuthorizedError(UnauthorizedException authenticationBusinessException) {
		LOGGER.error("Generic No Authorized Error: " + authenticationBusinessException.toString(),
				authenticationBusinessException);
		return super.buildUnsuccessfulResponseWithExceptionDetail1(
				authenticationBusinessException.getExceptionErrorDetail());
	}
	
}
