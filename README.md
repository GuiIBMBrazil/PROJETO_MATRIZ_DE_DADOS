<h1 align="center">PROJETO API CRÉDITO RURAL</h1>
<h2 align="center">
  ♦️: PROJETO FINALIZADO ♦️:

<p>O projeto a seguir visa têm como objetivo realizar tipos diferentes de consulta, inserção, deleção e atualização no banco de dados.
O banco de dados MySQL foi povoado com 1000 elementos por meio de um processo de onboarding, utilizando o framewrok OpenFeign para o consumo de API externa da Matriz de Dados dos Contratos de Comercialização por Produto,Região e UF, do Banco Central do Brasil.
</p>
</h2>
  
#URL DA API EXTERNA:

- https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto?$top=1000&$format=json&$select=nomeProduto,nomeRegiao,nomeUF,MesEmissao,AnoEmissao,cdPrograma,cdSubPrograma,cdFonteRecurso,cdTipoSeguro,QtdCusteio,VlCusteio,Atividade,cdModalidade,AreaCusteio



ENDPOINTS PRINCIPAIS

1° ENPOINT: O primero endpoint realiza a consulta de todos os produtos do banco de dados com paginação.

<img width="868" alt="CONSULTAS COM PAGINAÇÃO" src="https://user-images.githubusercontent.com/110836645/190983727-7ac9f3f2-130c-4615-856b-c6281215d1f3.png">
