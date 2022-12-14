<h1 align="center">PROJETO API CRÉDITO RURAL</h1>
<h2 align="center">
  ♦️: PROJETO FINALIZADO ♦️:

<p>O projeto a seguir visa têm como objetivo realizar tipos diferentes de consulta, inserção, deleção e atualização no banco de dados.
O banco de dados MySQL foi povoado com 1000 elementos por meio de um processo de onboarding, utilizando o framewrok OpenFeign para o consumo de API externa da Matriz de Dados dos Contratos de Comercialização por Produto,Região e UF, do Banco Central do Brasil.
</p>
</h2>
  
#URL DA API EXTERNA:

- https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto?$top=1000&$format=json&$select=nomeProduto,nomeRegiao,nomeUF,MesEmissao,AnoEmissao,cdPrograma,cdSubPrograma,cdFonteRecurso,cdTipoSeguro,QtdCusteio,VlCusteio,Atividade,cdModalidade,AreaCusteio



<h2>ENDPOINTS PRINCIPAIS</h2>

<h3>GET</h3>

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


4° ENDPOINT: O quarto endpoint simplesmente retorna a lista de todos os produtos sem paginação, embora não seja muito usual o usuário pode ter preferência por esse tipo de consulta.


INSOMNIA

Para realizar esse tipo de consulta no Insomnia basta digitar a URL padrão seguido da anotação "/spag", basicamente seria "http://localhost:8080/product/spag".

<img width="773" alt="CONSULTA SEM PAGINAÇÃO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/191002032-4046dbef-4773-4653-8b76-f08a07ab44ce.png">


SWAGGER UI

No Swagger UI basta escolher a opção "getProductsSPag" e clicar em "Execute".

<img width="848" alt="SPAG SWAGGER UI" src="https://user-images.githubusercontent.com/110836645/191002841-384641ca-2a0f-4e70-b5c1-09b6ba7d0ffc.png">


5° ENDPOINT: o quinto endpoint realiza consultas com quaisquer parâmetros, ou seja, o usuário pode escolher produtos por qualquer um dos atributos, exceto o ID pois já existe um ENDPOINT para o mesmo.

INSOMNIA

Ainda no método GET pois se trata de uma consulta, o usuário irá digitar a URL padrão + "/find" e o parâmetro que deseja, um determinado atributo com um determinado valor, vale ressaltar que a URL é Case Sensitivity então para realizar as consultas é recomendado usar a lista de nomes abaixo, é como a API irá entender o que é solicitado:


-nomeProduto </br>
-nomeRegiao </br>
-nomeUF</br>
-cdPrograma </br>
-cdSubPrograma </br>
-cdFonteRecurso </br>
-cdTipoSeguro</br>
-cdModalidade </br>
-AnoEmissao</br>
-MesEmissao </br>
-VlCusteio </br>
-QtdCusteio </br>
-Atividade
 

No exemplo abaixo será realizada uma consulta onde se quer todos os produtos cujo o nomeProduto seja igual a leite.

<img width="727" alt="CONSULTA QUERY POR NOME PRODUTO" src="https://user-images.githubusercontent.com/110836645/191109087-7c828fdc-732b-4185-823b-6f2f116bfba3.png">

Agora ainda é possível mudar o parâmetro e solicitar uma nova consulta em que os produtos devem nomeRegiao igual a sul.

<img width="767" alt="CONSULTA QUERY DINÂMICA POR NOME REGIÃO" src="https://user-images.githubusercontent.com/110836645/191109712-bd6b5878-40d1-4223-9376-06beb360cb76.png">


SWAGGER UI

No caso do Swagger UI deve-se escolher a opção GET getProductsCustom, após clicar em "try it out" irá aparecer campos de preenchimento para todos os atributos, porém vale ressaltar que essa API permite a escolha de apenas 1 campo por consulta, você não pode escolher mais de dois parâmetros ao mesmo tempo nessa API, no exemplo abaixo será selecionado todos os produtos cuja atividade seja do tipo 1.

<img width="931" alt="USANDO O SWAGGER 5 ENDPOINT ATIVIDADE" src="https://user-images.githubusercontent.com/110836645/191112780-7e4cb141-64b5-41e8-8311-fd1dd8ac8c0e.png">

RESULTADO DA CONSULTA DO SWAGGER UI
<img width="929" alt="5 ENDPOINT RESULTADO SWAGGER" src="https://user-images.githubusercontent.com/110836645/191113063-102b013f-c5f1-4b6a-8674-d0acd9f3d8ea.png">




<h3>CRUD</h3>

Até o momento só foi mostrado a consulta do banco de dados, sem realizar nenhuma alteração no mesmo, partir de agora será mostrado como se realizar inserções, deleções e atualizações no banco de dados da aplicação.

<h4>INSERÇÃO</h4>

A inserção no banco de dados pode ser feita de maneira simples se seguido as regras do formato JSON para a entrada de dados.

INSOMNIA

Para realizar a inserção usando o Insomnia o usuário deverá mudar o método de requisição de GET para POST, selecionar o formato JSON como entrada do body digitar os atributos do novo produto, sem o ID pois o próprio banco de dados irá atribuir um ID para o objeto, note o exemplo abaixo.

<img width="960" alt="COMO REALIZAR INSERÇÃO COM O INSOMNIA" src="https://user-images.githubusercontent.com/110836645/191017753-6b0d0e2c-26a0-4cbd-a300-ba748f8981d9.png">

Se houver sucesso na inserção, a "Preview" deve mostrar a mensagem dizendo que o objeto foi inserido com sucesso e o ID do novo registro, se usar o GET e buscar esse registro pelo ID ele deve constar na base de dados, conforme o exemplo abaixo.

<img width="762" alt="CONSULTANDO NOVO REGISTRO" src="https://user-images.githubusercontent.com/110836645/191018673-576d8a27-d886-4c2e-a443-db20d80029f5.png">


SWAGGER UI

No Swagger UI o usuário deve buscar a opção POST save, clicar em "try it out" e logo depois o Swagger irá solicitar os parâmetros desse tipo de requisição, isto é, o body do novo registro.

REALIZANDO INSERÇÃO
<img width="927" alt="PARÂMETROS SWAGGER UI INSERÇÃO" src="https://user-images.githubusercontent.com/110836645/191020297-24cf8787-a602-4074-b917-5fec57bf428e.png">

OBJETO INSERIDO
<img width="928" alt="OBJETO INSERIDO PELO SWAGGER" src="https://user-images.githubusercontent.com/110836645/191020836-d2fdea63-2947-4c82-bc8a-6e6e3c42f94a.png">


<h4>ATUALIZAÇÃO</h4>

A atualização de um registro é parecida com a inserção, porém nesse caso não deve haver alteração do ID, uma vez que nada novo foi criado.


INSOMNIA

Para realizar a atualização de um registro, o usuário deve escolher o método PUT e digitar a URL padrão seguida no ID do objeto que o usuário deseja atualizar, no exemplo abaixo é realizada a atualização do objeto cujo o ID é 5, do nordeste ele passará a ser do sul.

<img width="773" alt="ATUALIZAÇÃO USANDO O INSOMNIA" src="https://user-images.githubusercontent.com/110836645/191022312-7c6526d1-3513-4550-b059-efb39d896aa7.png">

ALTERANDO A REGIÃO

<img width="764" alt="REGISTRO ATUALIZADO COM SUCESSO INSOMNIA" src="https://user-images.githubusercontent.com/110836645/191022721-36e229a8-3816-46a9-a2d7-f3e9fb262f18.png">

Agora se for realizada a busca do produto cujo o ID é 5 pelo método GET, a região terá sido alterada.

<img width="780" alt="VERIFICANDO ATUALIZAÇÃO" src="https://user-images.githubusercontent.com/110836645/191023214-fa4354a2-7ebf-48e3-ae93-c630f09db586.png">


SWAGGER UI

No Swagger UI deve ser escolhida a opção "update", depois de clicar em "try it out", o usuário deve informar o ID desejado e atualizar os atributos que deseja, no exemplo abaixo será usado o registro cujo o ID é 5 e a região voltará a ser o nordeste.

ATUALIZANDO REGISTRO
<img width="922" alt="ATUALIZANDO REGISTRO SWAGGER" src="https://user-images.githubusercontent.com/110836645/191024615-9b71fb4a-b21c-4325-98c4-2de5c56b708a.png">

REGISTRO ATUALIZADO
<img width="921" alt="VERIFICANDO ATUALIZAÇÃO SWAGGER" src="https://user-images.githubusercontent.com/110836645/191024868-3b5ca1f8-71e1-4ec2-ada0-5d47d301f59d.png">


<h4>DELEÇÃO</h4>

A deleção de um reistro pode ser feita através de seu ID.

INSOMNIA

No Insomnia basta mudar o método de GET para DELETE e digitar o ID do objeto desejado, como no exemplo abaixo será deletado o objeto cujo o ID é 1010.

<img width="803" alt="DELETANDO REGISTROS COM INSOMNIA" src="https://user-images.githubusercontent.com/110836645/191033010-434f13ff-3e20-4ee6-a69e-eb89734253d5.png">

Agora se o método GET for usado para buscar o registro cujo ID é 1010, ele não deverá constar na base de dados.

<img width="783" alt="CONFIRMANDO A DELEÇÃO DO OBJETO" src="https://user-images.githubusercontent.com/110836645/191036578-4ced9c46-c921-4368-8971-857360c0aa27.png">


SWAGGER UI

No Swagger UI o usuário deverá escolher a opção DELETE delete e depois de clicar em "try it out" e logo depois informar como parâmetro o ID do registro desejado, NO caso será deletado o elemento de ID 1012 que consta na base de dados.

<img width="927" alt="ESCOLHENDO PARÂMETRO DO DELETE SWAGGER UI" src="https://user-images.githubusercontent.com/110836645/191039284-2c7fdeaf-2d7e-4e22-8659-376c8fdea04d.png">

OBJETO DELETADO

<img width="941" alt="VERIFICANDO DELEÇÃO DO OBJETO SWAGGER" src="https://user-images.githubusercontent.com/110836645/191040768-9ed836c5-8774-4a45-8778-5f9eacc8c6d5.png">

Se for realizada uma consulta pelo registro cujo o ID é 1012, ele não deve constar mais na base de dados.

<img width="754" alt="CONFIRMANDO DELEÇÃO SWAGGER UI" src="https://user-images.githubusercontent.com/110836645/191041645-e6e87dda-eb26-4f58-91e6-6de4c7951070.png">


