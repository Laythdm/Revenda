# Revenda

Este projeto é um sistema web simples que estou desenvolvendo para
simular o funcionamento interno de uma pequena revendedora de veículos.

Ele foi criado originalmente como Projeto Integrador do curso técnico e
agora estou retomando o projeto para melhorar a estrutura, adicionar
novas funcionalidades e aplicar conhecimentos adiquiridos após o termino do
curso.

------------------------------------------------------------------------

## Sobre o projeto

A ideia é ter um sistema básico onde seja possível:

-   Cadastrar carros
-   Visualizar o estoque
-   Dar baixa em veículos
-   Ter usuários com níveis diferentes de acesso (gerente e vendedor)

O foco principal do projeto é praticar desenvolvimento web com Java,
organização de código, banco de dados e regras de negócio.

------------------------------------------------------------------------

## Funcionalidades atuais

-   Sistema de login
-   Dois tipos de usuário:
  -   Gerente (pode cadastrar e dar baixa)
  -   Vendedor (pode dar baixa e visualizar)
-   Cadastro de carros
-   Listagem de veículos
-   Alteração de status
-   API REST simples para testes
-   Validação de campos

------------------------------------------------------------------------

## Usuários para teste

Ao rodar o sistema, são criados automaticamente dois usuários:

-   Login: gerente
    Senha: 123

-   Login: vendedor
    Senha: 123

------------------------------------------------------------------------

## Tecnologias usadas

-   Java
-   Spring Boot
-   Spring MVC
-   Spring Data JPA
-   Spring Security
-   Thymeleaf
-   MySQL
-   Maven

------------------------------------------------------------------------

## Como rodar o projeto

### Requisitos

-   Java 17 ou superior
-   MySQL
-   NetBeans (ou outra IDE Java)

------------------------------------------------------------------------

### Banco de dados

Crie um banco no MySQL, por exemplo:

``` sql
CREATE DATABASE integrador_db;
```

Depois configure o arquivo `application.properties` com seu usuário e
senha do banco.

------------------------------------------------------------------------

### Executar o projeto

#### Opção 1 -- Executando pelo NetBeans (forma mais simples)

1.  Abra o projeto no NetBeans
2.  Aguarde o Maven baixar as dependências
3.  Abra a classe principal do projeto (ex:
    `Atividade2Application.java`)
4.  Clique com o botão direito no arquivo
5.  Selecione **Run File**

Se o banco estiver configurado corretamente, o sistema irá iniciar
normalmente.

Depois acesse no navegador:

    http://localhost:8080/login

------------------------------------------------------------------------

## Observações

Este projeto ainda está em desenvolvimento e será melhorado aos poucos,
tanto no visual quanto nas funcionalidades.

------------------------------------------------------------------------

## Autor

João Gabriel da Rosa Silva
Estudante de Engenharia de Software / Desenvolvimento de Sistemas
