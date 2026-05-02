# 🧾 Sistema de Vendas com Emissão de Nota Fiscal

Sistema desktop desenvolvido em Java utilizando Swing para interface gráfica e JDBC para acesso a banco de dados. O sistema permite gerenciar clientes, produtos e emitir notas fiscais com controle de itens, totalização e impressão.

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de aplicar conceitos de:

- Programação Orientada a Objetos (POO)
- Persistência de dados com banco relacional
- Interface gráfica com Java Swing
- Manipulação de eventos e formulários

Um sistema, no contexto da computação, é um conjunto de componentes interligados que trabalham juntos para atingir um objetivo comum :contentReference[oaicite:0]{index=0} — neste caso, o controle de vendas e emissão de notas fiscais.



---

## ⚙️ Tecnologias Utilizadas

- Java
- Java Swing (Interface gráfica) :contentReference[oaicite:1]{index=1}
- JDBC
- MySQL / Banco relacional
- NetBeans IDE
- Git e GitHub

---

## 🧩 Funcionalidades

### 📋 Cadastro
- Cadastro de clientes
- Cadastro de produtos

### 🧾 Nota Fiscal
- Criação de nota fiscal
- Adição de itens
- Cálculo automático de subtotal e total
- Finalização da nota fiscal

### 📊 Consultas
- Listagem de produtos
- Listagem de clientes
- Filtro por nome
- Total de registros exibidos

### 🖨️ Impressão
- Impressão da nota fiscal diretamente pela tabela

---

## 🖥️ Interface do Sistema

O sistema possui interface gráfica construída com Java Swing, permitindo interação amigável com o usuário através de formulários, botões e tabelas.

---

## 📂 Estrutura do Projeto

SistemaVendas/
 ┣ src/
 ┃ ┣ dao/
 ┃ ┃ ┣ Conexao.java
 ┃ ┃ ┣ ClienteDAO.java
 ┃ ┃ ┣ ProdutoDAO.java
 ┃ ┃ ┣ NotaFiscalDAO.java
 ┃ ┃ ┗ ItemNotaFiscalDAO.java
 ┃ ┣ model/
 ┃ ┃ ┣ Cliente.java
 ┃ ┃ ┣ Produto.java
 ┃ ┃ ┣ NotaFiscal.java
 ┃ ┃ ┗ ItemNotaFiscal.java
 ┃ ┣ view/
 ┃ ┃ ┣ TelaPrincipal.java
 ┃ ┃ ┣ FrmCliente.java
 ┃ ┃ ┣ FrmProduto.java
 ┃ ┃ ┣ FrmNotaFiscal.java
 ┃ ┃ ┗ FrmConsultas.java
 ┃ ┗ util/
 ┃   ┗ RelatorioPDF.java
 ┣ nbproject/
 ┣ build.xml
 ┗ README.md

 ## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Matheus5404/Sistema-de-Vendas.git
