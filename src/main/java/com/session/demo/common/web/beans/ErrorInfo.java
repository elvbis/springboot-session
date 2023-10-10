package com.session.demo.common.web.beans;

import java.io.Serializable;



public class ErrorInfo implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3262153129318428030L;
	
	private String code;
	private String description;

	public ErrorInfo() {

	}

	@Override
	public ErrorInfo clone() throws CloneNotSupportedException {
		return (ErrorInfo) super.clone();
	}

	public ErrorInfo(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorInfo [code=");
		builder.append(code);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
