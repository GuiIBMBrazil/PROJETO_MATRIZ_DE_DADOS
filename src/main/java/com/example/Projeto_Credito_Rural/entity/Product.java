package com.example.Projeto_Credito_Rural.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    private String MesEmissao;
    private String AnoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private Integer QtdCusteio;
    private BigDecimal VlCusteio;
    private String Atividade;
    private String cdModalidade;
    private String AreaCusteio;
}
