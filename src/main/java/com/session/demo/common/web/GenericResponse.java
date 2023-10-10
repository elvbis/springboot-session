package com.session.demo.common.web;

import java.util.ArrayList;
import java.util.List;

import com.session.demo.common.web.beans.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GenericResponse {
	
	private boolean success = true;
	private Object data;
	private List<ErrorInfo> error;
	private String lastUpdate;

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericResponse.class);

	public static List<ErrorInfo> cloneList(List<ErrorInfo> list) {
		List<ErrorInfo> clone = new ArrayList<>();
		if (list != null) {
			clone = new ArrayList<>(list.size());
			for (ErrorInfo item : list) {
				try {
					clone.add(item.clone());
				} catch (CloneNotSupportedException e) {
					LOGGER.info("Fallo el objeto clone " + e);
				}
			}

		}
		return clone;

	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<ErrorInfo> getError() {
		return error;
	}

	public void setError(List<ErrorInfo> error) {
		this.error = error;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void addError(String string, String string2) {
		if (this.error == null) {
			this.error = new ArrayList<>();
		}
		ErrorInfo info = new ErrorInfo();
		info.setCode(string);
		info.setDescription(string2);
		this.error.add(info);
	}

}
