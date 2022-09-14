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
    String selectYearSoja(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"TRIGO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    String selectYearTrigo(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"MILHO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    String selectYearMilho(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"CANA-DE-AÇUCAR\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    String selectYearCanaAcucar(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT nome_produto,sum(vl_custeio),sum(qtd_custeio) from Product p where p.nome_produto='\"FEIJÃO\"' AND p.ano_emissao=:ano_emissao",nativeQuery = true)
    String selectYearFeijao(@Param("ano_emissao") String ano_emissao);

  }






  //TENTATIVA DO TERCEIRO ENDPOINT (REPOSITORY)

//@Query(value = "SELECT * from Product p where p.nome_produto=:nome_produto OR " +
//            "p.nome_regiao=:nome_regiao OR p.ano_emissao=:ano_emissao OR p.cd_fonte_recurso=:cd_fonte_recurso OR" +
//            "p.cd_modalidade=:cd_modalidade OR p.mes_emissao=:mes_emissao OR p.cd_programa=:cd_programa OR" +
//            "p.cd_sub_programa=:cd_sub_programa OR p.cd_tipo_seguro=:cd_tipo_seguro OR p.nomeuf=:nomeuf OR p.atividade=:atividade OR" +
//            "p.qtd_custeio=:qtd_custeio OR p.vl_custeio=:vl_custeio",nativeQuery = true)
//    List<Product> selectProduct(@Param("nome_produto") String nome_produto,
//                                @Param("nome_regiao") String nome_regiao,
//                                @Param("ano_emissao") String ano_emissao,
//                                @Param("cd_fonte_recurso") String cd_fonte_recurso,
//                                @Param("cd_modalidade") String cd_modalidade,
//                                @Param("mes_emissao") String mes_emissao,
//                                @Param("cd_programa") String cd_programa,
//                                @Param("cd_sub_programa") String cd_sub_programa,
//                                @Param("qtd_custeio") Integer qtd_custeio,
//                                @Param("vl_custeio") BigDecimal vl_custeio,
//                                @Param("atividade") String atividade,
//                                @Param("nomeuf") String nomeuf,
//                                @Param("cd_tipo_seguro") String cd_tipo_seguro);