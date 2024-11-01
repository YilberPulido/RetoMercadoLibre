package com.reto.meli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.reto"})
@EnableFeignClients
@SpringBootApplication
public class MeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);
	}

}
