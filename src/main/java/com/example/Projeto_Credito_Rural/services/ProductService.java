package com.example.Projeto_Credito_Rural.services;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    //CONSULTAR TODOS OS PRODUCTS
    public List<ProductDTO> getProducts(Pageable pageable){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product:products) {
            productDTOS.add(new ProductDTO(product));
        }

        return productDTOS;
    }

    //CONSULTAR POR ID
}
