package com.session.demo.web;

import java.util.List;

import com.session.demo.common.web.GenericSessionResource;
import com.session.demo.domain.SessionDataResponse;
import com.session.demo.domain.SessionRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.session.demo.common.util.Util;
import com.session.demo.common.web.GenericOOBBResponse;
import com.session.demo.service.impl.SessionDataServiceImpl;
import com.session.demo.web.adapters.SessionDataAdapter;

@RestController
@RequestMapping(value = "/session")
public class SessionController extends GenericSessionResource {

	@Autowired
	private SessionDataServiceImpl sessionDataService;

	@Autowired
	private SessionDataAdapter sessionDataAdapter;

	private static final Logger LOGGER = Logger.getLogger(SessionController.class);

	@PostMapping("/create-session-data")
	public GenericOOBBResponse createSessionData(@RequestHeader("SESSION") String sessionId,
			@RequestBody SessionRequest request) throws Exception {
		LOGGER.info("Inicia [add Session data]");
		LOGGER.info("Header authorization [" + sessionId + "]");
		long timeStart = System.nanoTime();
		try {
			request.setSessionId(sessionId);
			sessionDataService.createSessionData(request);
			GenericOOBBResponse response = sessionDataAdapter.createData(true);
			LOGGER.info("ResponseBody [" + response.toString() + "]");
			return response;
		} catch (Exception e) {
			LOGGER.error(e);
			return buildUnsuccessfulResponseWithExceptionGeneral(e);
		} finally {
			long timeResponse = System.nanoTime();
			LOGGER.info("Termina [add session data]");
			Util.getElapsedTime(timeStart, timeResponse);
		}

	}
	
	@GetMapping(value = "/get-data")
	public GenericOOBBResponse getSessionData(@RequestHeader("SESSION") String sessionId) throws Exception {
		LOGGER.info("Inicia [get Session data]");
		LOGGER.info("Header authorization [" + sessionId + "]");
//		LOGGER.info("Request Key [" + request + "]");
		long timeStart = System.nanoTime();
		try {
			List<SessionDataResponse> result = sessionDataService.getSessionData(sessionId);
			GenericOOBBResponse response = sessionDataAdapter.createData(result);

			return response;
		} catch (Exception e) {
			LOGGER.error(e);
			return buildUnsuccessfulResponseWithExceptionGeneral(e);
		} finally {
			LOGGER.info("Termina [get session data]");
			long timeResponse = System.nanoTime();
			Util.getElapsedTime(timeStart, timeResponse);
		}

	}

	@PutMapping("/add-session-data")
	public GenericOOBBResponse addSessionData(@RequestHeader("SESSION") String sessionId,
			@RequestBody SessionRequest request) throws Exception {
		LOGGER.info("Inicia [add Session data]");
		LOGGER.info("Header authorization [" + sessionId + "]");
		long timeStart = System.nanoTime();
		try {
			request.setSessionId(sessionId);
			sessionDataService.addSessionData(request);
			GenericOOBBResponse response = sessionDataAdapter.createData(true);
			LOGGER.info("ResponseBody [" + response.toString() + "]");
			return response;
		} catch (Exception e) {
			LOGGER.error(e);
			return buildUnsuccessfulResponseWithExceptionGeneral(e);
		} finally {
			long timeResponse = System.nanoTime();
			LOGGER.info("Termina [add session data]");
			Util.getElapsedTime(timeStart, timeResponse);
		}

	}

	@DeleteMapping("/remove-session-data")
	public GenericOOBBResponse removeSessionDataUser(@RequestHeader("SESSION") String sessionId) throws Exception {
		LOGGER.info("Inicia [Remove Session data]");
		LOGGER.info("Header authorization [" + sessionId + "]");
		long timeStart = System.nanoTime();
		try {
			sessionDataService.removeSessionData(sessionId);

			GenericOOBBResponse response = sessionDataAdapter.createData(true);
			LOGGER.info("ResponseBody [" + response.toString() + "]");
			return response;

		} catch (Exception e) {
			LOGGER.error(e);
			return buildUnsuccessfulResponseWithExceptionGeneral(e);
		} finally {
			long timeResponse = System.nanoTime();
			LOGGER.info("Termina [remove session data]");
			Util.getElapsedTime(timeStart, timeResponse);
		}
	}

}
