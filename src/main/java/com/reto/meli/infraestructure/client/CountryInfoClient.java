package com.reto.meli.infraestructure.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reto.meli.domain.dto.CountryData;



@FeignClient(name = "countryInfo", url = "${infopais.url}")
public interface CountryInfoClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/{ip}/json")
	public @ResponseBody CountryData getInfoCountry(@PathVariable("ip") String ip) throws Exception;

	
}
