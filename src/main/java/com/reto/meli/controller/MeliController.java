package com.reto.meli.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reto.meli.domain.dto.ProcessIpRequest;
import com.reto.meli.domain.dto.RespuestaServicio;
import com.reto.meli.services.impl.MeliServices;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/v1/traceip")
public class MeliController {
	
	@Autowired
	private MeliServices meliServices;
	
	private static final Logger LOGGER = LogManager.getLogger(MeliController.class);

	
	@Operation(summary = "Procesa una ip obteniendo datos de esta y guardandolos en la DB") 
	@PostMapping("/meli/gestion/ip")
	public @ResponseBody RespuestaServicio gestionarIp(@RequestBody ProcessIpRequest request) throws Exception{
		try {
			LOGGER.info(request.toString());
			return meliServices.gestionarIp(request);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			throw new Exception("Falla en la gestion de la ip: " +request.getIp()+" >>> "+e.getMessage());
		}
	}
	
	/*@GetMapping("/historico/evbi/{id}")
	public @ResponseBody PagedResponse<IGraficAlcoholimetro> alcoholimetriaHistoricoByBascula(
			@PathVariable("id") Long id,
	@RequestParam(value = "datestart", defaultValue = AppConstants.DATE_START) String dateStart,
	@RequestParam(value = "dateend", defaultValue = AppConstants.DATE_END) String dateEnd,
	@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
	@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size,
	@RequestParam(value = "filter", defaultValue = AppConstants.DEFAULT_FILTER) String filter) throws Exception {
		try {
			
			return alcoholimetroServices.alcoholimetriaHistoric(id, dateStart, dateEnd,size,page,filter);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new PagedResponse<IGraficAlcoholimetro>(null,0,0,0,0,false);
		}
	}*/
	
	
}
