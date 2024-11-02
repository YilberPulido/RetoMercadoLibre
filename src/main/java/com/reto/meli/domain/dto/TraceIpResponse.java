package com.reto.meli.domain.dto;

import java.io.Serializable;

public class TraceIpResponse implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9187489361754820675L;
	
	private String ip;
	private String fechaActual;
	private String pais;
	private String isoCode;
	private String moneda;
	private String idiomas;
	private String hora;
	private String distancia;
	
	

	public TraceIpResponse() {
			
	}



	public TraceIpResponse(String ip, String fechaActual, String pais, String isoCode, String moneda, String idiomas,
			String hora, String distancia) {
		super();
		this.ip = ip;
		this.fechaActual = fechaActual;
		this.pais = pais;
		this.isoCode = isoCode;
		this.moneda = moneda;
		this.idiomas = idiomas;
		this.hora = hora;
		this.distancia = distancia;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getFechaActual() {
		return fechaActual;
	}



	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getIsoCode() {
		return isoCode;
	}



	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public String getIdiomas() {
		return idiomas;
	}



	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getDistancia() {
		return distancia;
	}



	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	
	

}
