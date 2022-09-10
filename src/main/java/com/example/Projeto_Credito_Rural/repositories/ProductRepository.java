package com.example.Projeto_Credito_Rural.repositories;

import com.example.Projeto_Credito_Rural.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
