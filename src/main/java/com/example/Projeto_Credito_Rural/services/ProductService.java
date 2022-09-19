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


    public List<String> selectByYear(String ano_emissao) {
        List<String> list = new ArrayList<>();

        list.add(productCustomRepository.selectYearFeijao(ano_emissao));
        list.add(productCustomRepository.selectYearMilho(ano_emissao));
        list.add(productCustomRepository.selectYearSoja(ano_emissao));
        list.add(productCustomRepository.selectYearCanaAcucar(ano_emissao));
        list.add(productCustomRepository.selectYearTrigo(ano_emissao));

        return list;
    }

    //CONSULTAR TODOS OS PRODUCTS SEM PAGINAÇÃO
    public List<ProductDTO> getProductsNoPageable() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product p : products) {
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

    public Optional<ProductDTO> getById(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            return null;
        }
        return Optional.of(new ProductDTO(product.get()));
    }

    //INSERÇÃO
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "OBJETO INSERIDO";
    }

    //DELEÇÃO
    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "OBJETO DELETADO";
    }

    //UPDATE
    public String updateProduct(Integer id, Product product) {

        ModelMapper modelMapper = new ModelMapper();

        Optional<Product> optional = productRepository.findById(id);

        productRepository.findById(id)
                .map(productBase -> {
                    modelMapper.map(product, productBase);
                    productRepository.save(productBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "REGISTRO NÃO ENCONTRADO"));
        return "REGISTRO ATUALIZADO";
    }


    public List<Product> selectProduct(
            String nomeProduto,
            String nomeRegiao,
            String AnoEmissao,
            String cdFonteRecurso,
            String cdModalidade,
            String MesEmissao,
            String cdPrograma,
            String cdSubPrograma,
            Integer QtdCusteio,
            BigDecimal VlCusteio,
            String Atividade,
            String nomeUF,
            String cdTipoSeguro
    ) {
        if (nomeProduto != null){
            return productCustomRepository.selectByNomeProduto(nomeProduto);
        }
        else if (nomeRegiao != null) {
            return productCustomRepository.selectByRegiao(nomeRegiao);
        }
        else if (AnoEmissao != null) {
            return productCustomRepository.selectByAnoEmissao(AnoEmissao);
        }
        else if (cdFonteRecurso != null) {
            return productCustomRepository.selectByFonteRecurso(cdFonteRecurso);
        }
        else if (cdModalidade != null) {
            return productCustomRepository.selectByModalidade(cdModalidade);
        }
        else if (MesEmissao != null) {
            return productCustomRepository.selectByMesEmissao(MesEmissao);
        }
        else if (cdPrograma != null) {
            return productCustomRepository.selectByPrograma(cdPrograma);
        }
        else if (cdSubPrograma != null) {
            return productCustomRepository.selectBySubPrograma(cdSubPrograma);
        }
        else if (QtdCusteio != null) {
            return productCustomRepository.selectByQtdCusteio(QtdCusteio);
        }
        else if (VlCusteio != null) {
            return productCustomRepository.selectByVlCusteio(VlCusteio);
        }
        else if (Atividade != null) {
            return productCustomRepository.selectByAtividade(Atividade);
        }
        else if (nomeUF != null) {
            return productCustomRepository.selectByNomeUF(nomeUF);
        }
        else if (cdTipoSeguro != null) {
            return productCustomRepository.selectByTipoSeguro(cdTipoSeguro);
        }
        else {
            return  null;
        }
    }

}







