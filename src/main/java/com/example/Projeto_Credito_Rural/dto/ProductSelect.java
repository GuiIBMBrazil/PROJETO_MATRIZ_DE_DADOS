package com.example.Projeto_Credito_Rural.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSelect{
    private String nomeProduto;
    private BigDecimal QtdCusteio;
    private Integer VlCusteio;
}
