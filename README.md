# 🥗 Sistema Fit - Gestão de Alimentação Fitness

<p align="center">
  <img src="https://i.pinimg.com/originals/9b/d6/c6/9bd6c6cc39a44f007d675e34f4ad7f22.gif" width="600">
</p>

---

# 📌 Sistema Fit

Projeto backend desenvolvido com Java e Spring Boot para gerenciamento de usuários, categorias e alimentos em um sistema de alimentação fitness.

---

## 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Git & GitHub
* Insomnia
* STS / Eclipse

---

# 📚 Table of Contents

* 📌 About
* 🚀 Features
* 👓 Conceitos Aplicados
* 📕 Installation
* 🎮 Getting Started
* 🔄 Endpoints
* 🌐 Technologies
* 👥 Team
* 📝 License

---

# 📌 About

O **Sistema Fit** é uma API REST desenvolvida para auxiliar no gerenciamento de alimentação fitness, permitindo o controle de usuários, categorias de alimentos e alimentos cadastrados no sistema.

A aplicação foi construída com Java e Spring Boot, seguindo a arquitetura MVC e utilizando MySQL como banco de dados.

O sistema permite:

* Cadastro de usuários
* Cadastro de categorias de alimentos
* Cadastro de alimentos
* Consulta de registros
* Atualização de dados
* Exclusão de registros
* Relacionamento entre entidades

---

# 🚀 Features

## Funcionalidades do Projeto

### Usuário

* CRUD completo de usuários

### Categoria

* CRUD completo de categorias de alimentos

### Alimento

* CRUD completo de alimentos
* Associação com categoria
* Associação com usuário

### API

* API REST
* Integração com MySQL
* Validação de dados
* Persistência com Spring Data JPA

---

# 👓 Conceitos Aplicados

* Arquitetura MVC
* API REST
* CRUD com Spring Boot
* JPA/Hibernate
* Relacionamento entre entidades
* Banco de dados MySQL
* Organização em camadas
* Versionamento com Git e GitHub
* Validação de dados (Bean Validation)
* Testes de API com Insomnia

---

# 📕 Installation

## Pré-requisitos

* Java JDK
* Maven
* MySQL
* STS ou Eclipse

---

## Instalação do Projeto

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

---

### 2. Criar o banco de dados

```sql
CREATE DATABASE db_sistema_fit;
```

---

### 3. Configurar o application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost/db_sistema_fit
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
```

---

### 4. Executar a aplicação

Abra o projeto na IDE e execute a classe principal do Spring Boot.

---

# 🎮 Getting Started

Após iniciar a aplicação, o backend estará rodando localmente.

Você pode testar os endpoints utilizando o Insomnia ou Postman.

Exemplo:

```http
GET http://localhost:8080/alimentos
```

---

# 🔄 Endpoints

## Usuários

### CREATE

```http
POST /usuarios
```

### READ

```http
GET /usuarios
GET /usuarios/{id}
```

### UPDATE

```http
PUT /usuarios
```

### DELETE

```http
DELETE /usuarios/{id}
```

---

## Categorias

### CREATE

```http
POST /categorias
```

### READ

```http
GET /categorias
GET /categorias/{id}
```

### UPDATE

```http
PUT /categorias
```

### DELETE

```http
DELETE /categorias/{id}
```

---

## Alimentos

### CREATE

```http
POST /alimentos
```

### READ

```http
GET /alimentos
GET /alimentos/{id}
```

### UPDATE

```http
PUT /alimentos
```

### DELETE

```http
DELETE /alimentos/{id}
```

---

# 📨 Exemplo de Requisição

## Cadastro de Alimento

```json
{
  "nome": "Frango Grelhado",
  "descricao": "Peito de frango grelhado sem óleo",
  "calorias": 165,
  "categoria": "Proteínas"
}
```

---

# 🌐 Technologies

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* GitHub
* Insomnia

---

# 👥 Team

| Integrantes        |
| ------------------ |
| Giovanna Mendes    |
| Bianca Casagrande  |
| Jhonatan Oliveira  |
| Dayane Santana     |
| Isabella Rodrigues |
| Rafael Scherer     |

---

# 📝 License

Este projeto foi desenvolvido para fins educacionais como parte do Projeto Integrador da Generation Brasil.

---

## 📚 Documentação

[Documento do Projeto](https://docs.google.com/document/d/e/2PACX-1vRgYcVGWTPNlH-rF_K200OnHdfjU3vdCDHpKQ1UeQixHcndgsuwvqaauxEWCk5o8oU_j7Vb9hOeQyY5/pub)

---

# 🔗 Repositório

[Projeto Integrador - Sistema Fit](https://github.com/Projeto-Integrador-Grupo-06/sistema-fit)
