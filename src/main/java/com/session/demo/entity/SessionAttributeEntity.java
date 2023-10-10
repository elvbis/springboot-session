package com.session.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEMO_SESSION_ATTRIBUTES")
@Getter
@Setter
@IdClass(SessionAttributeId.class)
public class SessionAttributeEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 900713309893323153L;
	
	@Id
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@Id
	@Column(name = "ATTRIBUTE_NAME")
	private String attributeName;
	
	@Column(name = "ATTRIBUTE_VALUE")
	private String attributeValue;
	
}
