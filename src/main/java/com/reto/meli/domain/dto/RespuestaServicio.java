package com.reto.meli.domain.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class RespuestaServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6732293943395453366L;

	/**
	 * 
	 */

	private String codigoRespuesta = "";
	
	private Object respuesta = null;
	
	private String mensaje = "";

	public RespuestaServicio() {
		
	}

	public RespuestaServicio(String codigoRespuesta, Object respuesta, String mensaje) {
		super();
		this.codigoRespuesta = codigoRespuesta;
		this.respuesta = respuesta;
		this.mensaje = mensaje;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public Object getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Object respuesta) {
		this.respuesta = respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
	
}
