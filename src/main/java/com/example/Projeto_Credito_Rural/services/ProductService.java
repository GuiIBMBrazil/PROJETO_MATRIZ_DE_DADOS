package com.example.Projeto_Credito_Rural.services;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ProductCustomRepository;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import feign.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCustomRepository productCustomRepository;


    public List<String> selectByYear(String ano_emissao){
        List<String> list = new ArrayList<>();

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

        ModelMapper modelMapper = new ModelMapper();

        Optional<Product> optional = productRepository.findById(id);

        productRepository.findById(id)
                .map(productBase -> {
                    modelMapper.map(product,productBase);
                    productRepository.save(productBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "REGISTRO NÃO ENCONTRADO"));
        return "REGISTRO ATUALIZADO";
       }

    }

    //TENTATIVAS DO TERCEIRO ENDPOINT (SERVICE).

//    public List<Product> selectProduct(
//            String nomeProduto,
//            String nomeRegiao,
//            String nomeUF,
//            String cdPrograma,
//            String cdSubPrograma,
//            String cdFonteRecurso,
//            String cdTipoSeguro,
//            String cdModalidade,
//            String AnoEmissao,
//            String MesEmissao,
//            Integer QtdCusteio,
//            BigDecimal VlCusteio,
//            String Atividade
//    ){
//        List<Product> products = new ArrayList<>();
//        products =
//        productCustomRepository.selectProduct(
//                nomeProduto,
//                nomeRegiao,
//                AnoEmissao,
//                cdFonteRecurso,
//                cdModalidade,
//                MesEmissao,
//                cdPrograma,
//                cdSubPrograma,
//                nomeUF,
//                QtdCusteio,
//                VlCusteio,
//                Atividade,
//                cdTipoSeguro
//        );
//        return products;
//    }
