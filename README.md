# SistemaVendas

SistemaVendas e um sistema desktop em Java para cadastro de clientes, cadastro de produtos, emissao simples de notas fiscais e consulta de registros. O projeto foi desenvolvido com Java Swing e organizado no padrao usado pelo NetBeans.

## Funcionalidades

- Cadastro de clientes.
- Cadastro de produtos com nome e valor.
- Consulta de clientes e produtos com filtro por nome.
- Criacao de nota fiscal vinculada a um cliente.
- Inclusao de produtos na nota fiscal.
- Calculo e atualizacao do valor total da nota fiscal.
- Impressao da tabela de itens da nota fiscal pela interface Swing.

## Tecnologias utilizadas

- Java 8
- Java Swing
- JDBC
- MySQL
- NetBeans
- MySQL Connector/J
- iText, Jakarta Mail e Jakarta Activation incluidos na pasta `lib`

## Estrutura do projeto

```text
SistemaVendas/
+-- src/
|   +-- dao/              # Classes de acesso ao banco de dados
|   +-- model/            # Classes de modelo
|   +-- sistemavendas/    # Pacote principal criado pelo NetBeans
|   +-- util/             # Utilitarios
|   +-- view/             # Telas Swing do sistema
+-- lib/                  # Bibliotecas JAR usadas pelo projeto
+-- nbproject/            # Configuracoes do NetBeans
+-- build.xml             # Script Ant gerado pelo NetBeans
+-- manifest.mf
```

## Principais telas

- `view.TelaPrincipal`: tela inicial do sistema.
- `view.FrmCliente`: cadastro, listagem, alteracao e exclusao de clientes.
- `view.FrmProduto`: cadastro, listagem, alteracao e exclusao de produtos.
- `view.FrmNotaFiscal`: criacao, preenchimento, finalizacao e impressao de notas fiscais.
- `view.FrmConsultas`: consulta de clientes e produtos.

## Requisitos

Antes de executar o sistema, instale ou configure:

- JDK 8 ou superior.
- NetBeans com suporte a projetos Java Ant.
- MySQL Server em execucao.
- Banco de dados chamado `sistema_vendas`.

A conexao com o banco esta configurada em `src/dao/Conexao.java`:

```java
jdbc:mysql://localhost:3306/sistema_vendas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
usuario: root
senha: vazia
```

Caso seu MySQL use outro usuario ou senha, altere as constantes `USUARIO` e `SENHA` nessa classe.

## Banco de dados

O projeto nao possui um arquivo SQL pronto. Abaixo esta uma estrutura sugerida com base nas consultas usadas pelos DAOs:

```sql
CREATE DATABASE IF NOT EXISTS sistema_vendas;
USE sistema_vendas;

CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS nf (
    nf_id INT AUTO_INCREMENT PRIMARY KEY,
    fk_cliente INT NOT NULL,
    data_emissao DATE NOT NULL,
    valor_total DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (fk_cliente) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS itens_nf (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fk_prod INT NOT NULL,
    fk_nf INT NOT NULL,
    quantidade INT DEFAULT 1,
    valor_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (fk_prod) REFERENCES produto(id),
    FOREIGN KEY (fk_nf) REFERENCES nf(nf_id)
);
```

## Como executar no NetBeans

1. Abra o NetBeans.
2. Clique em `File > Open Project`.
3. Selecione a pasta `SistemaVendas`.
4. Confirme se as bibliotecas da pasta `lib` estao adicionadas ao projeto.
5. Configure a classe principal como:

```text
view.TelaPrincipal
```

6. Execute o projeto.

## Observacoes importantes

- A classe `sistemavendas.SistemaVendas` existe, mas o metodo `main` dela esta vazio. Para abrir o sistema completo, use `view.TelaPrincipal`.
- As classes DAO principais usam as tabelas `cliente`, `produto`, `nf` e `itens_nf`.
- Existem metodos antigos em `FrmNotaFiscal` que citam tabelas chamadas `nota_fiscal` e `item_nota_fiscal`, mas o fluxo principal da tela usa `NotaFiscalDAO` e `ItemNotaFiscalDAO`.
- A tela de nota fiscal depende de clientes e produtos ja cadastrados para preencher os campos de selecao.
- A impressao da nota fiscal usa o recurso de impressao da tabela Swing (`JTable.print`).

## Fluxo basico de uso

1. Cadastre clientes.
2. Cadastre produtos.
3. Abra a tela de nota fiscal.
4. Selecione um cliente e informe a data de emissao.
5. Crie a nota fiscal.
6. Selecione produtos e adicione os itens.
7. Finalize a nota fiscal para atualizar o valor total.
8. Use a opcao de imprimir, se necessario.

## Possiveis melhorias

- Criar um script SQL oficial do banco de dados.
- Ajustar a classe principal do projeto para abrir diretamente `TelaPrincipal`.
- Padronizar os nomes das tabelas usadas na tela de nota fiscal.
- Adicionar validacao de quantidade dos itens da nota fiscal.
- Criar relatorios em PDF usando a biblioteca iText ja presente no projeto.
- Remover bibliotecas duplicadas ou nao utilizadas da pasta `lib`.
