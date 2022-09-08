package com.example.Projeto_Credito_Rural.controller;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.repositories.ConsumoAPIExterna;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import com.example.Projeto_Credito_Rural.repositories.ProductReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ConsumoAPIExterna consumoAPIExterna;

    @GetMapping
    public ProductReturn getProducts(){
        return consumoAPIExterna.returnProduct();
    }

    @GetMapping("/p")
    public ProductDTO getProduct(){
        return consumoAPIExterna.returnProduct().getValue().get(0);
    }

//    @GetMapping("/insert")
//    public String insertObj(){
//
//        List<ProductDTO> productDTOs = consumoAPIExterna.returnProduct().getValue();
//
//
//        List<Product> products = new ArrayList<>();
//        Product product = new Product();
//
//        for (ProductDTO productDTO:productDTOs) {
//            product = productDTO.create(productDTO);
//            productRepository.save(product);
//        }
//        return "Agora foi!";
//    }
    
}
