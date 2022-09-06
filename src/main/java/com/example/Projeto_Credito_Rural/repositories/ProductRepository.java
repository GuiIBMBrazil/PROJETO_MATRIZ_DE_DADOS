package com.example.Projeto_Credito_Rural.repositories;

import com.example.Projeto_Credito_Rural.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
