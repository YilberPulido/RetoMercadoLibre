package com.reto.meli.domain.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.reto.meli.controller.MeliController;
import com.reto.meli.domain.dto.IpLocationData;
import com.reto.meli.infraestructure.client.LocalizarIpClient;

@Component
public class HelperApis {

	
	private LocalizarIpClient localizarIpClient;
	
	@Value("${localizarip.apikey}")
	private String localizaripApikey;
	
	private static final Logger LOGGER = LogManager.getLogger(HelperApis.class);

	@Autowired
	public HelperApis(LocalizarIpClient localizarIpClient) {
		this.localizarIpClient = localizarIpClient;
	}

	public IpLocationData localizarIp(String ip) throws Exception {
		
		LOGGER.info(ip);
		LOGGER.info(localizaripApikey);
		return localizarIpClient.locateIp(ip,localizaripApikey);
	}

}
