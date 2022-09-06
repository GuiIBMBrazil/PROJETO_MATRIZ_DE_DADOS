package com.example.Projeto_Credito_Rural.controller;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ConsumoAPIExterna;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import com.example.Projeto_Credito_Rural.repositories.ProductReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/insert")
    public String insertObj(){

        List<ProductDTO> productDTOS = consumoAPIExterna.returnProduct().getValue();



//        ProductDTO productDTO = consumoAPIExterna.returnProduct().getValue().get(0);
//        Product product = new Product();
//
//        product.setNomeProduto(productDTO.getNomeProduto());
//        product.setNomeRegiao(productDTO.getNomeRegiao());
//        product.setAnoEmissao(productDTO.getAnoEmissao());
//        product.setAtividade(productDTO.getAtividade());
//        product.setAreaCusteio(productDTO.getAreaCusteio());
//        product.setCdFonteRecurso(productDTO.getCdFonteRecurso());
//        product.setCdTipoSeguro(productDTO.getCdTipoSeguro());
//        product.setCdSubPrograma(productDTO.getCdSubPrograma());
//        product.setMesEmissao(productDTO.getMesEmissao());
//        product.setCdModalidade(productDTO.getCdModalidade());
//        product.setNomeUF(productDTO.getNomeUF());
//        product.setVlCusteio(productDTO.getVlCusteio());
//        product.setCdPrograma(productDTO.getCdPrograma());
//        product.setQtdCusteio(productDTO.getQtdCusteio());
//
//        productRepository.save(product);

        return "Objeto Salvo!";
    }
}
