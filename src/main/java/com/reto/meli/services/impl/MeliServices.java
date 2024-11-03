package com.reto.meli.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.meli.domain.dto.CountryData;
import com.reto.meli.domain.dto.CurrencyData;
import com.reto.meli.domain.dto.IpLocationData;
import com.reto.meli.domain.dto.Language;
import com.reto.meli.domain.dto.ProcessIpRequest;
import com.reto.meli.domain.dto.RespuestaServicio;
import com.reto.meli.domain.dto.StatsDTO;
import com.reto.meli.domain.dto.TraceIpResponse;
import com.reto.meli.domain.helper.HelperApis;
import com.reto.meli.domain.helper.HelperUtils;
import com.reto.meli.infraestructure.model.Iptrace;
import com.reto.meli.infraestructure.repository.IpTraceRepository;
import com.reto.meli.services.IMeliServices;

@Service
public class MeliServices implements IMeliServices {
	
	@Autowired
	private HelperApis helperApis;
	
	@Autowired
	private HelperUtils helperUtils;
	
	@Autowired
	private IpTraceRepository ipTraceRepository;
	
	
	private static final Logger LOGGER = LogManager.getLogger(MeliServices.class);

	@Override
	public RespuestaServicio gestionarIp(ProcessIpRequest request) throws Exception {
		
		//Se consume api externa para obtener informacion de la ip recibida
		IpLocationData responseLocateIp  = helperApis.traceIp(request.getIp());
		
		
		//Validamos que el resultado sea el esperado
		if(responseLocateIp.getSuccess() != null) {
			return new RespuestaServicio("IP01", false, "Wrong IP or it is not trackable.");
		}
		String pais = responseLocateIp.getCountry_name();
		
		Iptrace trace =  ipTraceRepository.findTraceByCountry(pais);
			
		//Se recorre la lista de idiomas para crear un texto
		List<Language> lenguajes = responseLocateIp.getLocation().getLanguages();
		
		String idiomas = "";
		for(Language l : lenguajes) {
			idiomas = idiomas + l.getName()+" ("+l.getCode()+") ,";
		}
		idiomas = idiomas.substring(0, idiomas.length()-2);
		
		//Se obtiene informacion del pais al que corresponde la ip
		CountryData countryData = helperApis.infoCountry(request.getIp());
			
		//Consume api externa para saber el valor en dolares de la moneda obtenida
		CurrencyData currencyData =  helperApis.currencyExUSD(countryData.getCurrency());
		
		//Obtener la hora segun la zona horaria
		String hora = helperUtils.getCurrentTimeInZone(countryData.getTimezone());

		//obtengo la distancia entre Buenos aires y las coordenadas obtenidas
		Double dist = helperUtils.distanceToBuenosAires(responseLocateIp.getLatitude(), responseLocateIp.getLongitude());
		
		//Se redondea la distancia a solo dos decimales
		dist = Math.round(dist * 100.0) / 100.0;
		
		String distancia = dist+" Km desde buenos aires";
		
		String fechaActual = helperUtils.getCurrentTime();
		
		String moneda = countryData.getCurrency() + " (1 "+countryData.getCurrency()+" = "
				+currencyData.getConversion_rate()+" $US) ";
			
		//Se crea objeto de respuesta
		TraceIpResponse response = new TraceIpResponse();
		
		response.setIp(request.getIp());
		response.setIdiomas(idiomas);
		response.setPais(responseLocateIp.getCountry_name());
		response.setIsoCode(responseLocateIp.getCountry_code());
		response.setDistancia(distancia);
		response.setHora(hora);
		response.setFechaActual(fechaActual);
		response.setMoneda(moneda);
		
		if(trace!=null) {
			trace.setInvocaciones(trace.getInvocaciones()+1);
		}
		else {
			trace = new Iptrace();
			trace.setDistancia(dist);
			trace.setInvocaciones(1);
			trace.setPais(response.getPais());
		}
		
		ipTraceRepository.save(trace);
		
		return new RespuestaServicio("0000", response, "EXITO");
	}

	@Override
	public RespuestaServicio queryStats() throws Exception {
		StatsDTO response = helperUtils.getStats();
		
		if (response == null) {
			return new RespuestaServicio("QS01", false, "DATA NO FOUND");
		}
		
		return new RespuestaServicio("0000", response, "EXITO");
	}

	
	
}
