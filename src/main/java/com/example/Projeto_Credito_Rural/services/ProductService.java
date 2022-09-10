package com.example.Projeto_Credito_Rural.services;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductCustomRepository;
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

    @Autowired
    ProductCustomRepository productCustomRepository;

    public List<Object> selectByYear(String ano_emissao){
        List<Object> list = new ArrayList<>();

        list.add(productCustomRepository.selectYearFeijao(ano_emissao));
        list.add(productCustomRepository.selectYearMilho(ano_emissao));
        list.add(productCustomRepository.selectYearSoja(ano_emissao));
        list.add(productCustomRepository.selectYearCanaAcucar(ano_emissao));
        list.add(productCustomRepository.selectYearTrigo(ano_emissao));

        return list;
    }

    //CONSULTAR TODOS OS PRODUCTS SEM PAGINAÇÃO
    public List<ProductDTO> getProductsNoPageable(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product p:products) {
            productDTOS.add(new ProductDTO(p));
        }

        return productDTOS;
    }

    //CONSULTAR TODOS OS PRODUCTS COM PAGINAÇÃO
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

    //INSERÇÃO
    public String saveProduct(Product product){
        productRepository.save(product);
        return "OBJETO INSERIDO";
    }

    //DELEÇÃO
    public String deleteProductById(Integer id){
        productRepository.deleteById(id);
        return "OBJETO DELETADO";
    }

    //UPDATE
    public String updateProduct(Integer id, Product product){
        Optional<Product> optional = productRepository.findById(id);

        if(optional.isPresent()){

            Product p = optional.get();
            p.setNomeProduto(product.getNomeProduto());
            p.setNomeUF(product.getNomeUF());
            p.setAreaCusteio(product.getAreaCusteio());
            p.setAtividade(product.getAtividade());
            p.setCdModalidade(product.getCdModalidade());
            p.setCdTipoSeguro(product.getCdTipoSeguro());
            p.setAnoEmissao(product.getAnoEmissao());
            p.setVlCusteio(product.getVlCusteio());
            p.setQtdCusteio(product.getQtdCusteio());
            p.setNomeRegiao(product.getNomeRegiao());
            p.setCdPrograma(product.getCdPrograma());
            p.setCdSubPrograma(product.getCdSubPrograma());
            p.setCdFonteRecurso(product.getCdFonteRecurso());
            p.setMesEmissao(product.getMesEmissao());

            productRepository.save(p);

            return "ID: " + p.getId() + " ATUALIZADO";
        }
        else {
            return null;
        }
    }
}
