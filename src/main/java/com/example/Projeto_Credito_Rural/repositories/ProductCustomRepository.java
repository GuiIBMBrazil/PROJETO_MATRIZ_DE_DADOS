package com.example.Projeto_Credito_Rural.repositories;

import com.example.Projeto_Credito_Rural.dto.ProductSelect;
import com.example.Projeto_Credito_Rural.entity.Product;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductCustomRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from Product p where p.nome_regiao=\"SUL\" ",nativeQuery = true)
    List<Product> findAllSelect();


    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"SOJA\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    Object selectYearSoja(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"TRIGO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    Object selectYearTrigo(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"MILHO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    Object selectYearMilho(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"CANA-DE-AÇUCAR\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    Object selectYearCanaAcucar(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"FEIJÃO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    Object selectYearFeijao(@Param("ano_emissao") String ano_emissao);



}
