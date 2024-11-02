package com.reto.meli.domain.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ProcessIpRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6137829677022833511L;
	
	private String ip;
	
	
	public ProcessIpRequest(String ip) {
		this.ip = ip;
	}



	public ProcessIpRequest() {
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}



	@Override
	public String toString() {
		return "ProcessIpRequest [ip=" + ip + "]";
	}
	
	

}
