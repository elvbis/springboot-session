package com.session.demo.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionAttributeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private String attributeName;
}
