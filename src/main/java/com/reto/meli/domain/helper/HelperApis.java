package com.reto.meli.domain.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.reto.meli.domain.dto.CountryData;
import com.reto.meli.domain.dto.CurrencyData;
import com.reto.meli.domain.dto.IpLocationData;
import com.reto.meli.infraestructure.client.CountryInfoClient;
import com.reto.meli.infraestructure.client.CurrencyExchangeClient;
import com.reto.meli.infraestructure.client.LocalizarIpClient;

@Component
public class HelperApis {

	
	private LocalizarIpClient localizarIpClient;
	
	private CountryInfoClient countryInfoClient;
	
	private CurrencyExchangeClient currencyExchangeClient;
	
	@Value("${localizarip.apikey}")
	private String localizaripApikey;
	
	@Value("${currencyinfo.apikey}")
	private String currencyExApikey;
	
	private static final Logger LOGGER = LogManager.getLogger(HelperApis.class);

	@Autowired
	public HelperApis(LocalizarIpClient localizarIpClient, CountryInfoClient countryInfoClient, CurrencyExchangeClient currencyExchangeClient) {
		this.localizarIpClient = localizarIpClient;
		this.countryInfoClient = countryInfoClient;
		this.currencyExchangeClient = currencyExchangeClient;
	}

	public IpLocationData traceIp(String ip) throws Exception {
		return localizarIpClient.locateIp(ip,localizaripApikey);
	}
	
	
	public CountryData infoCountry(String ip) throws Exception {
		return countryInfoClient.getInfoCountry(ip);
	}
	
	public CurrencyData currencyExUSD(String currency) throws Exception {
		return currencyExchangeClient.exCurrency(currencyExApikey, currency, "USD");
	}

}
