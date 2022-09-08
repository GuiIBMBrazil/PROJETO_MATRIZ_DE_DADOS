package com.example.Projeto_Credito_Rural.controller;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ConsumoAPIExterna;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import com.example.Projeto_Credito_Rural.repositories.ProductReturn;
import com.example.Projeto_Credito_Rural.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ConsumoAPIExterna consumoAPIExterna;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> getProducts(Pageable pageable){
        return productService.getProducts(pageable);
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
