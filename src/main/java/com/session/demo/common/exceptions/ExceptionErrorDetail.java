package com.session.demo.common.exceptions;

import java.util.List;

import com.session.demo.common.web.beans.ErrorInfo;

public interface ExceptionErrorDetail {

	List<ErrorInfo> getError();

	String toMessageComplete();
}
