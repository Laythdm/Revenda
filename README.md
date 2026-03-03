# Sistema de Controle de Revenda de Veículos

Este projeto é um sistema web para controle interno de uma pequena revendedora de veículos, permitindo o gerenciamento do estoque de carros, controle de usuários e fluxo básico de venda/dar baixa.

O sistema foi originalmente desenvolvido como Projeto Integrador do curso técnico e está sendo reativado e aprimorado com novas funcionalidades, melhorias estruturais e reforço de segurança, com foco em aprendizado e portfólio.

---

## Objetivo do Sistema

Criar um sistema interno simples que permita a uma revendedora:

- Cadastrar e gerenciar veículos  
- Visualizar o estoque  
- Dar baixa em veículos  
- Controlar acesso por tipo de usuário (Gerente e Vendedor)  
- Simular o fluxo básico de operação de uma loja real  

---

## Funcionalidades Atuais

- Login de usuários  
- Controle de acesso por perfil  
  - GERENTE: cadastrar veículos e dar baixa  
  - VENDEDOR: dar baixa e visualizar  
- Cadastro de carros  
- Listagem de veículos  
- Alteração de status do veículo  
- API REST para testes (Postman)  
- Validações de campos  
- Dashboard inicial  

---

## Usuários de Teste

Ao iniciar o sistema, dois usuários são criados automaticamente:

| Perfil   | Login     | Senha |
|----------|----------|-------|
| GERENTE  | gerente  | 123   |
| VENDEDOR | vendedor | 123   |

---

## Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- Spring Security  
- Thymeleaf  
- MySQL  
- Maven  

---

## Estrutura do Projeto


controller → Controllers MVC e REST
service → Regras de negócio
data → Entidades JPA e Repositórios
config → Configurações de segurança e login
templates → Telas do sistema
static → CSS e recursos estáticos


---

## Como Rodar o Projeto

### Pelo NetBeans (forma utilizada no desenvolvimento)

1. Abra o projeto no NetBeans  
2. Localize a classe:


src/main/java/com/ativ/atividade2/Atividade2Application.java


3. Clique com o botão direito em `Atividade2Application.java`  
4. Selecione **Run File**

---

## Banco de Dados

Banco utilizado: MySQL  
Nome do banco: `Projeto`

Configure usuário e senha do banco em:


src/main/resources/application.properties


### Observação

Se já existirem registros antigos no banco anteriores à adição do campo `cor`, pode haver valores nulos.

Caso ocorra erro, execute:

```sql
UPDATE carro 
SET cor = 'Não informado' 
WHERE cor IS NULL OR cor = '';
Acesso ao Sistema

Perfis disponíveis para teste:

GERENTE — senha: 123

VENDEDOR — senha: 123

Status do Projeto

Este projeto está em constante evolução.

O objetivo é simular um sistema real de empresa para fins de estudo e portfólio. Novas telas, melhorias visuais e funcionalidades adicionais ainda serão implementadas.

Autor

João Gabriel da Rosa Silva
Estudante de Engenharia de Software / Desenvolvimento de Sistemas
