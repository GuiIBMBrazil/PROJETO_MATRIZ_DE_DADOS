package com.example.Projeto_Credito_Rural.repositories;

import com.example.Projeto_Credito_Rural.dto.ProductDTO;
import com.example.Projeto_Credito_Rural.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductReturn {
    @JsonProperty("@odata.context")
    private String data;

    @JsonProperty("value")
    private List<ProductDTO> value;
}
