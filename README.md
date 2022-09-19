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

<img width="754" alt="COMO REALIZAR A TROCA DE PÁGINA NO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/190988547-93c381e0-aa7f-4f69-a628-357222a5d100.png">

No exemplo acima é acessada a segunda página dessa consulta, também é possível consultar o número de elementos da consulta e o total de páginas geradas, conforme a imagem abaixo.

<img width="960" alt="PAGINAÇÃO NÚMERO DE ELEMENTOS E TOTAL DE PÁGINAS" src="https://user-images.githubusercontent.com/110836645/190989387-e7d62de1-23c2-4ea1-a225-6dfdd600803d.png">


POSTMAN

O uso do Postman é extremamente parecido com o do Insomnia porém possui uma interface gráfica diferente, as consultas através da URL "http://localhost:8080/product" e a visualização das páginas funciona da mesma forma, conforme a imagem abaixo.

<img width="637" alt="CONSULTA POR PAGINAÇÃO USANDO O POSTMAN" src="https://user-images.githubusercontent.com/110836645/190990204-d9bef1cc-f5c2-4f14-807b-464da3dd1db6.png">

Para realizar a troca de páginas, basta usar o mesmo método utilizado no Insomnia e digitar "?page=(número da página desejada)".


SWAGGER UI

A API utiliza o Swagger UI para tornar a consulta mais fácil e dinâmica, assim se pode visualizar os endpoints de uma forma mais rápida. Para acessar a documentação Swagger se deve digitar na URL da própria WEB a seguinte mensagem "http://localhost:8080/swagger-ui.html", a imagem abaixo exemplifica isso.

<img width="960" alt="COMO ACESSAR O SWAGGER" src="https://user-images.githubusercontent.com/110836645/190991615-d98f0182-18a9-4fae-910c-1f5c0dd40f63.png">

Quando se clicar em "product-controller" se pode ter acesso a todos os endpoints da API, no caso do primeiro endpoint se deve ir endpoint que está anotado como "getProducts", confrome a imagem abaixo.

<img width="932" alt="COMO ACESSAR O PRIMERO ENDPOINT COM O SWAGGER" src="https://user-images.githubusercontent.com/110836645/190992523-d7b4b053-e698-49ab-bf7f-3590cc6d61a9.png">

Após selecionar a opção e clicar em "try it out", o Swagger irá fornecer a opção de escolher o número da página e o tamanho da página, após fornecer esses parâmetros basta clicar em "Execute", a imagem abaix mostra o funcionamento.

<img width="918" alt="USO DO PRIMERO ENDPOINT NO SWAGGER" src="https://user-images.githubusercontent.com/110836645/190993659-d3d058e7-6cc2-4af5-92be-dab62636a540.png">

E no "Response Body" se tem o exemplo abaixo, com a consulta realizada.

<img width="894" alt="CONSULTA DO PRIMEIRO ENDPOINT NO SWAGGER" src="https://user-images.githubusercontent.com/110836645/190994120-2d398e00-717a-4991-9348-dd327e367d25.png">


2° ENDPOINT: O segundo endpoint realiza a consulta de um elemento pelo seu ID no banco de dados, nesse tópico o passo a passo do uso do Insmonia, Postman e Swagger não será extremamente aprofundado visto que isso já foi realizado no tópico anterior, como o uso do Insomnia e do Postman é extremamente parecido, só será abordado a utilização do Insomnia e do Swagger daqui em diante.

INSOMNIA

Para realizar uma consulta por ID no Insomnia basta digitar a URL padrão "http://localhost:8080/product" seguido por "/(id desejado)", ainda utilizando o método GET.

<img width="750" alt="CONSULTA DE UM PRODUTO PELO SEU ID NO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/190995633-bd304408-5742-48a7-a444-dcd01fe2bfa2.png">

SWAGGER UI

No Swagger UI deve-se selecionar a opção "getProductById" ao invés da opção "getProducts", e logo após o Swagger irá solicitar um parâmetro, que no caso será o ID do registro no banco de dados, após informar o mesmo basta clicar em "Execute" e a consulta será exibida.

PARÂMETRO SOLICITADO
<img width="916" alt="CONSULTA POR ID NO SWAGGER" src="https://user-images.githubusercontent.com/110836645/190996717-43ba8526-4693-4b4d-aed1-0a7259017ad9.png">

RESPOSTA DO ENDPOINT
<img width="907" alt="RESPOSTA DA CONSULTA POR ID NO SWAGGER" src="https://user-images.githubusercontent.com/110836645/190997062-e570e4bd-4b9b-4aac-b067-5d422eb2dc93.png">


3° ENDPOINT: O terceiro endpoint realiza a somatória dos atributos "VlCusteio" e "QtdCusteio" dos produtos soja,feijão,trigo, milho e cana de açucar, no período de 12 meses.

INSOMNIA

Para realizar esse tipo de consulta a regra é diferente, o usuário terá que digitar a URL padrão "http://localhost:8080/product" juntamente com a assinatura "/ano" e "?ano_emissao=(ano desejado)", por exemplo se o usuário desejasse a somatória do ano de 2018, ele teria que digitar isso "http://localhost:8080/product/ano?ano_emissao=2018", ainda no método GET pois é uma consulta, e a consulta seria exibida conforme o exemplo abaixo.

<img width="765" alt="CONSULTA POR ANO EMISSAO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/190999031-ecb5dc15-d563-4a5a-85fb-21fad114ed41.png">

SWAGGER UI

No Swagger UI a opção escolhida deve ser getProductsByYear, o Swagger irá solicitar um parâmetro chamado "ano_emissao" onde o usuário deve digitar o ano desejado da consulta, após informar e clicar em "Execute" a consulta será realizada.

PARÂMETRO ANO_EMISSAO
<img width="916" alt="ANO_EMISSAO SWAGGER UI" src="https://user-images.githubusercontent.com/110836645/190999714-fdfcfd2d-d9fc-4d4e-ba06-650caabb6a0c.png">

RESPOSTA DO ENDPOINT
<img width="889" alt="RESULTADO CONSULTA POR ANO_EMISSAO" src="https://user-images.githubusercontent.com/110836645/191000194-c196957d-43f1-4fbb-bd61-265f3c7a2a81.png">
Vale ressaltar que no resultado da consulta, o primero número após a vírgula é o somatório do "VlCusteio" e após a vírgula novamente o número seguinte é o somatório da "QtdCusteio".














