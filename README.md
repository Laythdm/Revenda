# Revenda
Sistema interno simples para controle de estoque de carros e registro de vendas (projeto de estudo / integrador reaproveitado).

## O que mudou nesta atualização (vendas + permissões + ajustes visuais)
Nesta branch eu foquei em duas coisas: **funcionalidade de venda** e **correções/ajustes visuais**.

### Ajustes visuais
- Adicionado **sidebar**.
- Ajuste no **CSS**: A pagina agora possua um tema escuro.

### Correções de bugs
- Correção no controle de **permissões**: antes nenhum perfil conseguia acessar a lista ou registrar venda.

### Funcionalidade nova: Venda de veiculo
- Criado fluxo de **venda** para o perfil VENDEDOR:
  - Botão **Vender** disponivel na tela de estoque (ao lado das ações).
  - Tela de venda para escolher um veiculo **disponível** e preencher dados do cliente:
    - Nome, CPF, RG, número (contato)
    - Valor da venda
    - Metodo de pagamento
  - Apóos confirmar a venda, o veículo passa para o status **VENDIDO**.
- Tela de **histórico de vendas** disponível apenas para o GERENTE, mostrando tambem o usuario que realizou a venda.

### Regras de acesso (roles)
- **VENDEDOR**
  - Pode visualizar o estoque.
  - Pode registrar venda (apenas em veículo disponível).
  - **Não** pode alterar o status manualmente na tabela.
- **GERENTE**
  - Pode visualizar o estoque.
  - Pode alterar status e fazer ações administrativas.
  - É o único que pode lidar com veiculo em status **VENDIDO** (ex: ajuste/correção de status).

### Status do veículo
- Em vez de “Sim/Não”, agora aparece:
  - **Disponível**
  - **Indisponível**
  - **Vendido**

### Campo novo no veículo
- Adicionado o campo **cor** no cadastro.

## Como rodar (do jeito que eu uso no NetBeans)
1. Abra o projeto no NetBeans.
2. Localize a classe:
   `src/main/java/com/ativ/atividade2/Atividade2Application.java`
3. Clique com o botão direito em `Atividade2Application.java` e use **Run File**.

## Banco de dados
- Projeto usando **MySQL**.
- Configure usuário/senha do banco em:
  `src/main/resources/application.properties`

Obs.: se você já tinha carros antigos no banco e adicionou o campo `cor` depois, pode existir registro antigo sem cor.  
Caso dê problema, dá para corrigir rápido com:
```sql
UPDATE carro SET cor = 'Não informado' WHERE cor IS NULL OR cor = '';
```

## Acesso (login)
- Existem dois perfis para teste:
  - GERENTE (senha: 123)
  - VENDEDOR (senha: 123)

## Tecnologias
- Java (Spring Boot, Spring Security, JPA/Hibernate)
- Thymeleaf (HTML)
- CSS
- JavaScript
- MySQL
