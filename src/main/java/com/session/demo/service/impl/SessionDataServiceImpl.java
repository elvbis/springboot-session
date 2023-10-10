package com.session.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.session.demo.domain.SessionAttributeRequest;
import com.session.demo.domain.SessionDataResponse;
import com.session.demo.domain.SessionRequest;
import com.session.demo.entity.SessionAttributeEntity;
import com.session.demo.entity.SessionEntity;
import com.session.demo.repository.SessionRepository;
import com.session.demo.service.SessionDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.demo.repository.SessionAttributeRepository;

@Service
public class SessionDataServiceImpl implements SessionDataService {

	private static final Logger LOGGER = Logger.getLogger(SessionDataServiceImpl.class);

	@Autowired
	private SessionAttributeRepository sessionAttributeRepository;
	
	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public void createSessionData(SessionRequest request) throws Exception {
		LOGGER.info("Inicia [Registrar session data]");
		
		try {
			
			SessionEntity entity = new SessionEntity();
				entity.setSessionId(request.getSessionId());
				entity.setCreationTime(System.currentTimeMillis());
				entity.setLastAccesTime(System.currentTimeMillis());
				entity.setMaxInactiveInterval(180L);
				sessionRepository.save(entity);

	
			LOGGER.info("Finaliza [Registrar session data]");
		} catch (Exception e) {
			LOGGER.error("No ha podido procesar el registro ");
		}

	}
	
	@Override
	public List<SessionDataResponse> getSessionData(String sessionId) throws Exception {

		LOGGER.info("Inicia [Obtener session data]");
		List<SessionDataResponse> listResponse = new ArrayList<>();
		try {


				List<SessionAttributeEntity> listAttributes = sessionAttributeRepository.findBySessionId(sessionId);
				
				for(SessionAttributeEntity entity : listAttributes) {
					SessionDataResponse response = SessionDataResponse.builder()
							.key(entity.getAttributeName()).value(entity.getAttributeValue()).build();
					listResponse.add(response);
				}

		} catch (Exception e) {
			LOGGER.error("No ha podido obtener el registro ");
		}

		LOGGER.info("Finaliza [Obtener session data]");
		LOGGER.info("Finaliza [Obtener session data]" + listResponse.size());

		return listResponse;
	}

	@Override
	public void addSessionData(SessionRequest request) throws Exception {
		LOGGER.info("Inicia [Registrar session data]");
		
		try {
			
			for (SessionAttributeRequest item: request.getAttributes()) {
				SessionAttributeEntity entity = new SessionAttributeEntity();
				entity.setSessionId(request.getSessionId());
				entity.setAttributeName(item.getKey());
				entity.setAttributeValue(item.getValue());
				sessionAttributeRepository.saveAndFlush(entity);
				
			}
	
			LOGGER.info("Finaliza [Registrar session data]");
		} catch (Exception e) {
			LOGGER.error("No ha podido procesar el registro ");
		}

	}

	@Override
	public void removeSessionData(String sessionId) throws Exception {
		LOGGER.info("Inicia [Delete session data]");

		try {
			sessionRepository.deleteById(sessionId);
			LOGGER.info("Finaliza [Delete session data]");

		} catch (Exception e) {
			LOGGER.error("No ha podido procesar el borrado del registro.");
		}

	}

}
