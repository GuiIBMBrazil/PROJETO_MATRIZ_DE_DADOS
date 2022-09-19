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

<img width="343" alt="PAGINAÇÃO" src="https://user-images.githubusercontent.com/110836645/190985315-9d31c4d2-5374-48a5-a528-389dc5d77e54.png">

A consulta pode ser realizada usando a documentação Swagger, ou como no exemplo acima uma ferramenta como o Insomnia ou Postman.


INSOMNIA

O uso do Insomnia e Postman é bem parecido, a requisição será feita através da URL na porta 8080 e no caso dessa API qualquer requisição começa com "/product" logo após "http://localhost:8080", no caso do primeiro endpoint, basta digitar na URL para ter acesso a primeira página da lista "http://localhost:8080/product", utilizando o tipo GET na requisição, como no exemplo abaixo.

<img width="508" alt="COMO FAZER UMA REQUISIÇÃO NO PRIMEIRO ENDPOINT NO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/190987097-63387fc5-2009-4138-af8c-798bdd937692.png">

Como é uma consulta com paginação, existe um método para visualizar as outras páginas da consulta, para isso basta digitar a URL exatamente como em uma consulta normal porém logo depois você deve digitar "?page=(número da página desejada)" e assim você pode conseguir acesso as outras páginas da consulta, conforme o exemplo abaixo.


