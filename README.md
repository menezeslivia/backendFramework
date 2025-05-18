# API - Gerenciamento de Pessoas (Universidade)

Este projeto consiste em uma API REST desenvolvida com Spring Boot para gerenciar pessoas de uma universidade. A aplicação permite o cadastro, consulta, atualização, remoção e busca personalizada de pessoas, utilizando boas práticas de arquitetura como DTOs, camada de serviço e tratamento de exceções.


## 🛠 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- MySQL
- SLF4J (Logs)
---
## 🔧 Funcionalidades da API

- **POST /api/pessoas**  
  Cadastrar uma nova pessoa.

- **GET /api/pessoas/{id}**  
  Buscar uma pessoa pelo seu ID.

- **PUT /api/pessoas/{id}**  
  Atualizar os dados de uma pessoa existente.

- **DELETE /api/pessoas/{id}**  
  Remover uma pessoa da base de dados.

- **GET /api/pessoas/buscar?nome={nome}&idade={idade}**  
  Buscar todas as pessoas cujo nome começa com o valor informado e cuja idade seja maior que o valor especificado.
---
## 🧱 Arquitetura

- **DTOs**: Uso de `PessoaRequestDTO` e `PessoaResponseDTO` para separar os dados expostos da estrutura interna.
- **Mapper**: Classe `PessoaMapperDTOService` utilizada de forma estática para conversão entre entidades e DTOs.
- **Service**: Toda a lógica de negócio é implementada na classe `PessoaService`, garantindo que o Controller apenas delegue responsabilidades.
- **Controller**: Responsável por receber as requisições e retornar respostas HTTP adequadas.
- **Exceções personalizadas**: Exceção `PessoaNotFoundException` lançada em caso de ID inexistente.
- **Boas práticas**:
  - Injeção de dependência via construtor (`@RequiredArgsConstructor`).
  - Logs informativos com SLF4J (`log.info(...)`).
  - Eliminação de `@Autowired` desnecessário.
  - Acesso ao banco de dados restrito à camada de serviço (Controller não acessa diretamente o `PessoaRepository`).
---
## 🛢️ Configuração do banco de dados (MySQL)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_da_base
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```
Substitua nome_da_base, root e senha pelas credenciais do seu banco local.

📦 Exemplo de Requisição (POST /api/pessoas)
```bash
{
  "nome": "Livia",
  "cpf": "12345678900",
  "idade": 22
}
```
---
👩‍💻 Dupla
- Lívia Janine Menezes Cabral da Silva
- Ystefani Mariana Gomes

