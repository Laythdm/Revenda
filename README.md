Sistema de Controle de Revenda de Veículos

Este projeto é um sistema web para controle interno de uma pequena revendedora de veículos, permitindo o gerenciamento do estoque de carros, controle de usuários e fluxo básico de venda/dar baixa.

O projeto foi originalmente desenvolvido como Projeto Integrador do curso técnico e está sendo reativado e aprimorado com novas funcionalidades, melhorias de estrutura e segurança, com foco em aprendizado e portfólio.

Objetivo do sistema

Criar um sistema interno simples que permita a uma revendedora:

Cadastrar e gerenciar veículos

Visualizar estoque

Dar baixa em veículos

Controlar acesso por tipo de usuário (gerente e vendedor)

Simular um fluxo básico de operação de uma loja real

Funcionalidades atuais

Login de usuários

Controle de acesso por perfil

GERENTE: cadastrar veículos e dar baixa

VENDEDOR: dar baixa e visualizar

Cadastro de carros

Listagem de veículos

Alteração de status do carro

API REST para testes (Postman)

Validações de campos

Dashboard inicial

Usuários de teste

Ao iniciar o sistema, dois usuários são criados automaticamente:

gerente
senha: 123

vendedor
senha: 123

Tecnologias utilizadas

Java 17

Spring Boot

Spring MVC

Spring Data JPA

Spring Security

Thymeleaf

MySQL

Maven

Estrutura do projeto

controller → controllers MVC e REST

service → regras de negócio

data → entidades JPA e repositórios

config → configurações de segurança e login

templates → telas do sistema

static → CSS e recursos estáticos

Como rodar (do jeito que eu uso no NetBeans)
Abra o projeto no NetBeans.
Localize a classe: src/main/java/com/ativ/atividade2/Atividade2Application.java
Clique com o botão direito em Atividade2Application.java e use Run File.
Banco de dados
Projeto usando MySQL.
Configure usuário/senha do banco em: src/main/resources/application.properties
Obs.: se você já tinha carros antigos no banco e adicionou o campo cor depois, pode existir registro antigo sem cor.
Caso dê problema, dá para corrigir rápido com:

UPDATE carro SET cor = 'Não informado' WHERE cor IS NULL OR cor = '';
Acesso (login)
Existem dois perfis para teste:
GERENTE (senha: 123)
VENDEDOR (senha: 123)

Este projeto está em constante evolução.

O foco é simular um sistema real de empresa para fins de estudo e portfólio.

Novas telas, melhorias visuais e novas funcionalidades ainda serão adicionadas.

Autor

João Gabriel da Rosa Silva
Estudante de Engenharia de Software / Desenvolvimento de Sistemas
