package com.reto.meli.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.meli.domain.dto.IpLocationData;
import com.reto.meli.domain.dto.ProcessIpRequest;
import com.reto.meli.domain.dto.RespuestaServicio;
import com.reto.meli.domain.helper.HelperApis;
import com.reto.meli.services.IMeliServices;

@Service
public class MeliServices implements IMeliServices {
	
	@Autowired
	private HelperApis helperApis;
	
	
	private static final Logger LOGGER = LogManager.getLogger(MeliServices.class);

	@Override
	public RespuestaServicio gestionarIp(ProcessIpRequest request) throws Exception {
		
		LOGGER.info(request.toString());
		IpLocationData responseLocateIp  = helperApis.localizarIp(request.getIp());
		
		return new RespuestaServicio("0000", responseLocateIp, "EXITO");
	}

}
