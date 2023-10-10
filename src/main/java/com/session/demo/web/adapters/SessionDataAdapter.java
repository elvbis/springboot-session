package com.session.demo.web.adapters;

import com.session.demo.common.web.GenericOOBBResponse;
import org.springframework.stereotype.Component;

import com.session.demo.common.util.Util;


@Component
public class SessionDataAdapter {
	
	public GenericOOBBResponse createData(Object obj) {

		GenericOOBBResponse response = new GenericOOBBResponse();

		response.setSuccess(true);
		response.setData(obj);
		response.setLastUpdate(Util.generateDate());
		return response;
	}

}
