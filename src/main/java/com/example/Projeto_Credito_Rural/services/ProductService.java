package com.example.Projeto_Credito_Rural.services;

import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    //CONSULTAR TODOS OS PRODUCTS
    public Page<Product> getProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    //CONSULTAR POR ID
}
