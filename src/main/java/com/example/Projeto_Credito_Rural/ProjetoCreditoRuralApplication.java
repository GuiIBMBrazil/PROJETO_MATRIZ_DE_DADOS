package com.example.Projeto_Credito_Rural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoCreditoRuralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoCreditoRuralApplication.class, args);
	}

}
