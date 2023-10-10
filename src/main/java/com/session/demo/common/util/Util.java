package com.session.demo.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Util {
	private static final Logger LOGGER = Logger.getLogger(Util.class);
	
	
	public static String generateDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String strDate = formatter.format(date);

		return strDate;
	}
	
	public static void getElapsedTime(long startTime, long endTime) {
		long elapsedTime = (endTime - startTime)/100000;
		LOGGER.info("Tiempo de respuesta " + elapsedTime + " ms");
	}

}
