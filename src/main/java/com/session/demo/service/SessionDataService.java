package com.session.demo.service;

import java.util.List;

import com.session.demo.domain.SessionDataResponse;
import com.session.demo.domain.SessionRequest;


public interface SessionDataService {
	
	void createSessionData(SessionRequest request) throws Exception;
	List<SessionDataResponse> getSessionData(String sessionId) throws Exception ;
	void addSessionData(SessionRequest request) throws Exception;
	void removeSessionData(String sessionId) throws Exception;

}
