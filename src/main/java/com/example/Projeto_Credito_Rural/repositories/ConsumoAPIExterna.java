package com.example.Projeto_Credito_Rural.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto?$top=1000&$format=json&$select=nomeProduto,nomeRegiao,nomeUF,MesEmissao,AnoEmissao,cdPrograma,cdSubPrograma,cdFonteRecurso,cdTipoSeguro,QtdCusteio,VlCusteio,Atividade,cdModalidade,AreaCusteio")
public interface ConsumoAPIExterna {
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    ProductReturn returnProduct();
}
