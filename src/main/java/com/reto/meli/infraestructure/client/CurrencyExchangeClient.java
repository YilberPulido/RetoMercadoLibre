package com.reto.meli.infraestructure.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reto.meli.domain.dto.CountryData;
import com.reto.meli.domain.dto.CurrencyData;



@FeignClient(name = "currencyEx", url = "${currencyinfo.url}")
public interface CurrencyExchangeClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/{apikey}/pair/{currencyFrom}/{currencyTo}")
	public @ResponseBody CurrencyData exCurrency(@PathVariable("apikey") String apikey,@PathVariable("currencyFrom") String currencyFrom,@PathVariable("currencyTo") String currencyTo) throws Exception;

	
}
