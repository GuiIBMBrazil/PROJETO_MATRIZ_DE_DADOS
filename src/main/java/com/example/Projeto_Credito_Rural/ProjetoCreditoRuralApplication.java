package com.example.Projeto_Credito_Rural;

import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
