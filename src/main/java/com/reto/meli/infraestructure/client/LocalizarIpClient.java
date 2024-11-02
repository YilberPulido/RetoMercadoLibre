package com.reto.meli.infraestructure.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reto.meli.domain.dto.IpLocationData;



@FeignClient(name = "ipapi", url = "${localizarip.url}")
public interface LocalizarIpClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/{ip}?access_key={apikey}")
	public @ResponseBody IpLocationData locateIp(@PathVariable("ip") String ip,@PathVariable("apikey") String apikey ) throws Exception;

	
}
