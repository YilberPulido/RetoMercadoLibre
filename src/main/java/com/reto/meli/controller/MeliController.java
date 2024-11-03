package com.reto.meli.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reto.meli.domain.dto.ProcessIpRequest;
import com.reto.meli.domain.dto.RespuestaServicio;
import com.reto.meli.services.impl.MeliServices;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/v1/meli")
public class MeliController {
	
	@Autowired
	private MeliServices meliServices;
	
	private static final Logger LOGGER = LogManager.getLogger(MeliController.class);

	
	@Operation(summary = "Procesa una ip obteniendo datos de esta y guardandolos en la DB") 
	@PostMapping("/trace/ip")
	public @ResponseBody RespuestaServicio gestionarIp(@RequestBody ProcessIpRequest request) throws Exception{
		try {
			LOGGER.info(request.toString());
			return meliServices.gestionarIp(request);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			throw new Exception("Falla en la gestion de la ip: " +request.getIp()+" >>> "+e.getMessage());
		}
	}
	
	@Operation(summary = "Retorna estadisticas de los datos obtenidos de las IP") 
	@GetMapping("/querystats")
	public @ResponseBody RespuestaServicio getStats () throws Exception {
		try {
			return meliServices.queryStats();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new Exception("Falla en la consulta de stats >>> "+e.getMessage());
		}
	}
	
	
}
