package com.example.Projeto_Credito_Rural.repositories;
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


//TERCEIRO ENDPOINT

    @Query(value = "SELECT * from Product p where p.nome_produto=:nome_produto", nativeQuery = true)
    List<Product> selectByNomeProduto(@Param("nome_produto") String nome_produto);


    @Query(value = "SELECT * from Product p where p.nomeuf=:nomeuf", nativeQuery = true)
    List<Product> selectByNomeUF(@Param("nomeuf") String nomeuf);

    @Query(value = "SELECT * from Product p where p.nome_regiao=:nome_regiao", nativeQuery = true)
    List<Product> selectByRegiao(@Param("nome_regiao") String nome_regiao);

    @Query(value = "SELECT * from Product p where p.atividade=:atividade", nativeQuery = true)
    List<Product> selectByAtividade(@Param("atividade") String atividade);

    @Query(value = "SELECT * from Product p where p.cd_programa=:cd_programa", nativeQuery = true)
    List<Product> selectByPrograma(@Param("cd_programa") String cd_programa);

    @Query(value = "SELECT * from Product p where p.cd_sub_programa=:cd_sub_programa", nativeQuery = true)
    List<Product> selectBySubPrograma(@Param("cd_sub_programa") String cd_sub_programa);

    @Query(value = "SELECT * from Product p where p.cd_fonte_recurso=:cd_fonte_recurso", nativeQuery = true)
    List<Product> selectByFonteRecurso(@Param("cd_fonte_recurso") String cd_fonte_recurso);

    @Query(value = "SELECT * from Product p where p.cd_modalidade=:cd_modalidade", nativeQuery = true)
    List<Product> selectByModalidade(@Param("cd_modalidade") String cd_modalidade);

    @Query(value = "SELECT * from Product p where p.ano_emissao=:ano_emissao", nativeQuery = true)
    List<Product> selectByAnoEmissao(@Param("ano_emissao") String ano_emissao);

    @Query(value = "SELECT * from Product p where p.mes_emissao=:mes_emissao", nativeQuery = true)
    List<Product> selectByMesEmissao(@Param("mes_emissao") String mes_emissao);

    @Query(value = "SELECT * from Product p where p.cd_tipo_seguro=:cd_tipo_seguro", nativeQuery = true)
    List<Product> selectByTipoSeguro(@Param("cd_tipo_seguro") String cd_tipo_seguro);

    @Query(value = "SELECT * from Product p where p.vl_custeio=:vl_custeio", nativeQuery = true)
    List<Product> selectByVlCusteio(@Param("vl_custeio") BigDecimal vl_custeio);

    @Query(value = "SELECT * from Product p where p.qtd_custeio=:qtd_custeio", nativeQuery = true)
    List<Product> selectByQtdCusteio(@Param("qtd_custeio") Integer qtd_custeio);


}






