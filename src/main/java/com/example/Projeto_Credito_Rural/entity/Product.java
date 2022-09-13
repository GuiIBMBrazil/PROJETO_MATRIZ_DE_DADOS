package com.example.Projeto_Credito_Rural.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private String cdModalidade;
    private String AnoEmissao;
    private String AreaCusteio;
    private String MesEmissao;
    private BigDecimal VlCusteio;
    private Integer QtdCusteio;
    private String Atividade;
}
