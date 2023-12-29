# Gerenciador de Estoque

Este é um projeto de Gerenciador de Estoque desenvolvido em Java com o framework Spring Boot. O sistema oferece funcionalidades para o controle de produtos e vendas, permitindo o cadastro de produtos, consulta de estoque, realização de vendas e atualização do estoque após uma venda.

## Estrutura do Projeto

O projeto é dividido em pacotes que representam as camadas da aplicação:

- **com.controle.de.estoque:** Pacote principal do projeto.
    - **service:** Contém as interfaces e implementações dos serviços relacionados a produtos e vendas.
        - **ProdutoService:** Interface para operações relacionadas a produtos.
        - **VendaService:** Interface para operações relacionadas a vendas.
        - **impl:** Implementações concretas dos serviços.
    - **model:** Contém as classes que representam os modelos de dados.
        - **Produto:** Representa um produto no estoque.
        - **Venda:** Representa uma venda realizada.
    - **repository:** Repositórios para acesso a dados.
        - **ProdutoRepository:** Repositório para operações relacionadas a produtos.
        - **VendaRepository:** Repositório para operações relacionadas a vendas.
    - **view:** Pacote para classes DTO (Data Transfer Object) usadas na comunicação com a camada de visão.
        - **ProdutoDTO:** DTO para representar dados de produtos na camada de visão.
        - **VendaDTO:** DTO para representar dados de vendas na camada de visão.
    - **GerenciadorEstoqueApplication:** Classe principal que inicia a aplicação Spring Boot.

## Funcionalidades

### Produto

- **Buscar Todos os Produtos:** Endpoint para obter a lista de todos os produtos cadastrados.
- **Cadastrar Produto:** Endpoint para cadastrar um novo produto.

### Venda

- **Realizar Venda:** Endpoint para realizar uma venda, verificando a existência do produto e a quantidade em estoque.
- **Atualizar Estoque:** Método para atualizar o estoque após uma venda, utilizando o ID da venda e a quantidade vendida.

## Tecnolonogias
- **Spring Boot:** O projeto utiliza o framework Spring Boot para facilitar o desenvolvimento de aplicativos Java.

- **Java:** A versão do Java usada é a 17.

- **Spring Web Starter:** Uma dependência que fornece funcionalidades para o desenvolvimento de aplicativos da web usando o Spring MVC.

- **Spring Data JPA Starter:** Uma dependência que facilita o uso do Spring Data JPA para acesso a dados.

- **Validation API:** Uma dependência que fornece suporte para validação de dados.

- **Jettison:** Uma biblioteca para trabalhar com JSON em Java.

- **JsonPath:** Uma biblioteca para navegação e manipulação de documentos JSON.

- **Gson:** Uma biblioteca para serialização e desserialização de objetos JSON em Java.

- **MySQL Connector/J:** O driver JDBC para conexão com o banco de dados MySQL.

- **Lombok:** Uma biblioteca que simplifica a escrita de código Java, evitando a necessidade de escrever getters, setters, construtores, etc.

- **Springfox Swagger 2:** Uma dependência para integrar a geração de documentação Swagger à aplicação.

- **Spring Boot DevTools:** Uma dependência para facilitar o desenvolvimento, fornecendo recursos como reinicialização automática do aplicativo durante o desenvolvimento.

- **JUnit (parte do Spring Boot Starter Test):** Uma dependência para testes unitários.

- **XBean Reflect:** Uma biblioteca para reflexão de classes baseada em XML.

## Como Executar

1. Certifique-se de ter o Java e o Maven instalados em seu ambiente.
2. Clone o repositório: `git clone https://github.com/seu-usuario/gerenciador-estoque.git`
3. Navegue até o diretório do projeto: `cd gerenciador-estoque`
4. Execute a aplicação: `mvn spring-boot:run`

Acesse a aplicação em `http://localhost:8080` e explore as funcionalidades do Gerenciador de Estoque.

Este projeto serve como base e pode ser expandido com novas funcionalidades e melhorias conforme necessário. Sinta-se à vontade para contribuir ou adaptar conforme suas necessidades específicas.
