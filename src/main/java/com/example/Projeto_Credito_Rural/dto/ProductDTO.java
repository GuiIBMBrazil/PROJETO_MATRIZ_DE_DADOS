package com.example.Projeto_Credito_Rural.dto;

import com.example.Projeto_Credito_Rural.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @JsonProperty("cdPrograma")
    private String cdPrograma;

    @JsonProperty("cdSubPrograma")
    private String cdSubPrograma;

    @JsonProperty("cdFonteRecurso")
    private String cdFonteRecurso;

    @JsonProperty("cdTipoSeguro")
    private String cdTipoSeguro;

    @JsonProperty("cdModalidade")
    private String cdModalidade;

    @JsonProperty("AnoEmissao")
    private String AnoEmissao;

    @JsonProperty("AreaCusteio")
    private String AreaCusteio;

    @JsonProperty("MesEmissao")
    private String MesEmissao;

    @JsonProperty("VlCusteio")
    private BigDecimal VlCusteio;

    @JsonProperty("QtdCusteio")
    private Integer QtdCusteio;

    @JsonProperty("Atividade")
    private String Atividade;



    public ProductDTO(Product p) {
        this.id = p.getId();
        this.nomeProduto = p.getNomeProduto();
        this.nomeRegiao = p.getNomeRegiao();
        this.nomeUF = p.getNomeUF();
        this.MesEmissao = p.getMesEmissao();
        this.AnoEmissao = p.getAnoEmissao();
        this.cdPrograma = p.getCdPrograma();
        this.cdSubPrograma = p.getCdSubPrograma();
        this.cdFonteRecurso = p.getCdFonteRecurso();
        this.cdTipoSeguro = p.getCdTipoSeguro();
        this.QtdCusteio = p.getQtdCusteio();
        this.VlCusteio = p.getVlCusteio();
        this.Atividade = p.getAtividade();
        this.cdModalidade = p.getCdModalidade();
        this.AreaCusteio = p.getAreaCusteio();
    }
}
