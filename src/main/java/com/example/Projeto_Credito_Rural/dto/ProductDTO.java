package com.example.Projeto_Credito_Rural.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@NoArgsConstructor
@Data
public class ProductDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nomeProduto")
    private String nomeProduto;

    @JsonProperty("nomeRegiao")
    private String nomeRegiao;

    @JsonProperty("nomeUF")
    private String nomeUF;

    @JsonProperty("MesEmissao")
    private String MesEmissao;

    @JsonProperty("AnoEmissao")
    private String AnoEmissao;

    @JsonProperty("cdPrograma")
    private String cdPrograma;

    @JsonProperty("cdSubPrograma")
    private String cdSubPrograma;

    @JsonProperty("cdFonteRecurso")
    private String cdFonteRecurso;

    @JsonProperty("cdTipoSeguro")
    private String cdTipoSeguro;

    @JsonProperty("QtdCusteio")
    private Integer QtdCusteio;

    @JsonProperty("VlCusteio")
    private BigDecimal VlCusteio;

    @JsonProperty("Atividade")
    private String Atividade;

    @JsonProperty("cdModalidade")
    private String cdModalidade;

    @JsonProperty("AreaCusteio")
    private String AreaCusteio;

}
