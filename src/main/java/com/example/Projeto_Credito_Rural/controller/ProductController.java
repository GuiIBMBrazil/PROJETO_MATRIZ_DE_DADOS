package com.example.Projeto_Credito_Rural.controller;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.dto.ProductSelect;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.example.Projeto_Credito_Rural.repositories.ConsumoAPIExterna;
import com.example.Projeto_Credito_Rural.repositories.ProductCustomRepository;
import com.example.Projeto_Credito_Rural.repositories.ProductRepository;
import com.example.Projeto_Credito_Rural.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductCustomRepository productCustomRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ConsumoAPIExterna consumoAPIExterna;


    //CONSULTAR REGISTROS COM PAGINAÇÃO.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> getProducts(Pageable pageable){
        return productService.getProducts(pageable);
    }

    //CONSULTAR REGISTROS POR ID.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductDTO> getProductById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @GetMapping("/find")
    public List<Product> getProductsCustom(){
        String nome_produto = "LEITE";
        return productCustomRepository.findAllSelect();
    }


    /*REALIZAR CONSULTA E SOMATÓRIA POR ANO DE EMISSÃO DOS PRODUTOS FEIJÃO,SOJA,TRIGO,MILHO E
    CANA DE AÇUCAR
     */
    @GetMapping("/ano")
    public List<Object> getProductsBySelectYear(@RequestParam(name = "ano_emissao",required = false) String ano_emissao){
        return productService.selectByYear(ano_emissao);
    }

    //REALIZA A INSERÇÃO DE OBJETOS
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String save(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    //REALIZA A DELEÇÃO DE UM OBJETO PELO ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") Integer id){
        return productService.deleteProductById(id);
    }

    //REALIZA A ATUALIZAÇÃO PELO ID
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Integer id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }














//    @GetMapping("/p")
//    public ProductDTO getProduct(){
//        return consumoAPIExterna.returnProduct().getValue().get(0);
//    }

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
