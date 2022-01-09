# apiTrelloAutomacao
__API Trello__. O Trello é uma ferramenta de gerenciamento de projetos gratuita e online.

O __objetivo__ desse projeto é automatizar a funcionalidade de criação, edição e exclusão de um card seguindo a documentação 
que consta no link https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/ 

Para a criação dos cenários de fluxo de sucesso e fluxos alternativos foi levado em consideração as requisições da API do Trello.

O __objetivo__ de um __teste automatizado__ é conseguir através de scripts ter mais __confiança__ na hora de fazer mudanças no seu código.

__Benefícios para o time:__ Dar feedback rápido do que quebrou na aplicação.

Segue abaixo o que foi utilizado no desesenvolvimento do projeto:

__Bibliotecas utilizadas:__ RestAssured, Owner.

__Dependências:__ Junit, RestAssured, DataBinding, Json Schema Validator, Owner.

No projeto foi utilizado POJO (objetos simples do java), Data Factory, DataBinding (para isolar os dados dentro de um arquivo externo).

Foi criada uma classe para testar a aderência ao contrato com json schema. 

Também foi utilizada a biblioteca owner para segregar as propriedades de forma mais elegante sem precisar alterar informações diretamente nos arquivos java.

__#COMO REPRODUZIR__

Para reproduzir o projeto na sua máquina, abra seu terminal e execute o comando 

git clone https://github.com/nairabrito/apiTrelloAutomacao.git
