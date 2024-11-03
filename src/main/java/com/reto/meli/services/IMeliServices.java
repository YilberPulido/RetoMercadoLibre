package com.reto.meli.services;

import com.reto.meli.domain.dto.ProcessIpRequest;
import com.reto.meli.domain.dto.RespuestaServicio;

public interface IMeliServices {
	
	
	public RespuestaServicio gestionarIp(ProcessIpRequest ip) throws Exception;
	
	public RespuestaServicio queryStats() throws Exception;

}
