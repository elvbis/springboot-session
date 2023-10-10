package com.session.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEMO_SESSION")
@Getter
@Setter
public class SessionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 900713309893323153L;
	
	@Id
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@Column(name = "CREATION_TIME")
	private Long creationTime;
	
	@Column(name = "LAST_ACCESS_TIME")
	private Long lastAccesTime;
	
	@Column(name = "MAX_INACTIVE_INTERVAL")
	private Long maxInactiveInterval;
	
	@Column(name = "PRINCIPAL_NAME")
	private String principalName;
	

}
