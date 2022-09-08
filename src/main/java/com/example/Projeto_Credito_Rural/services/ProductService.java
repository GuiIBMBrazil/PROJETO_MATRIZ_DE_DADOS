package com.example.Projeto_Credito_Rural.services;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    //CONSULTAR TODOS OS PRODUCTS
    public Page<Product> getProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);

        return products;
    }

    //CONSULTA POR ID

    public Optional<ProductDTO> getById(Integer id){
        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty()){
            return null;
        }
        return Optional.of(new ProductDTO(product.get()));
    }
}
