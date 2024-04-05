# Microserviço de usuários

## Arquitetura de Ports and Adapters

### Tecnologias usadas
- ![PostgreSQL](https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg) PostgreSQL
- ![Spring Boot](https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg) Spring Boot
- ![RabbitMQ](https://upload.wikimedia.org/wikipedia/commons/7/71/RabbitMQ_logo.svg) RabbitMQ

### Rotas

#### Criar Usuário
- **POST /**: Cria um novo usuário.
  - Payload: `CreateUserRecordDto` com campos `email` (Email do usuário, obrigatório e deve ser válido) e `name` (Nome do usuário, obrigatório).

#### Listar Todos os Usuários
- **GET /**: Retorna todos os usuários cadastrados.

#### Buscar Usuário por ID
- **GET /{id}**: Busca um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).

#### Atualizar Usuário por ID
- **PATCH /{id}**: Atualiza dados de um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).
  - Payload: `UpdateUserRecordDto` com campos `email` (novo email do usuário, opcional) e `name` (novo nome do usuário, opcional).

#### Deletar Usuário por ID
- **DELETE /{id}**: Deleta um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).

### TODO
- [ ] Configuração detalhada do ambiente de desenvolvimento.
- [ ] Guia de instalação e execução do projeto.
- [ ] Documentação da API com exemplos de requisições e respostas.
- [ ] Descrição detalhada da arquitetura e design do sistema.
- [ ] Estratégias de teste e qualidade de código.
- [ ] Estratégias de segurança e autenticação.