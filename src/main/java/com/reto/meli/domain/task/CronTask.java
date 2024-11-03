package com.reto.meli.domain.task;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.reto.meli.domain.cache.CacheMeli;
import com.reto.meli.infraestructure.model.Iptrace;
import com.reto.meli.infraestructure.repository.IpTraceRepository;

@Component
public class CronTask {
	
	private IpTraceRepository ipTraceRepository;
	
	private CacheMeli cacheMeli;
	
	@Value("${cron.timer}")
	private String timer;
	
	@Autowired
	public CronTask(IpTraceRepository ipTraceRepository, CacheMeli cacheMeli) {
		this.ipTraceRepository = ipTraceRepository;
		this.cacheMeli = cacheMeli;
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    TaskScheduler scheduler = new ThreadPoolTaskScheduler();
	    return scheduler;
	}
	
	
	@Scheduled(cron = "${cron.timer}")
	public void timedTask() throws Exception {
		updateCache();
	}
	
	public void updateCache()  throws IOException, ClassNotFoundException{
		
		List<Iptrace> result = ipTraceRepository.findAll();
		cacheMeli.updateCache(result);
		
	}

}
