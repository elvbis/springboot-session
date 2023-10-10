package com.session.demo.common.web;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.session.demo.common.exceptions.ExceptionDetail;

public enum GenericOOBBExceptionDetail implements ExceptionDetail {

	GENERIC_APPLICATION_ERROR("OOBBR001", "lo sentimos", "Presentamos inconvenientes técnicos. Por favor comunícate con nuestra área de soporte:", "soporteOOBB@santander.com.pe"),
	GENERIC_NOT_FOUND_EXCEPTION("COR002","No se encontro recurso", "No se encontro recurso", "soporte@santander.com.pe"),
	GENERIC_UNAUTHORIZED("COR003", "Acceso no autorizado", "Acceso no autorizado", "soporte@santander.com.pe"),
	GENERIC_FORBIDDEN("COR004","Entrada prohibida", "Entrada prohibida", "soporte@santander.com.pe"),
	GENERIC_TECHNICAL_ERROR_OF_ACCESS_TO_DATABASE("COR005","Error técnico en consulta a Oracle", "Error técnico en consulta a Oracle", "soporte@santander.com.pe"),
	NO_PARAMETRIC_ERROR("OOBBE001","Error OOBBE001", "El monto enviado no puede ser ubicado en ningún rango establecido en la parametrización.", "");
	

	private String key;
	private String title;
	private String message1;
	private String message2;

	private static final Map<String, GenericOOBBExceptionDetail> lookup = new HashMap<String, GenericOOBBExceptionDetail>();

	static {
		for (GenericOOBBExceptionDetail e : EnumSet.allOf(GenericOOBBExceptionDetail.class)){
			lookup.put(e.getKey(), e);
		}
	}

	private GenericOOBBExceptionDetail(String key, String title, String message1, String message2) {
		this.key = key;
		this.title = title;
		this.message1 = message1;
		this.message2 = message2;
	}

	public String getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage1() {
		return message1;
	}

	public String getMessage2() {
		return message2;
	}

	public static GenericOOBBExceptionDetail obtenerById(String codigo) {
		if(lookup.containsKey(codigo))
			return lookup.get(codigo);
		else
			return GenericOOBBExceptionDetail.GENERIC_APPLICATION_ERROR;
	}

	public String getDescription() {
		return message1;
	}

}
