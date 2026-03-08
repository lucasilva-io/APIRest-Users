# API REST - Gerenciamento de Usuários

API REST para gerenciamento de usuários com operações CRUD, desenvolvida com Spring Boot e integração com SQL Server.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- SQL Server
- Lombok
- Maven

## Requisitos

- JDK 17+
- Maven
- SQL Server com autenticação habilitada
- SQL Server Management Studio (opcional)

## Configuração do Banco de Dados

Execute no SQL Server:

```sql
CREATE DATABASE db_system;
USE db_system;

CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME2(0)
);
```

## Configuração da Aplicação

Configure o arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=system
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=db_system;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.ddl-auto=update
```

## Como Rodar

```bash
git clone https://github.com/lucasilva-io/APIRest-Users.git
cd APIRest-Users
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/system/all` | Retorna todos os usuários |
| POST | `/system` | Cadastra um novo usuário |
| PUT | `/system/{id}` | Atualiza um usuário pelo ID |
| PATCH | `/system/{id}` | Atualiza um dado específico do usuário pelo ID |
| DELETE | `/system/all` | Remove todos os usuários da tabela |
| DELETE BY ID | `/system/{id}` | Remove um usuário pelo ID |

## Exemplos de Requisição

**POST** `/system`
```json
{
    "name": "João Silva",
    "login": "jsilva",
    "email": "joao.silva@email.com",
    "password": "senha123"
}
```

**PUT** `/system/1`
```json
{
    "name": "João Silva Atualizado",
    "login": "jsilva",
    "email": "joao.novo@email.com",
    "password": "novaSenha123"
}
```

> A data de criação é gerada automaticamente no momento do cadastro.
