# API - Gerenciamento de Pessoas (Universidade)

Este projeto consiste em uma API desenvolvida com Spring Boot para gerenciar pessoas de uma universidade.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok

## Funcionalidades

- **POST /pessoas**: Cadastrar uma nova pessoa na base de dados.
- **GET /pessoas/{id}**: Buscar uma pessoa pelo seu ID.

## Configuração do banco de dados (MySQL)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_da_base
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```
## Dupla:

- Lívia Janine Menezes Cabral da Silva
- Ystefane
